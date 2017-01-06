/*
 * Copyright 2016 Ross Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.economy.bukkit.database.table

import com.rpkit.characters.bukkit.character.RPKCharacter
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.core.database.use
import com.rpkit.economy.bukkit.RPKEconomyBukkit
import com.rpkit.economy.bukkit.currency.RPKCurrency
import com.rpkit.economy.bukkit.currency.RPKCurrencyProvider
import com.rpkit.economy.bukkit.wallet.RPKWallet
import org.ehcache.Cache
import org.ehcache.CacheManager
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.CacheManagerBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder
import java.sql.PreparedStatement
import java.sql.Statement.RETURN_GENERATED_KEYS
import java.util.*

/**
 * Represents the wallet table.
 */
class RPKWalletTable(database: Database, private val plugin: RPKEconomyBukkit) : Table<RPKWallet>(database, RPKWallet::class.java) {

    private val cacheManager: CacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true)
    private val cache: Cache<Int, RPKWallet> = cacheManager.createCache("cache",
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Int::class.javaObjectType, RPKWallet::class.java,
                    ResourcePoolsBuilder.heap(plugin.server.maxPlayers.toLong())).build())
    private val characterCache: Cache<Int, MutableMap<*, *>> = cacheManager.createCache("characterCache",
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Int::class.javaObjectType, MutableMap::class.java,
                    ResourcePoolsBuilder.heap(plugin.server.maxPlayers.toLong())).build())

    override fun create() {
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS rpkit_wallet (" +
                            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                            "character_id INTEGER," +
                            "currency_id INTEGER," +
                            "balance INTEGER" +
                    ")"
            ).use(PreparedStatement::executeUpdate)
        }
    }

    override fun applyMigrations() {
        if (database.getTableVersion(this) == null) {
            database.setTableVersion(this, "0.2.0")
        }
    }

    override fun insert(entity: RPKWallet): Int {
        var id = 0
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "INSERT INTO rpkit_wallet(character_id, currency_id, balance) VALUES(?, ?, ?)",
                    RETURN_GENERATED_KEYS
            ).use { statement ->
                statement.setInt(1, entity.character.id)
                statement.setInt(2, entity.currency.id)
                statement.setInt(3, entity.balance)
                statement.executeUpdate()
                val generatedKeys = statement.generatedKeys
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1)
                    entity.id = id
                    cache.put(id, entity)
                    val currencyWallets = characterCache.get(entity.character.id)?:mutableMapOf<Int, Int>()
                    (currencyWallets as MutableMap<Int, Int>).put(entity.currency.id, entity.id)
                    characterCache.put(entity.character.id, currencyWallets)
                }
            }
        }
        return id
    }

    override fun update(entity: RPKWallet) {
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "UPDATE rpkit_wallet SET character_id = ?, currency_id = ?, balance = ? WHERE id = ?"
            ).use { statement ->
                statement.setInt(1, entity.character.id)
                statement.setInt(2, entity.currency.id)
                statement.setInt(3, entity.balance)
                statement.setInt(4, entity.id)
                statement.executeUpdate()
                cache.put(entity.id, entity)
                val currencyWallets = characterCache.get(entity.character.id)?:mutableMapOf<Int, Int>()
                (currencyWallets as MutableMap<Int, Int>).put(entity.currency.id, entity.id)
                characterCache.put(entity.character.id, currencyWallets)
            }
        }
    }

    override fun get(id: Int): RPKWallet? {
        if (cache.containsKey(id)) {
            return cache.get(id)
        } else {
            var wallet: RPKWallet? = null
            database.createConnection().use { connection ->
                connection.prepareStatement(
                        "SELECT id, character_id, currency_id, balance FROM rpkit_wallet WHERE id = ? LIMIT 1"
                ).use { statement ->
                    statement.setInt(1, id)
                    val resultSet = statement.executeQuery()
                    if (resultSet.next()) {
                        wallet = RPKWallet(
                                id = resultSet.getInt("id"),
                                character = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class).getCharacter(resultSet.getInt("character_id"))!!,
                                currency = plugin.core.serviceManager.getServiceProvider(RPKCurrencyProvider::class).getCurrency(resultSet.getInt("currency_id"))!!,
                                balance = resultSet.getInt("balance")
                        )
                        cache.put(id, wallet)
                    }
                }
            }
            return wallet
        }
    }

    fun get(character: RPKCharacter, currency: RPKCurrency): RPKWallet {
        if (characterCache.containsKey(character.id)) {
            val characterWallets = characterCache[character.id]
            if (characterWallets.containsKey(currency.id)) {
                return get(characterCache[character.id][currency.id] as Int)!!
            }
        }
        var wallet: RPKWallet? = null
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "SELECT id, character_id, currency_id, balance FROM rpkit_wallet WHERE character_id = ? AND currency_id = ?"
            ).use { statement ->
                statement.setInt(1, character.id)
                statement.setInt(2, currency.id)
                val resultSet = statement.executeQuery()
                if (resultSet.next()) {
                    val id = resultSet.getInt("id")
                    val characterId = resultSet.getInt("character_id")
                    val currencyId = resultSet.getInt("currency_id")
                    val balance = resultSet.getInt("balance")
                    wallet = RPKWallet(
                            id = id,
                            character = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class).getCharacter(characterId)!!,
                            currency = plugin.core.serviceManager.getServiceProvider(RPKCurrencyProvider::class).getCurrency(currencyId)!!,
                            balance = balance
                    )
                    val finalWallet = wallet!!
                    cache.put(id, finalWallet)
                    val characterWallets: MutableMap<Int, Int>
                    if (characterCache.containsKey(characterId)) {
                        characterWallets = characterCache[characterId] as MutableMap<Int, Int>
                    } else {
                        characterWallets = HashMap<Int, Int>()
                    }
                    characterWallets.put(currencyId, finalWallet.id)
                    characterCache.put(characterId, characterWallets)
                }
            }
        }
        if (wallet == null) {
            val finalWallet = RPKWallet(
                    character = character,
                    currency = currency,
                    balance = currency.defaultAmount
            )
            insert(finalWallet)
            wallet = finalWallet
        }
        val finalWallet = wallet!!
        return finalWallet
    }

    fun getTop(amount: Int = 5, currency: RPKCurrency): List<RPKCharacter> {
        val top = ArrayList<RPKWallet>()
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "SELECT id FROM rpkit_wallet WHERE currency_id = ? ORDER BY balance LIMIT ?"
            ).use { statement ->
                statement.setInt(1, currency.id)
                statement.setInt(2, amount)
                val resultSet = statement.executeQuery()
                while (resultSet.next()) {
                    val wallet = get(resultSet.getInt("id"))
                    if (wallet != null) {
                        top.add(wallet)
                    }
                }
            }
        }
        return top.map(RPKWallet::character)
    }

    override fun delete(entity: RPKWallet) {
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "DELETE FROM rpkit_wallet WHERE id = ?"
            ).use { statement ->
                statement.setInt(1, entity.id)
                statement.executeUpdate()
                cache.remove(entity.id)
                val characterId = entity.character.id
                characterCache[characterId].remove(entity.currency.id)
                if (characterCache[characterId].isEmpty()) {
                    characterCache.remove(characterId)
                }
            }
        }
    }

}