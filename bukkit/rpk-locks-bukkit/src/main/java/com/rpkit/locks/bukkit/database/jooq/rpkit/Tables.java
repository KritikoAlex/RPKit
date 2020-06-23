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

/*
 * This file is generated by jOOQ.
*/
package com.rpkit.locks.bukkit.database.jooq.rpkit;


import com.rpkit.locks.bukkit.database.jooq.rpkit.tables.RpkitKeyring;
import com.rpkit.locks.bukkit.database.jooq.rpkit.tables.RpkitLockedBlock;
import com.rpkit.locks.bukkit.database.jooq.rpkit.tables.RpkitPlayerGettingKey;
import com.rpkit.locks.bukkit.database.jooq.rpkit.tables.RpkitPlayerUnclaiming;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in rpkit
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>rpkit.rpkit_keyring</code>.
     */
    public static final RpkitKeyring RPKIT_KEYRING = RpkitKeyring.RPKIT_KEYRING;

    /**
     * The table <code>rpkit.rpkit_locked_block</code>.
     */
    public static final RpkitLockedBlock RPKIT_LOCKED_BLOCK = RpkitLockedBlock.RPKIT_LOCKED_BLOCK;

    /**
     * The table <code>rpkit.rpkit_player_getting_key</code>.
     */
    public static final RpkitPlayerGettingKey RPKIT_PLAYER_GETTING_KEY = RpkitPlayerGettingKey.RPKIT_PLAYER_GETTING_KEY;

    /**
     * The table <code>rpkit.rpkit_player_unclaiming</code>.
     */
    public static final RpkitPlayerUnclaiming RPKIT_PLAYER_UNCLAIMING = RpkitPlayerUnclaiming.RPKIT_PLAYER_UNCLAIMING;
}
