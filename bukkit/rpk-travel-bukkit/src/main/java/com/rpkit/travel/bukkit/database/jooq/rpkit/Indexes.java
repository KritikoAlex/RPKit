/*
 * This file is generated by jOOQ.
*/
package com.rpkit.travel.bukkit.database.jooq.rpkit;


import com.rpkit.travel.bukkit.database.jooq.rpkit.tables.RpkitWarp;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>rpkit</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index RPKIT_WARP_PRIMARY = Indexes0.RPKIT_WARP_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index RPKIT_WARP_PRIMARY = createIndex("PRIMARY", RpkitWarp.RPKIT_WARP, new OrderField[] { RpkitWarp.RPKIT_WARP.ID }, true);
    }
}