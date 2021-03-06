/*
 * Copyright 2020 Ren Binden
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

package com.rpkit.unconsciousness.bukkit

import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.core.bukkit.plugin.RPKBukkitPlugin
import com.rpkit.core.database.Database
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import com.rpkit.unconsciousness.bukkit.command.WakeCommand
import com.rpkit.unconsciousness.bukkit.database.table.RPKUnconsciousStateTable
import com.rpkit.unconsciousness.bukkit.listener.EntityDamageByEntityListener
import com.rpkit.unconsciousness.bukkit.listener.EntityDamageListener
import com.rpkit.unconsciousness.bukkit.listener.EntityTargetListener
import com.rpkit.unconsciousness.bukkit.listener.PlayerCommandPreprocessListener
import com.rpkit.unconsciousness.bukkit.listener.PlayerDeathListener
import com.rpkit.unconsciousness.bukkit.listener.PlayerInteractEntityListener
import com.rpkit.unconsciousness.bukkit.listener.PlayerInteractListener
import com.rpkit.unconsciousness.bukkit.listener.PlayerJoinListener
import com.rpkit.unconsciousness.bukkit.listener.PlayerMoveListener
import com.rpkit.unconsciousness.bukkit.listener.PlayerRespawnListener
import com.rpkit.unconsciousness.bukkit.unconsciousness.RPKUnconsciousnessProvider
import com.rpkit.unconsciousness.bukkit.unconsciousness.RPKUnconsciousnessProviderImpl
import org.bstats.bukkit.Metrics
import org.bukkit.GameRule.KEEP_INVENTORY
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class RPKUnconsciousnessBukkit: RPKBukkitPlugin() {

    override fun onEnable() {
        Metrics(this, 4425)
        saveDefaultConfig()
        serviceProviders = arrayOf(
                RPKUnconsciousnessProviderImpl(this)
        )
        object: BukkitRunnable() {
            override fun run() {
                val minecraftProfileProvider = core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                val characterProvider = core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val unconsciousnessProvider = core.serviceManager.getServiceProvider(RPKUnconsciousnessProvider::class)
                server.onlinePlayers.forEach { bukkitPlayer ->
                    val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(bukkitPlayer)
                    if (minecraftProfile != null) {
                        val character = characterProvider.getActiveCharacter(minecraftProfile)
                        if (character != null) {
                            if (!unconsciousnessProvider.isUnconscious(character)) {
                                bukkitPlayer.addPotionEffect(
                                        PotionEffect(PotionEffectType.BLINDNESS, 0, 0),
                                        true
                                )
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(this, 200L, 200L)
        server.worlds.forEach { world ->
            world.setGameRule(KEEP_INVENTORY, true)
        }
    }

    override fun registerCommands() {
        getCommand("wake")?.setExecutor(WakeCommand(this))
    }

    override fun registerListeners() {
        registerListeners(
                PlayerDeathListener(this),
                PlayerRespawnListener(this),
                PlayerMoveListener(this),
                PlayerInteractEntityListener(this),
                PlayerCommandPreprocessListener(this),
                EntityDamageListener(this),
                EntityTargetListener(this),
                PlayerJoinListener(this),
                PlayerInteractListener(this),
                EntityDamageByEntityListener(this)
        )
    }

    override fun createTables(database: Database) {
        database.addTable(RPKUnconsciousStateTable(database, this))
    }

    override fun setDefaultMessages() {
        messages.setDefault("unconscious-command-blocked", "&cYou are not permitted to use that command while unconscious.")
        messages.setDefault("wake-success", "&aWoke \$character.")
        messages.setDefault("wake-already-awake", "&c\$character is already awake.")
        messages.setDefault("no-permission-wake", "&cYou do not have permission to wake people up.")
        messages.setDefault("no-character-other", "&c\$player does not have an active character.")
        messages.setDefault("no-minecraft-profile-other", "&c\$player does not have a Minecraft profile.")
    }

}
