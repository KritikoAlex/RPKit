/*
 * This file is generated by jOOQ.
*/
package com.rpkit.skills.bukkit.database.jooq.rpkit.tables;


import com.rpkit.skills.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.skills.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.skills.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.skills.bukkit.database.jooq.rpkit.tables.records.RpkitSkillCooldownRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class RpkitSkillCooldown extends TableImpl<RpkitSkillCooldownRecord> {

    private static final long serialVersionUID = 1964522036;

    /**
     * The reference instance of <code>rpkit.rpkit_skill_cooldown</code>
     */
    public static final RpkitSkillCooldown RPKIT_SKILL_COOLDOWN = new RpkitSkillCooldown();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitSkillCooldownRecord> getRecordType() {
        return RpkitSkillCooldownRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_skill_cooldown.id</code>.
     */
    public final TableField<RpkitSkillCooldownRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_skill_cooldown.character_id</code>.
     */
    public final TableField<RpkitSkillCooldownRecord, Integer> CHARACTER_ID = createField("character_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_skill_cooldown.skill_name</code>.
     */
    public final TableField<RpkitSkillCooldownRecord, String> SKILL_NAME = createField("skill_name", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>rpkit.rpkit_skill_cooldown.cooldown_timestamp</code>.
     */
    public final TableField<RpkitSkillCooldownRecord, Timestamp> COOLDOWN_TIMESTAMP = createField("cooldown_timestamp", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>rpkit.rpkit_skill_cooldown</code> table reference
     */
    public RpkitSkillCooldown() {
        this(DSL.name("rpkit_skill_cooldown"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_skill_cooldown</code> table reference
     */
    public RpkitSkillCooldown(String alias) {
        this(DSL.name(alias), RPKIT_SKILL_COOLDOWN);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_skill_cooldown</code> table reference
     */
    public RpkitSkillCooldown(Name alias) {
        this(alias, RPKIT_SKILL_COOLDOWN);
    }

    private RpkitSkillCooldown(Name alias, Table<RpkitSkillCooldownRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitSkillCooldown(Name alias, Table<RpkitSkillCooldownRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.RPKIT_SKILL_COOLDOWN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitSkillCooldownRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_SKILL_COOLDOWN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitSkillCooldownRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_SKILL_COOLDOWN_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitSkillCooldownRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitSkillCooldownRecord>>asList(Keys.KEY_RPKIT_SKILL_COOLDOWN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSkillCooldown as(String alias) {
        return new RpkitSkillCooldown(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitSkillCooldown as(Name alias) {
        return new RpkitSkillCooldown(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitSkillCooldown rename(String name) {
        return new RpkitSkillCooldown(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitSkillCooldown rename(Name name) {
        return new RpkitSkillCooldown(name, null);
    }
}
