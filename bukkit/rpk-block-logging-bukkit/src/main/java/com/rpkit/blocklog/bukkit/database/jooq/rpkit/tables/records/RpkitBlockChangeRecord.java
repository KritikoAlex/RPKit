/*
 * This file is generated by jOOQ.
*/
package com.rpkit.blocklog.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.blocklog.bukkit.database.jooq.rpkit.tables.RpkitBlockChange;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitBlockChangeRecord extends UpdatableRecordImpl<RpkitBlockChangeRecord> implements Record11<Integer, Integer, Timestamp, Integer, Integer, Integer, String, Byte, String, Byte, String> {

    private static final long serialVersionUID = 1931605640;

    /**
     * Setter for <code>rpkit.rpkit_block_change.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.block_history_id</code>.
     */
    public void setBlockHistoryId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.block_history_id</code>.
     */
    public Integer getBlockHistoryId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.time</code>.
     */
    public void setTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.time</code>.
     */
    public Timestamp getTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.profile_id</code>.
     */
    public void setProfileId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.profile_id</code>.
     */
    public Integer getProfileId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.minecraft_profile_id</code>.
     */
    public void setMinecraftProfileId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.minecraft_profile_id</code>.
     */
    public Integer getMinecraftProfileId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.from</code>.
     */
    public void setFrom(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.from</code>.
     */
    public String getFrom() {
        return (String) get(6);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.from_data</code>.
     */
    public void setFromData(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.from_data</code>.
     */
    public Byte getFromData() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.to</code>.
     */
    public void setTo(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.to</code>.
     */
    public String getTo() {
        return (String) get(8);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.to_data</code>.
     */
    public void setToData(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.to_data</code>.
     */
    public Byte getToData() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>rpkit.rpkit_block_change.reason</code>.
     */
    public void setReason(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_block_change.reason</code>.
     */
    public String getReason() {
        return (String) get(10);
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
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Integer, Integer, Timestamp, Integer, Integer, Integer, String, Byte, String, Byte, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Integer, Integer, Timestamp, Integer, Integer, Integer, String, Byte, String, Byte, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.BLOCK_HISTORY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.PROFILE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.MINECRAFT_PROFILE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.CHARACTER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.FROM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.FROM_DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.TO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field10() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.TO_DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return RpkitBlockChange.RPKIT_BLOCK_CHANGE.REASON;
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
        return getBlockHistoryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getMinecraftProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getCharacterId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getFromData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value10() {
        return getToData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getReason();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value2(Integer value) {
        setBlockHistoryId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value3(Timestamp value) {
        setTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value4(Integer value) {
        setProfileId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value5(Integer value) {
        setMinecraftProfileId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value6(Integer value) {
        setCharacterId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value7(String value) {
        setFrom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value8(Byte value) {
        setFromData(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value9(String value) {
        setTo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value10(Byte value) {
        setToData(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord value11(String value) {
        setReason(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockChangeRecord values(Integer value1, Integer value2, Timestamp value3, Integer value4, Integer value5, Integer value6, String value7, Byte value8, String value9, Byte value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitBlockChangeRecord
     */
    public RpkitBlockChangeRecord() {
        super(RpkitBlockChange.RPKIT_BLOCK_CHANGE);
    }

    /**
     * Create a detached, initialised RpkitBlockChangeRecord
     */
    public RpkitBlockChangeRecord(Integer id, Integer blockHistoryId, Timestamp time, Integer profileId, Integer minecraftProfileId, Integer characterId, String from, Byte fromData, String to, Byte toData, String reason) {
        super(RpkitBlockChange.RPKIT_BLOCK_CHANGE);

        set(0, id);
        set(1, blockHistoryId);
        set(2, time);
        set(3, profileId);
        set(4, minecraftProfileId);
        set(5, characterId);
        set(6, from);
        set(7, fromData);
        set(8, to);
        set(9, toData);
        set(10, reason);
    }
}
