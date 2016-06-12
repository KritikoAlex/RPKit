package com.seventh_root.elysium.shops.bukkit.listener

import com.seventh_root.elysium.characters.bukkit.character.BukkitCharacterProvider
import com.seventh_root.elysium.players.bukkit.BukkitPlayerProvider
import com.seventh_root.elysium.shops.bukkit.ElysiumShopsBukkit
import com.seventh_root.elysium.shops.bukkit.shopcount.BukkitShopCountProvider
import org.bukkit.ChatColor.GREEN
import org.bukkit.block.BlockFace.UP
import org.bukkit.block.Chest
import org.bukkit.block.Sign
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent


class BlockBreakListener(val plugin: ElysiumShopsBukkit): Listener {

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val state = event.block.state
        var sign: Sign? = null
        if (state is Sign) {
            sign = state
        }
        if (state is Chest) {
            sign = event.block.getRelative(UP).state as? Sign
        }
        if (sign?.getLine(0) == GREEN.toString() + "[shop]") {
            val playerProvider = plugin.core.serviceManager.getServiceProvider(BukkitPlayerProvider::class.java)
            val characterProvider = plugin.core.serviceManager.getServiceProvider(BukkitCharacterProvider::class.java)
            val shopCountProvider = plugin.core.serviceManager.getServiceProvider(BukkitShopCountProvider::class.java)
            val player = playerProvider.getPlayer(event.player)
            val character = characterProvider.getActiveCharacter(player)
            if (character != null) {
                val shopCount = shopCountProvider.getShopCount(character)
                shopCountProvider.setShopCount(character, shopCount - 1)
            }
        }
    }

}