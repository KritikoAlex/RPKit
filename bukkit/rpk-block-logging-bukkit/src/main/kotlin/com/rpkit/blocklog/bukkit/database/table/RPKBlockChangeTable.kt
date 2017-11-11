package com.rpkit.blocklog.bukkit.database.table

import com.rpkit.blocklog.bukkit.RPKBlockLoggingBukkit
import com.rpkit.blocklog.bukkit.block.RPKBlockChange
import com.rpkit.blocklog.bukkit.block.RPKBlockChangeImpl
import com.rpkit.blocklog.bukkit.block.RPKBlockHistory
import com.rpkit.blocklog.bukkit.block.RPKBlockHistoryProvider
import com.rpkit.blocklog.bukkit.database.jooq.rpkit.Tables.RPKIT_BLOCK_CHANGE
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import com.rpkit.players.bukkit.profile.RPKProfileProvider
import org.bukkit.Material
import org.jooq.SQLDialect
import org.jooq.impl.DSL.constraint
import org.jooq.impl.SQLDataType
import org.jooq.util.sqlite.SQLiteDataType
import java.sql.Timestamp

class RPKBlockChangeTable(database: Database, private val plugin: RPKBlockLoggingBukkit): Table<RPKBlockChange>(database, RPKBlockChange::class) {

    override fun create() {
        database.create
                .createTableIfNotExists(RPKIT_BLOCK_CHANGE)
                .column(RPKIT_BLOCK_CHANGE.ID,
                        if (database.dialect == SQLDialect.SQLITE)
                            SQLiteDataType.INTEGER.identity(true)
                        else
                            SQLDataType.INTEGER.identity(true)
                )
                .column(RPKIT_BLOCK_CHANGE.BLOCK_HISTORY_ID, SQLDataType.INTEGER)
                .column(RPKIT_BLOCK_CHANGE.TIME, SQLDataType.TIMESTAMP)
                .column(RPKIT_BLOCK_CHANGE.PROFILE_ID, SQLDataType.INTEGER)
                .column(RPKIT_BLOCK_CHANGE.MINECRAFT_PROFILE_ID, SQLDataType.INTEGER)
                .column(RPKIT_BLOCK_CHANGE.CHARACTER_ID, SQLDataType.INTEGER)
                .column(RPKIT_BLOCK_CHANGE.FROM, SQLDataType.VARCHAR(256))
                .column(RPKIT_BLOCK_CHANGE.FROM_DATA, SQLDataType.TINYINT)
                .column(RPKIT_BLOCK_CHANGE.TO, SQLDataType.VARCHAR(256))
                .column(RPKIT_BLOCK_CHANGE.TO_DATA, SQLDataType.TINYINT)
                .column(RPKIT_BLOCK_CHANGE.REASON, SQLDataType.VARCHAR(256))
                .constraints(
                        constraint("pk_rpkit_block_change").primaryKey(RPKIT_BLOCK_CHANGE.ID)
                )
                .execute()
    }

    override fun applyMigrations() {
        if (database.getTableVersion(this) == null) {
            database.setTableVersion(this, "1.4.0")
        }
    }

    override fun insert(entity: RPKBlockChange): Int {
        database.create
                .insertInto(
                        RPKIT_BLOCK_CHANGE,
                        RPKIT_BLOCK_CHANGE.BLOCK_HISTORY_ID,
                        RPKIT_BLOCK_CHANGE.TIME,
                        RPKIT_BLOCK_CHANGE.PROFILE_ID,
                        RPKIT_BLOCK_CHANGE.MINECRAFT_PROFILE_ID,
                        RPKIT_BLOCK_CHANGE.CHARACTER_ID,
                        RPKIT_BLOCK_CHANGE.FROM,
                        RPKIT_BLOCK_CHANGE.FROM_DATA,
                        RPKIT_BLOCK_CHANGE.TO,
                        RPKIT_BLOCK_CHANGE.TO_DATA,
                        RPKIT_BLOCK_CHANGE.REASON
                )
                .values(
                        entity.blockHistory.id,
                        Timestamp(entity.time),
                        entity.profile?.id,
                        entity.minecraftProfile?.id,
                        entity.character?.id,
                        entity.from.toString(),
                        entity.fromData,
                        entity.to.toString(),
                        entity.toData,
                        entity.reason
                )
                .execute()
        val id = database.create.lastID().toInt()
        entity.id = id
        return id
    }

