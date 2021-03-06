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

package com.rpkit.auctions.bukkit.auction

import com.rpkit.auctions.bukkit.RPKAuctionsBukkit
import com.rpkit.auctions.bukkit.database.table.RPKAuctionTable
import com.rpkit.auctions.bukkit.event.auction.RPKBukkitAuctionCreateEvent
import com.rpkit.auctions.bukkit.event.auction.RPKBukkitAuctionDeleteEvent
import com.rpkit.auctions.bukkit.event.auction.RPKBukkitAuctionUpdateEvent

/**
 * Auction provider implementation.
 */
class RPKAuctionProviderImpl(private val plugin: RPKAuctionsBukkit): RPKAuctionProvider {

    override fun getAuction(id: Int): RPKAuction? {
        return plugin.core.database.getTable(RPKAuctionTable::class)[id]
    }

    override fun addAuction(auction: RPKAuction): Boolean {
        val event = RPKBukkitAuctionCreateEvent(auction)
        plugin.server.pluginManager.callEvent(event)
        if (event.isCancelled) return false
        plugin.core.database.getTable(RPKAuctionTable::class).insert(event.auction)
        return true
    }

    override fun updateAuction(auction: RPKAuction): Boolean {
        val event = RPKBukkitAuctionUpdateEvent(auction)
        plugin.server.pluginManager.callEvent(event)
        if (event.isCancelled) return false
        plugin.core.database.getTable(RPKAuctionTable::class).update(event.auction)
        return true
    }

    override fun removeAuction(auction: RPKAuction): Boolean {
        val event = RPKBukkitAuctionDeleteEvent(auction)
        plugin.server.pluginManager.callEvent(event)
        if (event.isCancelled) return false
        plugin.core.database.getTable(RPKAuctionTable::class).delete(event.auction)
        return true
    }

    override fun getAuctions(): List<RPKAuction> {
        return plugin.core.database.getTable(RPKAuctionTable::class).getAll()
    }
}