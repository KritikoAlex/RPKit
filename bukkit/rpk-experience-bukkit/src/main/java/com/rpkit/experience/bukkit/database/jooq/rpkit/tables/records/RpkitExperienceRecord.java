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
package com.rpkit.experience.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.experience.bukkit.database.jooq.rpkit.tables.RpkitExperience;
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
public class RpkitExperienceRecord extends UpdatableRecordImpl<RpkitExperienceRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = -964962842;

    /**
     * Setter for <code>rpkit.rpkit_experience.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_experience.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_experience.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_experience.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_experience.value</code>.
     */
    public void setValue(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_experience.value</code>.
     */
    public Integer getValue() {
        return (Integer) get(2);
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
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitExperience.RPKIT_EXPERIENCE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitExperience.RPKIT_EXPERIENCE.CHARACTER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return RpkitExperience.RPKIT_EXPERIENCE.VALUE;
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
    public Integer component3() {
        return getValue();
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
    public Integer value3() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitExperienceRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitExperienceRecord value2(Integer value) {
        setCharacterId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitExperienceRecord value3(Integer value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitExperienceRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitExperienceRecord
     */
    public RpkitExperienceRecord() {
        super(RpkitExperience.RPKIT_EXPERIENCE);
    }

    /**
     * Create a detached, initialised RpkitExperienceRecord
     */
    public RpkitExperienceRecord(Integer id, Integer characterId, Integer value) {
        super(RpkitExperience.RPKIT_EXPERIENCE);

        set(0, id);
        set(1, characterId);
        set(2, value);
    }
}
