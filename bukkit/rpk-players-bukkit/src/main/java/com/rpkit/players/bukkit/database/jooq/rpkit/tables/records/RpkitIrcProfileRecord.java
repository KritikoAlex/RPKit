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
package com.rpkit.players.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitIrcProfile;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitIrcProfileRecord extends UpdatableRecordImpl<RpkitIrcProfileRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = -623452179;

    /**
     * Setter for <code>rpkit.rpkit_irc_profile.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_irc_profile.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_irc_profile.profile_id</code>.
     */
    public void setProfileId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_irc_profile.profile_id</code>.
     */
    public Integer getProfileId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_irc_profile.nick</code>.
     */
    public void setNick(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_irc_profile.nick</code>.
     */
    public String getNick() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitIrcProfile.RPKIT_IRC_PROFILE.ID;
    }

    @Override
    public Field<Integer> field2() {
        return RpkitIrcProfile.RPKIT_IRC_PROFILE.PROFILE_ID;
    }

    @Override
    public Field<String> field3() {
        return RpkitIrcProfile.RPKIT_IRC_PROFILE.NICK;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getProfileId();
    }

    @Override
    public String component3() {
        return getNick();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getProfileId();
    }

    @Override
    public String value3() {
        return getNick();
    }

    @Override
    public RpkitIrcProfileRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RpkitIrcProfileRecord value2(Integer value) {
        setProfileId(value);
        return this;
    }

    @Override
    public RpkitIrcProfileRecord value3(String value) {
        setNick(value);
        return this;
    }

    @Override
    public RpkitIrcProfileRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitIrcProfileRecord
     */
    public RpkitIrcProfileRecord() {
        super(RpkitIrcProfile.RPKIT_IRC_PROFILE);
    }

    /**
     * Create a detached, initialised RpkitIrcProfileRecord
     */
    public RpkitIrcProfileRecord(Integer id, Integer profileId, String nick) {
        super(RpkitIrcProfile.RPKIT_IRC_PROFILE);

        set(0, id);
        set(1, profileId);
        set(2, nick);
    }
}
