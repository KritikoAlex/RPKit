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
package com.rpkit.locks.bukkit.database.jooq.tables.records;


import com.rpkit.locks.bukkit.database.jooq.tables.RpkitLockedBlock;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitLockedBlockRecord extends TableRecordImpl<RpkitLockedBlockRecord> implements Record4<String, Integer, Integer, Integer> {

    private static final long serialVersionUID = 2027673370;

    /**
     * Setter for <code>rpkit_locks.rpkit_locked_block.world</code>.
     */
    public void setWorld(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit_locks.rpkit_locked_block.world</code>.
     */
    public String getWorld() {
        return (String) get(0);
    }

    /**
     * Setter for <code>rpkit_locks.rpkit_locked_block.x</code>.
     */
    public void setX(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit_locks.rpkit_locked_block.x</code>.
     */
    public Integer getX() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit_locks.rpkit_locked_block.y</code>.
     */
    public void setY(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit_locks.rpkit_locked_block.y</code>.
     */
    public Integer getY() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>rpkit_locks.rpkit_locked_block.z</code>.
     */
    public void setZ(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>rpkit_locks.rpkit_locked_block.z</code>.
     */
    public Integer getZ() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, Integer, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, Integer, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.WORLD;
    }

    @Override
    public Field<Integer> field2() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.X;
    }

    @Override
    public Field<Integer> field3() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.Y;
    }

    @Override
    public Field<Integer> field4() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.Z;
    }

    @Override
    public String component1() {
        return getWorld();
    }

    @Override
    public Integer component2() {
        return getX();
    }

    @Override
    public Integer component3() {
        return getY();
    }

    @Override
    public Integer component4() {
        return getZ();
    }

    @Override
    public String value1() {
        return getWorld();
    }

    @Override
    public Integer value2() {
        return getX();
    }

    @Override
    public Integer value3() {
        return getY();
    }

    @Override
    public Integer value4() {
        return getZ();
    }

    @Override
    public RpkitLockedBlockRecord value1(String value) {
        setWorld(value);
        return this;
    }

    @Override
    public RpkitLockedBlockRecord value2(Integer value) {
        setX(value);
        return this;
    }

    @Override
    public RpkitLockedBlockRecord value3(Integer value) {
        setY(value);
        return this;
    }

    @Override
    public RpkitLockedBlockRecord value4(Integer value) {
        setZ(value);
        return this;
    }

    @Override
    public RpkitLockedBlockRecord values(String value1, Integer value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitLockedBlockRecord
     */
    public RpkitLockedBlockRecord() {
        super(RpkitLockedBlock.RPKIT_LOCKED_BLOCK);
    }

    /**
     * Create a detached, initialised RpkitLockedBlockRecord
     */
    public RpkitLockedBlockRecord(String world, Integer x, Integer y, Integer z) {
        super(RpkitLockedBlock.RPKIT_LOCKED_BLOCK);

        set(0, world);
        set(1, x);
        set(2, y);
        set(3, z);
    }
}