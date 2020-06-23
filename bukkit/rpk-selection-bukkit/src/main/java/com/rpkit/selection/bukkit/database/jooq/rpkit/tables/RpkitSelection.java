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
package com.rpkit.selection.bukkit.database.jooq.rpkit.tables;


import com.rpkit.selection.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.selection.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.selection.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.selection.bukkit.database.jooq.rpkit.tables.records.RpkitSelectionRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitSelection extends TableImpl<RpkitSelectionRecord> {

    private static final long serialVersionUID = 879095325;

    /**
     * The reference instance of <code>rpkit.rpkit_selection</code>
     */
    public static final RpkitSelection RPKIT_SELECTION = new RpkitSelection();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitSelectionRecord> getRecordType() {
        return RpkitSelectionRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_selection.id</code>.
     */
    public final TableField<RpkitSelectionRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_selection.minecraft_profile_id</code>.
     */
    public final TableField<RpkitSelectionRecord, Integer> MINECRAFT_PROFILE_ID = createField("minecraft_profile_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_selection.world</code>.
     */
    public final TableField<RpkitSelectionRecord, String> WORLD = createField("world", org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_selection.x_1</code>.
     */
    public final TableField<RpkitSelectionRecord, Integer> X_1 = createField("x_1", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_selection.y_1</code>.
     */
    public final TableField<RpkitSelectionRecord, Integer> Y_1 = createField("y_1", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_selection.z_1</code>.
     */
    public final TableField<RpkitSelectionRecord, Integer> Z_1 = createField("z_1", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_selection.x_2</code>.
     */
    public final TableField<RpkitSelectionRecord, Integer> X_2 = createField("x_2", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_selection.y_2</code>.
     */
    public final TableField<RpkitSelectionRecord, Integer> Y_2 = createField("y_2", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_selection.z_2</code>.
     */
    public final TableField<RpkitSelectionRecord, Integer> Z_2 = createField("z_2", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>rpkit.rpkit_selection</code> table reference
     */
    public RpkitSelection() {
        this(DSL.name("rpkit_selection"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_selection</code> table reference
     */
    public RpkitSelection(String alias) {
        this(DSL.name(alias), RPKIT_SELECTION);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_selection</code> table reference
     */
    public RpkitSelection(Name alias) {
        this(alias, RPKIT_SELECTION);
    }

    private RpkitSelection(Name alias, Table<RpkitSelectionRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitSelection(Name alias, Table<RpkitSelectionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Rpkit.RPKIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.RPKIT_SELECTION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitSelectionRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_SELECTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitSelectionRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_SELECTION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitSelectionRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitSelectionRecord>>asList(Keys.KEY_RPKIT_SELECTION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelection as(String alias) {
        return new RpkitSelection(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSelection as(Name alias) {
        return new RpkitSelection(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitSelection rename(String name) {
        return new RpkitSelection(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitSelection rename(Name name) {
        return new RpkitSelection(name, null);
    }
}
