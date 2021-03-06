/*
 * Copyright 2017 Ross Binden
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
package com.rpkit.essentials.bukkit.database.jooq.rpkit;


import com.rpkit.essentials.bukkit.database.jooq.rpkit.tables.RpkitLogMessagesEnabled;
import com.rpkit.essentials.bukkit.database.jooq.rpkit.tables.RpkitPreviousLocation;
import com.rpkit.essentials.bukkit.database.jooq.rpkit.tables.RpkitTrackingEnabled;

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
     * The table <code>rpkit.rpkit_log_messages_enabled</code>.
     */
    public static final RpkitLogMessagesEnabled RPKIT_LOG_MESSAGES_ENABLED = RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED;

    /**
     * The table <code>rpkit.rpkit_previous_location</code>.
     */
    public static final RpkitPreviousLocation RPKIT_PREVIOUS_LOCATION = RpkitPreviousLocation.RPKIT_PREVIOUS_LOCATION;

    /**
     * The table <code>rpkit.rpkit_tracking_enabled</code>.
     */
    public static final RpkitTrackingEnabled RPKIT_TRACKING_ENABLED = RpkitTrackingEnabled.RPKIT_TRACKING_ENABLED;
}
