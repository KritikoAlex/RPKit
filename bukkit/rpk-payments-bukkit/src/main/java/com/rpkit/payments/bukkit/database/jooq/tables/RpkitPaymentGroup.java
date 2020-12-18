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
package com.rpkit.payments.bukkit.database.jooq.tables;


import com.rpkit.payments.bukkit.database.jooq.Keys;
import com.rpkit.payments.bukkit.database.jooq.RpkitPayments;
import com.rpkit.payments.bukkit.database.jooq.tables.records.RpkitPaymentGroupRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitPaymentGroup extends TableImpl<RpkitPaymentGroupRecord> {

    private static final long serialVersionUID = -1139237891;

    /**
     * The reference instance of <code>rpkit_payments.rpkit_payment_group</code>
     */
    public static final RpkitPaymentGroup RPKIT_PAYMENT_GROUP = new RpkitPaymentGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitPaymentGroupRecord> getRecordType() {
        return RpkitPaymentGroupRecord.class;
    }

    /**
     * The column <code>rpkit_payments.rpkit_payment_group.id</code>.
     */
    public final TableField<RpkitPaymentGroupRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit_payments.rpkit_payment_group.name</code>.
     */
    public final TableField<RpkitPaymentGroupRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>rpkit_payments.rpkit_payment_group.amount</code>.
     */
    public final TableField<RpkitPaymentGroupRecord, Integer> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_payments.rpkit_payment_group.currency_id</code>.
     */
    public final TableField<RpkitPaymentGroupRecord, Integer> CURRENCY_ID = createField(DSL.name("currency_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit_payments.rpkit_payment_group.interval</code>.
     */
    public final TableField<RpkitPaymentGroupRecord, Long> INTERVAL = createField(DSL.name("interval"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>rpkit_payments.rpkit_payment_group.last_payment_time</code>.
     */
    public final TableField<RpkitPaymentGroupRecord, LocalDateTime> LAST_PAYMENT_TIME = createField(DSL.name("last_payment_time"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>rpkit_payments.rpkit_payment_group.balance</code>.
     */
    public final TableField<RpkitPaymentGroupRecord, Integer> BALANCE = createField(DSL.name("balance"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>rpkit_payments.rpkit_payment_group</code> table reference
     */
    public RpkitPaymentGroup() {
        this(DSL.name("rpkit_payment_group"), null);
    }

    /**
     * Create an aliased <code>rpkit_payments.rpkit_payment_group</code> table reference
     */
    public RpkitPaymentGroup(String alias) {
        this(DSL.name(alias), RPKIT_PAYMENT_GROUP);
    }

    /**
     * Create an aliased <code>rpkit_payments.rpkit_payment_group</code> table reference
     */
    public RpkitPaymentGroup(Name alias) {
        this(alias, RPKIT_PAYMENT_GROUP);
    }

    private RpkitPaymentGroup(Name alias, Table<RpkitPaymentGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitPaymentGroup(Name alias, Table<RpkitPaymentGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RpkitPaymentGroup(Table<O> child, ForeignKey<O, RpkitPaymentGroupRecord> key) {
        super(child, key, RPKIT_PAYMENT_GROUP);
    }

    @Override
    public Schema getSchema() {
        return RpkitPayments.RPKIT_PAYMENTS;
    }

    @Override
    public Identity<RpkitPaymentGroupRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_PAYMENT_GROUP;
    }

    @Override
    public UniqueKey<RpkitPaymentGroupRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_PAYMENT_GROUP_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitPaymentGroupRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitPaymentGroupRecord>>asList(Keys.KEY_RPKIT_PAYMENT_GROUP_PRIMARY);
    }

    @Override
    public RpkitPaymentGroup as(String alias) {
        return new RpkitPaymentGroup(DSL.name(alias), this);
    }

    @Override
    public RpkitPaymentGroup as(Name alias) {
        return new RpkitPaymentGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitPaymentGroup rename(String name) {
        return new RpkitPaymentGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitPaymentGroup rename(Name name) {
        return new RpkitPaymentGroup(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, Integer, Integer, Long, LocalDateTime, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}