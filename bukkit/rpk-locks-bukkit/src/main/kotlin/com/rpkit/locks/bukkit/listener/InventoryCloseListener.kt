package com.rpkit.locks.bukkit.listener

import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.locks.bukkit.RPKLocksBukkit
import com.rpkit.locks.bukkit.keyring.RPKKeyringProvider
import com.rpkit.players.bukkit.player.RPKPlayerProvider
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent


class InventoryCloseListener(private val plugin: RPKLocksBukkit): Listener {

    @EventHandler
    fun onInventoryClose(event: InventoryCloseEvent) {
        if (event.inventory.title.equals("Keyring", ignoreCase = true)) {
            val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
            val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
            val keyringProvider = plugin.core.serviceManager.getServiceProvider(RPKKeyringProvider::class)
            val bukkitPlayer = event.player
            if (bukkitPlayer is Player) {
                val player = playerProvider.getPlayer(bukkitPlayer)
                val character = characterProvider.getActiveCharacter(player)
                if (character != null) {
                    val keyring = keyringProvider.getKeyring(character)
                    keyring.clear()
                    keyring.addAll(event.inventory.contents.filter { it != null })
                    keyringProvider.setKeyring(character, keyring)
                }
            }
        }
    }

}