    override fun update(entity: RPKBlockChange) {
        database.create
                .update(RPKIT_BLOCK_CHANGE)
                .set(RPKIT_BLOCK_CHANGE.BLOCK_HISTORY_ID, entity.blockHistory.id)
                .set(RPKIT_BLOCK_CHANGE.TIME, Timestamp(entity.time))
                .set(RPKIT_BLOCK_CHANGE.PROFILE_ID, entity.profile?.id)
                .set(RPKIT_BLOCK_CHANGE.MINECRAFT_PROFILE_ID, entity.minecraftProfile?.id)
                .set(RPKIT_BLOCK_CHANGE.CHARACTER_ID, entity.character?.id)
                .set(RPKIT_BLOCK_CHANGE.FROM, entity.from.toString())
                .set(RPKIT_BLOCK_CHANGE.FROM_DATA, entity.fromData)
                .set(RPKIT_BLOCK_CHANGE.TO, entity.to.toString())
                .set(RPKIT_BLOCK_CHANGE.TO_DATA, entity.toData)
                .set(RPKIT_BLOCK_CHANGE.REASON, entity.reason)
                .where(RPKIT_BLOCK_CHANGE.ID.eq(entity.id))
                .execute()
    }

    override fun get(id: Int): RPKBlockChange? {
        val result = database.create
                .select(
                        RPKIT_BLOCK_CHANGE.BLOCK_HISTORY_ID,
                        RPKIT_BLOCK_CHANGE.TIME,
                        RPKIT_BLOCK_CHANGE.PROFILE_ID,
                        RPKIT_BLOCK_CHANGE.MINECRAFT_PROFILE_ID,
                        RPKIT_BLOCK_CHANGE.CHARACTER_ID,
                        RPKIT_BLOCK_CHANGE.FROM,
                        RPKIT_BLOCK_CHANGE.FROM_DATA,
                        RPKIT_BLOCK_CHANGE.TO,
                        RPKIT_BLOCK_CHANGE.TO_DATA,
                        RPKIT_BLOCK_CHANGE.REASON
                )
                .from(RPKIT_BLOCK_CHANGE)
                .where(RPKIT_BLOCK_CHANGE.ID.eq(id))
                .fetchOne() ?: return null
        val blockHistoryProvider = plugin.core.serviceManager.getServiceProvider(RPKBlockHistoryProvider::class)
        val blockHistoryId = result.get(RPKIT_BLOCK_CHANGE.BLOCK_HISTORY_ID)
        val blockHistory = blockHistoryProvider.getBlockHistory(blockHistoryId)
        if (blockHistory == null) {
            database.create
                    .deleteFrom(RPKIT_BLOCK_CHANGE)
                    .where(RPKIT_BLOCK_CHANGE.ID.eq(id))
                    .execute()
            return null
        }
        val profileProvider = plugin.core.serviceManager.getServiceProvider(RPKProfileProvider::class)
        val profileId = result.get(RPKIT_BLOCK_CHANGE.PROFILE_ID)
        val profile = if (profileId == null) null else profileProvider.getProfile(profileId)
        val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
        val minecraftProfileId = result.get(RPKIT_BLOCK_CHANGE.MINECRAFT_PROFILE_ID)
        val minecraftProfile = if (minecraftProfileId == null) null else minecraftProfileProvider.getMinecraftProfile(minecraftProfileId)
        val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
        val characterId = result.get(RPKIT_BLOCK_CHANGE.CHARACTER_ID)
        val character = if (characterId == null) null else characterProvider.getCharacter(characterId)
        return RPKBlockChangeImpl(
                id,
                blockHistory,
                result.get(RPKIT_BLOCK_CHANGE.TIME).time,
                profile,
                minecraftProfile,
                character,
                Material.getMaterial(result.get(RPKIT_BLOCK_CHANGE.FROM)),
                result.get(RPKIT_BLOCK_CHANGE.FROM_DATA),
                Material.getMaterial(result.get(RPKIT_BLOCK_CHANGE.TO)),
                result.get(RPKIT_BLOCK_CHANGE.TO_DATA),
                result.get(RPKIT_BLOCK_CHANGE.REASON)
        )
    }

    fun get(blockHistory: RPKBlockHistory): List<RPKBlockChange> {
        val results = database.create
                .select(RPKIT_BLOCK_CHANGE.ID)
                .from(RPKIT_BLOCK_CHANGE)
                .where(RPKIT_BLOCK_CHANGE.BLOCK_HISTORY_ID.eq(blockHistory.id))
                .fetch()
        return results
                .map { result -> get(result.get(RPKIT_BLOCK_CHANGE.ID)) }
                .filterNotNull()
    }

    override fun delete(entity: RPKBlockChange) {
        database.create
                .deleteFrom(RPKIT_BLOCK_CHANGE)
                .where(RPKIT_BLOCK_CHANGE.ID.eq(entity.id))
                .execute()
    }
}