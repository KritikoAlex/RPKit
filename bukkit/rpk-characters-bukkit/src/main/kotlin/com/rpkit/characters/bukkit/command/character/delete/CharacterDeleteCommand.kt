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

package com.rpkit.characters.bukkit.command.character.delete

import com.rpkit.characters.bukkit.RPKCharactersBukkit
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import com.rpkit.players.bukkit.profile.RPKProfile
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.conversations.*
import org.bukkit.entity.Player

/**
 * Character delete command.
 * Deletes a character.
 */
class CharacterDeleteCommand(private val plugin: RPKCharactersBukkit): CommandExecutor {
    private val conversationFactory: ConversationFactory
    private val confirmationConversationFactory: ConversationFactory

    init {
        conversationFactory = ConversationFactory(plugin)
                .withModality(true)
                .withFirstPrompt(CharacterPrompt())
                .withEscapeSequence("cancel")
                .thatExcludesNonPlayersWithMessage(plugin.messages["not-from-console"])
                .addConversationAbandonedListener { event ->
            if (!event.gracefulExit()) {
                val conversable = event.context.forWhom
                if (conversable is Player) {
                    conversable.sendMessage(plugin.messages["operation-cancelled"])
                }
            }
        }
        confirmationConversationFactory = ConversationFactory(plugin)
                .withModality(true)
                .withFirstPrompt(ConfirmationPrompt())
                .withEscapeSequence("cancel")
                .thatExcludesNonPlayersWithMessage(plugin.messages["not-from-console"])
                .addConversationAbandonedListener { event ->
            if (!event.gracefulExit()) {
                val conversable = event.context.forWhom
                if (conversable is Player) {
                    conversable.sendMessage(plugin.messages["operation-cancelled"])
                }
            }
        }
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission("rpkit.characters.command.character.delete")) {
                if (args.isNotEmpty()) {
                    val characterNameBuilder = StringBuilder()
                    for (i in 0 until args.size - 1) {
                        characterNameBuilder.append(args[i]).append(" ")
                    }
                    characterNameBuilder.append(args[args.size - 1])
                    val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                    val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                    val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(sender)
                    if (minecraftProfile != null) {
                        val profile = minecraftProfile.profile
                        if (profile is RPKProfile) {
                            var charFound = false
                            // Prioritise exact matches...
                            for (character in characterProvider.getCharacters(profile)) {
                                if (character.name.equals(characterNameBuilder.toString(), ignoreCase = true)) {
                                    val conversation = confirmationConversationFactory.buildConversation(sender)
                                    conversation.context.setSessionData("character_id", character.id)
                                    conversation.begin()
                                    charFound = true
                                    break
                                }
                            }
                            // And fall back to partial matches
                            if (!charFound) {
                                for (character in characterProvider.getCharacters(profile)) {
                                    if (character.name.toLowerCase().contains(characterNameBuilder.toString().toLowerCase())) {
                                        val conversation = confirmationConversationFactory.buildConversation(sender)
                                        conversation.context.setSessionData("character_id", character.id)
                                        conversation.begin()
                                        charFound = true
                                        break
                                    }
                                }
                            }
                            if (charFound) {
                                sender.sendMessage(plugin.messages["character-delete-valid"])
                            } else {
                                sender.sendMessage(plugin.messages["character-delete-invalid-character"])
                            }
                        } else {
                            sender.sendMessage(plugin.messages["no-profile"])
                        }
                    } else {
                        sender.sendMessage(plugin.messages["no-minecraft-profile"])
                    }
                } else {
                    conversationFactory.buildConversation(sender).begin()
                }
            } else {
                sender.sendMessage(plugin.messages["no-permission-character-delete"])
            }
        } else {
            sender.sendMessage(plugin.messages["not-from-console"])
        }
        return true
    }

    private inner class CharacterPrompt: ValidatingPrompt() {

        override fun isInputValid(context: ConversationContext, input: String): Boolean {
            val conversable = context.forWhom
            if (conversable is Player) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(conversable)
                if (minecraftProfile != null) {
                    val profile = minecraftProfile.profile
                    if (profile is RPKProfile) {
                        repeat(characterProvider.getCharacters(profile)
                                .filter { it.name.equals(input, ignoreCase = true) }.size) { return true }
                        repeat(characterProvider.getCharacters(profile)
                                .filter { it.name.toLowerCase().contains(input.toLowerCase()) }.size) { return true }
                    }
                }
            }
            return false
        }

        override fun acceptValidatedInput(context: ConversationContext, input: String): Prompt {
            val conversable = context.forWhom
            if (conversable is Player) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(conversable)
                if (minecraftProfile != null) {
                    val profile = minecraftProfile.profile
                    if (profile is RPKProfile) {
                        var charFound = false
                        // Prioritise exact matches...
                        for (character in characterProvider.getCharacters(profile)) {
                            if (character.name.equals(input, ignoreCase = true)) {
                                context.setSessionData("character_id", character.id)
                                charFound = true
                                break
                            }
                        }
                        // And fall back to partial matches
                        if (!charFound) {
                            for (character in characterProvider.getCharacters(profile)) {
                                if (character.name.toLowerCase().contains(input.toLowerCase())) {
                                    context.setSessionData("character_id", character.id)
                                    break
                                }
                            }
                        }
                        return ConfirmationPrompt()
                    } else {
                        return END_OF_CONVERSATION
                    }
                } else {
                    return END_OF_CONVERSATION
                }
            } else {
                return END_OF_CONVERSATION
            }
        }

        override fun getFailedValidationText(context: ConversationContext, invalidInput: String): String {
            return plugin.messages["character-delete-invalid-character"]
        }

        override fun getPromptText(context: ConversationContext): String {
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(context.forWhom as Player)
            if (minecraftProfile != null) {
                val profile = minecraftProfile.profile
                return if (profile is RPKProfile) {
                    val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                    val characterListBuilder = StringBuilder()
                    for (character in characterProvider.getCharacters(profile)) {
                        characterListBuilder.append("\n").append(
                                plugin.messages["character-list-item", mapOf(
                                        Pair("character", character.name))]
                        )
                    }
                    plugin.messages["character-delete-prompt"] + characterListBuilder.toString()
                } else {
                    plugin.messages["no-profile"]
                }
            } else {
                return plugin.messages["no-minecraft-profile"]
            }
        }

    }

    private inner class ConfirmationPrompt: BooleanPrompt() {

        override fun acceptValidatedInput(context: ConversationContext, input: Boolean): Prompt? {
            return if (input) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val character = characterProvider.getCharacter(context.getSessionData("character_id") as Int)
                if (character != null) {
                    characterProvider.removeCharacter(character)
                }
                CharacterDeletedPrompt()
            } else {
                END_OF_CONVERSATION
            }
        }

        override fun getFailedValidationText(context: ConversationContext, invalidInput: String): String {
            return plugin.messages["character-delete-confirmation-invalid-boolean"]
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["character-delete-confirmation"]
        }

    }

    private inner class CharacterDeletedPrompt: MessagePrompt() {

        override fun getNextPrompt(context: ConversationContext): Prompt? {
            return END_OF_CONVERSATION
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["character-delete-valid"]
        }
    }

}
