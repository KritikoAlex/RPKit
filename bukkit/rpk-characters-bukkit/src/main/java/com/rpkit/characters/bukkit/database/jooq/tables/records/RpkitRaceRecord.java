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
package com.rpkit.characters.bukkit.database.jooq.tables.records;


import com.rpkit.characters.bukkit.database.jooq.tables.RpkitRace;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitRaceRecord extends UpdatableRecordImpl<RpkitRaceRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1269925794;

    /**
     * Setter for <code>rpkit_characters.rpkit_race.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit_characters.rpkit_race.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit_characters.rpkit_race.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit_characters.rpkit_race.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitRace.RPKIT_RACE.ID;
    }

    @Override
    public Field<String> field2() {
        return RpkitRace.RPKIT_RACE.NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public RpkitRaceRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RpkitRaceRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public RpkitRaceRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitRaceRecord
     */
    public RpkitRaceRecord() {
        super(RpkitRace.RPKIT_RACE);
    }

    /**
     * Create a detached, initialised RpkitRaceRecord
     */
    public RpkitRaceRecord(Integer id, String name) {
        super(RpkitRace.RPKIT_RACE);

        set(0, id);
        set(1, name);
    }
}