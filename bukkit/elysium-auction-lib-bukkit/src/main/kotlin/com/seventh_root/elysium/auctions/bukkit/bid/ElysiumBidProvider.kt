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

package com.seventh_root.elysium.auctions.bukkit.bid

import com.seventh_root.elysium.auctions.bukkit.auction.ElysiumAuction
import com.seventh_root.elysium.core.service.ServiceProvider


interface ElysiumBidProvider: ServiceProvider {

    fun addBid(bid: ElysiumBid)
    fun updateBid(bid: ElysiumBid)
    fun removeBid(bid: ElysiumBid)
    fun getBids(auction: ElysiumAuction): List<ElysiumBid>

}