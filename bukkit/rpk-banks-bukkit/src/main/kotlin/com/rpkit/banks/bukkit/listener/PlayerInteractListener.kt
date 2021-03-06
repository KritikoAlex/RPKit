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

package com.rpkit.banks.bukkit.listener

import com.rpkit.banks.bukkit.RPKBanksBukkit
import com.rpkit.banks.bukkit.bank.RPKBankProvider
import com.rpkit.banks.bukkit.event.bank.RPKBukkitBankDepositEvent
import com.rpkit.banks.bukkit.event.bank.RPKBukkitBankWithdrawEvent
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.economy.bukkit.currency.RPKCurrencyProvider
import com.rpkit.economy.bukkit.economy.RPKEconomyProvider
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import org.bukkit.ChatColor.GREEN
import org.bukkit.block.Sign
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK
import org.bukkit.event.player.PlayerInteractEvent

/**
 * Player interact listener for bank signs.
 */
class PlayerInteractListener(private val plugin: RPKBanksBukkit): Listener {

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val clickedBlock = event.clickedBlock
        if (clickedBlock != null) {
            if (clickedBlock.state is Sign) {
                val sign = clickedBlock.state as Sign
                if (sign.getLine(0).equals("$GREEN[bank]", ignoreCase = true)) {
                    event.isCancelled = true
                    val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                    val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                    val currencyProvider = plugin.core.serviceManager.getServiceProvider(RPKCurrencyProvider::class)
                    val economyProvider = plugin.core.serviceManager.getServiceProvider(RPKEconomyProvider::class)
                    val bankProvider = plugin.core.serviceManager.getServiceProvider(RPKBankProvider::class)
                    val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(event.player)
                    if (minecraftProfile != null) {
                        val character = characterProvider.getActiveCharacter(minecraftProfile)
                        if (character != null) {
                            val currency = currencyProvider.getCurrency(sign.getLine(3))
                            if (currency != null) {
                                if (event.action == RIGHT_CLICK_BLOCK) {
                                    when (sign.getLine(2)) {
                                        "1" -> {
                                            sign.setLine(2, "10")
                                            sign.update()
                                        }
                                        "10" -> {
                                            sign.setLine(2, "100")
                                            sign.update()
                                        }
                                        "100" -> {
                                            sign.setLine(2, "1000")
                                            sign.update()
                                        }
                                        "1000" -> {
                                            sign.setLine(2, "1")
                                            sign.update()
                                        }
                                        else -> {
                                        }
                                    }
                                } else if (event.action == Action.LEFT_CLICK_BLOCK) {
                                    if (sign.getLine(1).equals("withdraw", ignoreCase = true)) {
                                        when {
                                            economyProvider.getBalance(character, currency) + sign.getLine(2).toInt() > 1728 -> event.player.sendMessage(plugin.messages["bank-withdraw-invalid-wallet-full"])
                                            sign.getLine(2).toInt() > bankProvider.getBalance(character, currency) -> event.player.sendMessage(plugin.messages["bank-withdraw-invalid-not-enough-money"])
                                            else -> {
                                                val bankWithdrawEvent = RPKBukkitBankWithdrawEvent(character, currency, sign.getLine(2).toInt())
                                                plugin.server.pluginManager.callEvent(bankWithdrawEvent)
                                                if (!bankWithdrawEvent.isCancelled) {
                                                    bankProvider.setBalance(
                                                            bankWithdrawEvent.character,
                                                            bankWithdrawEvent.currency,
                                                            bankProvider.getBalance(bankWithdrawEvent.character, bankWithdrawEvent.currency) - bankWithdrawEvent.amount
                                                    )
                                                    economyProvider.setBalance(
                                                            bankWithdrawEvent.character,
                                                            bankWithdrawEvent.currency,
                                                            economyProvider.getBalance(bankWithdrawEvent.character, bankWithdrawEvent.currency) + bankWithdrawEvent.amount
                                                    )
                                                    event.player.sendMessage(
                                                            plugin.messages["bank-withdraw-valid", mapOf(
                                                                    Pair("amount", bankWithdrawEvent.amount.toString()),
                                                                    Pair(
                                                                            "currency",
                                                                            if (bankWithdrawEvent.amount == 1)
                                                                                bankWithdrawEvent.currency.nameSingular
                                                                            else
                                                                                bankWithdrawEvent.currency.namePlural),
                                                                    Pair("wallet-balance", economyProvider.getBalance(bankWithdrawEvent.character, bankWithdrawEvent.currency).toString()),
                                                                    Pair("bank-balance", bankProvider.getBalance(bankWithdrawEvent.character, bankWithdrawEvent.currency).toString())
                                                            )]
                                                    )
                                                }
                                            }
                                        }
                                    } else if (sign.getLine(1).equals("deposit", ignoreCase = true)) {
                                        if (sign.getLine(2).toInt() > economyProvider.getBalance(character, currency)) {
                                            event.player.sendMessage(plugin.messages["bank-deposit-invalid-not-enough-money"])
                                        } else {
                                            val bankDepositEvent = RPKBukkitBankDepositEvent(character, currency, sign.getLine(2).toInt())
                                            plugin.server.pluginManager.callEvent(bankDepositEvent)
                                            if (!bankDepositEvent.isCancelled) {
                                                bankProvider.setBalance(
                                                        bankDepositEvent.character,
                                                        bankDepositEvent.currency,
                                                        bankProvider.getBalance(character, currency) + bankDepositEvent.amount
                                                )
                                                economyProvider.setBalance(
                                                        bankDepositEvent.character,
                                                        bankDepositEvent.currency,
                                                        economyProvider.getBalance(character, currency) - bankDepositEvent.amount
                                                )
                                                event.player.sendMessage(plugin.messages["bank-deposit-valid", mapOf(
                                                        Pair("amount", bankDepositEvent.amount.toString()),
                                                        Pair("currency", if (bankDepositEvent.amount == 1)
                                                            bankDepositEvent.currency.nameSingular
                                                        else
                                                            bankDepositEvent.currency.namePlural),
                                                        Pair("wallet-balance", economyProvider.getBalance(bankDepositEvent.character, bankDepositEvent.currency).toString()),
                                                        Pair("bank-balance", bankProvider.getBalance(bankDepositEvent.character, bankDepositEvent.currency).toString())
                                                )])
                                            }
                                        }
                                    } else if (sign.getLine(1).equals("balance", ignoreCase = true)) {
                                        val balance = bankProvider.getBalance(character, currency)
                                        event.player.sendMessage(plugin.messages["bank-balance-valid", mapOf(
                                                Pair("amount", balance.toString()),
                                                Pair("currency", if (balance == 1) currency.nameSingular else currency.namePlural)
                                        )])
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}