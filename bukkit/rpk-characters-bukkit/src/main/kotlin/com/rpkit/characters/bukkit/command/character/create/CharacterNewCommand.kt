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

package com.rpkit.characters.bukkit.command.character.create

import com.rpkit.characters.bukkit.RPKCharactersBukkit
import com.rpkit.characters.bukkit.character.RPKCharacterImpl
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.characters.bukkit.newcharactercooldown.RPKNewCharacterCooldownProvider
import com.rpkit.players.bukkit.player.RPKPlayerProvider
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import com.rpkit.players.bukkit.profile.RPKProfile
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Character new command.
 * Creates a new character, then allows the player to modify fields from the defaults (specified in the config).
 */
class CharacterNewCommand(private val plugin: RPKCharactersBukkit): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission("rpkit.characters.command.character.new")) {
                val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val newCharacterCooldownProvider = plugin.core.serviceManager.getServiceProvider(RPKNewCharacterCooldownProvider::class)
                val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(sender)
                val player = playerProvider.getPlayer(sender)
                if (minecraftProfile != null) {
                    val profile = minecraftProfile.profile
                    if (profile is RPKProfile) {
                        if (sender.hasPermission("rpkit.characters.command.character.new.nocooldown") || newCharacterCooldownProvider.getNewCharacterCooldown(profile) <= 0) {
                            val character = RPKCharacterImpl(plugin, player = player, profile = profile)
                            characterProvider.addCharacter(character)
                            characterProvider.setActiveCharacter(minecraftProfile, character)
                            newCharacterCooldownProvider.setNewCharacterCooldown(profile, plugin.config.getLong("characters.new-character-cooldown"))
                            sender.sendMessage(plugin.messages["character-new-valid"])
                            character.showCharacterCard(minecraftProfile)
                        } else {
                            sender.sendMessage(plugin.messages["character-new-invalid-cooldown"])
                        }
                    } else {
                        sender.sendMessage(plugin.messages["no-profile"])
                    }
                } else {
                    sender.sendMessage(plugin.messages["no-minecraft-profile"])
                }
            } else {
                sender.sendMessage(plugin.messages["no-permission-character-new"])
            }
        } else {
            sender.sendMessage(plugin.messages["not-from-console"])
        }
        return true
    }

}
