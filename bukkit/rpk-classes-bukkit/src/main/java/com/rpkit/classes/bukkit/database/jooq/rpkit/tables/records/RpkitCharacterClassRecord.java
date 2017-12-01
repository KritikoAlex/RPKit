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
package com.rpkit.classes.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.classes.bukkit.database.jooq.rpkit.tables.RpkitCharacterClass;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


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
public class RpkitCharacterClassRecord extends UpdatableRecordImpl<RpkitCharacterClassRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = -1959215871;

    /**
     * Setter for <code>rpkit.rpkit_character_class.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_character_class.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_character_class.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_character_class.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_character_class.class_name</code>.
     */
    public void setClassName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_character_class.class_name</code>.
     */
    public String getClassName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitCharacterClass.RPKIT_CHARACTER_CLASS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitCharacterClass.RPKIT_CHARACTER_CLASS.CHARACTER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return RpkitCharacterClass.RPKIT_CHARACTER_CLASS.CLASS_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getCharacterId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getClassName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getCharacterId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getClassName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitCharacterClassRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitCharacterClassRecord value2(Integer value) {
        setCharacterId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitCharacterClassRecord value3(String value) {
        setClassName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitCharacterClassRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitCharacterClassRecord
     */
    public RpkitCharacterClassRecord() {
        super(RpkitCharacterClass.RPKIT_CHARACTER_CLASS);
    }

    /**
     * Create a detached, initialised RpkitCharacterClassRecord
     */
    public RpkitCharacterClassRecord(Integer id, Integer characterId, String className) {
        super(RpkitCharacterClass.RPKIT_CHARACTER_CLASS);

        set(0, id);
        set(1, characterId);
        set(2, className);
    }
}
