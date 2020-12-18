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
package com.rpkit.statbuilds.bukkit.database.jooq.tables;


import com.rpkit.statbuilds.bukkit.database.jooq.RpkitStatBuilds;
import com.rpkit.statbuilds.bukkit.database.jooq.tables.records.RpkitCharacterStatPointsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitCharacterStatPoints extends TableImpl<RpkitCharacterStatPointsRecord> {

    private static final long serialVersionUID = 1566413570;

    /**
     * The reference instance of <code>rpkit_stat_builds.rpkit_character_stat_points</code>
     */
    public static final RpkitCharacterStatPoints RPKIT_CHARACTER_STAT_POINTS = new RpkitCharacterStatPoints();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitCharacterStatPointsRecord> getRecordType() {
        return RpkitCharacterStatPointsRecord.class;
    }

    /**
     * The column <code>rpkit_stat_builds.rpkit_character_stat_points.character_id</code>.
     */
    public final TableField<RpkitCharacterStatPointsRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_stat_builds.rpkit_character_stat_points.stat_attribute</code>.
     */
    public final TableField<RpkitCharacterStatPointsRecord, String> STAT_ATTRIBUTE = createField(DSL.name("stat_attribute"), org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>rpkit_stat_builds.rpkit_character_stat_points.points</code>.
     */
    public final TableField<RpkitCharacterStatPointsRecord, Integer> POINTS = createField(DSL.name("points"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>rpkit_stat_builds.rpkit_character_stat_points</code> table reference
     */
    public RpkitCharacterStatPoints() {
        this(DSL.name("rpkit_character_stat_points"), null);
    }

    /**
     * Create an aliased <code>rpkit_stat_builds.rpkit_character_stat_points</code> table reference
     */
    public RpkitCharacterStatPoints(String alias) {
        this(DSL.name(alias), RPKIT_CHARACTER_STAT_POINTS);
    }

    /**
     * Create an aliased <code>rpkit_stat_builds.rpkit_character_stat_points</code> table reference
     */
    public RpkitCharacterStatPoints(Name alias) {
        this(alias, RPKIT_CHARACTER_STAT_POINTS);
    }

    private RpkitCharacterStatPoints(Name alias, Table<RpkitCharacterStatPointsRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitCharacterStatPoints(Name alias, Table<RpkitCharacterStatPointsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RpkitCharacterStatPoints(Table<O> child, ForeignKey<O, RpkitCharacterStatPointsRecord> key) {
        super(child, key, RPKIT_CHARACTER_STAT_POINTS);
    }

    @Override
    public Schema getSchema() {
        return RpkitStatBuilds.RPKIT_STAT_BUILDS;
    }

    @Override
    public RpkitCharacterStatPoints as(String alias) {
        return new RpkitCharacterStatPoints(DSL.name(alias), this);
    }

    @Override
    public RpkitCharacterStatPoints as(Name alias) {
        return new RpkitCharacterStatPoints(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitCharacterStatPoints rename(String name) {
        return new RpkitCharacterStatPoints(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitCharacterStatPoints rename(Name name) {
        return new RpkitCharacterStatPoints(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}