/*
 * This file is generated by jOOQ.
*/
package com.rpkit.classes.bukkit.database.jooq.rpkit.tables;


import com.rpkit.classes.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.classes.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.classes.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.classes.bukkit.database.jooq.rpkit.tables.records.RpkitClassExperienceRecord;

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
public class RpkitClassExperience extends TableImpl<RpkitClassExperienceRecord> {

    private static final long serialVersionUID = -34089629;

    /**
     * The reference instance of <code>rpkit.rpkit_class_experience</code>
     */
    public static final RpkitClassExperience RPKIT_CLASS_EXPERIENCE = new RpkitClassExperience();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitClassExperienceRecord> getRecordType() {
        return RpkitClassExperienceRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_class_experience.id</code>.
     */
    public final TableField<RpkitClassExperienceRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_class_experience.character_id</code>.
     */
    public final TableField<RpkitClassExperienceRecord, Integer> CHARACTER_ID = createField("character_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_class_experience.class_name</code>.
     */
    public final TableField<RpkitClassExperienceRecord, String> CLASS_NAME = createField("class_name", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>rpkit.rpkit_class_experience.experience</code>.
     */
    public final TableField<RpkitClassExperienceRecord, Integer> EXPERIENCE = createField("experience", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>rpkit.rpkit_class_experience</code> table reference
     */
    public RpkitClassExperience() {
        this(DSL.name("rpkit_class_experience"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_class_experience</code> table reference
     */
    public RpkitClassExperience(String alias) {
        this(DSL.name(alias), RPKIT_CLASS_EXPERIENCE);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_class_experience</code> table reference
     */
    public RpkitClassExperience(Name alias) {
        this(alias, RPKIT_CLASS_EXPERIENCE);
    }

    private RpkitClassExperience(Name alias, Table<RpkitClassExperienceRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitClassExperience(Name alias, Table<RpkitClassExperienceRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.RPKIT_CLASS_EXPERIENCE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitClassExperienceRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_CLASS_EXPERIENCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitClassExperienceRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_CLASS_EXPERIENCE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitClassExperienceRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitClassExperienceRecord>>asList(Keys.KEY_RPKIT_CLASS_EXPERIENCE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitClassExperience as(String alias) {
        return new RpkitClassExperience(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitClassExperience as(Name alias) {
        return new RpkitClassExperience(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitClassExperience rename(String name) {
        return new RpkitClassExperience(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitClassExperience rename(Name name) {
        return new RpkitClassExperience(name, null);
    }
}
