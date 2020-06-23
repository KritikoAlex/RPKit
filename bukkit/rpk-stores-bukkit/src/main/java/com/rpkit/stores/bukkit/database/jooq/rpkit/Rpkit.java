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
package com.rpkit.stores.bukkit.database.jooq.rpkit;


import com.rpkit.stores.bukkit.database.jooq.DefaultCatalog;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitConsumablePurchase;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitConsumableStoreItem;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitPermanentPurchase;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitPermanentStoreItem;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitPurchase;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitStoreItem;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitTimedPurchase;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitTimedStoreItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Rpkit extends SchemaImpl {

    private static final long serialVersionUID = -421619387;

    /**
     * The reference instance of <code>rpkit</code>
     */
    public static final Rpkit RPKIT = new Rpkit();

    /**
     * The table <code>rpkit.rpkit_consumable_purchase</code>.
     */
    public final RpkitConsumablePurchase RPKIT_CONSUMABLE_PURCHASE = RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE;

    /**
     * The table <code>rpkit.rpkit_consumable_store_item</code>.
     */
    public final RpkitConsumableStoreItem RPKIT_CONSUMABLE_STORE_ITEM = RpkitConsumableStoreItem.RPKIT_CONSUMABLE_STORE_ITEM;

    /**
     * The table <code>rpkit.rpkit_permanent_purchase</code>.
     */
    public final RpkitPermanentPurchase RPKIT_PERMANENT_PURCHASE = RpkitPermanentPurchase.RPKIT_PERMANENT_PURCHASE;

    /**
     * The table <code>rpkit.rpkit_permanent_store_item</code>.
     */
    public final RpkitPermanentStoreItem RPKIT_PERMANENT_STORE_ITEM = RpkitPermanentStoreItem.RPKIT_PERMANENT_STORE_ITEM;

    /**
     * The table <code>rpkit.rpkit_purchase</code>.
     */
    public final RpkitPurchase RPKIT_PURCHASE = RpkitPurchase.RPKIT_PURCHASE;

    /**
     * The table <code>rpkit.rpkit_store_item</code>.
     */
    public final RpkitStoreItem RPKIT_STORE_ITEM = RpkitStoreItem.RPKIT_STORE_ITEM;

    /**
     * The table <code>rpkit.rpkit_timed_purchase</code>.
     */
    public final RpkitTimedPurchase RPKIT_TIMED_PURCHASE = RpkitTimedPurchase.RPKIT_TIMED_PURCHASE;

    /**
     * The table <code>rpkit.rpkit_timed_store_item</code>.
     */
    public final RpkitTimedStoreItem RPKIT_TIMED_STORE_ITEM = RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM;

    /**
     * No further instances allowed
     */
    private Rpkit() {
        super("rpkit", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE,
            RpkitConsumableStoreItem.RPKIT_CONSUMABLE_STORE_ITEM,
            RpkitPermanentPurchase.RPKIT_PERMANENT_PURCHASE,
            RpkitPermanentStoreItem.RPKIT_PERMANENT_STORE_ITEM,
            RpkitPurchase.RPKIT_PURCHASE,
            RpkitStoreItem.RPKIT_STORE_ITEM,
            RpkitTimedPurchase.RPKIT_TIMED_PURCHASE,
            RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM);
    }
}
