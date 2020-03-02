/*
 * Copyright 2019 Ren Binden
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
package com.rpkit.skills.bukkit.database.jooq.rpkit;


import com.rpkit.skills.bukkit.database.jooq.rpkit.tables.RpkitSkillBinding;
import com.rpkit.skills.bukkit.database.jooq.rpkit.tables.RpkitSkillCooldown;
import com.rpkit.skills.bukkit.database.jooq.rpkit.tables.records.RpkitSkillBindingRecord;
import com.rpkit.skills.bukkit.database.jooq.rpkit.tables.records.RpkitSkillCooldownRecord;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import javax.annotation.Generated;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>rpkit</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<RpkitSkillBindingRecord, Integer> IDENTITY_RPKIT_SKILL_BINDING = Identities0.IDENTITY_RPKIT_SKILL_BINDING;
    public static final Identity<RpkitSkillCooldownRecord, Integer> IDENTITY_RPKIT_SKILL_COOLDOWN = Identities0.IDENTITY_RPKIT_SKILL_COOLDOWN;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitSkillBindingRecord> KEY_RPKIT_SKILL_BINDING_PRIMARY = UniqueKeys0.KEY_RPKIT_SKILL_BINDING_PRIMARY;
    public static final UniqueKey<RpkitSkillCooldownRecord> KEY_RPKIT_SKILL_COOLDOWN_PRIMARY = UniqueKeys0.KEY_RPKIT_SKILL_COOLDOWN_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<RpkitSkillBindingRecord, Integer> IDENTITY_RPKIT_SKILL_BINDING = Internal.createIdentity(RpkitSkillBinding.RPKIT_SKILL_BINDING, RpkitSkillBinding.RPKIT_SKILL_BINDING.ID);
        public static Identity<RpkitSkillCooldownRecord, Integer> IDENTITY_RPKIT_SKILL_COOLDOWN = Internal.createIdentity(RpkitSkillCooldown.RPKIT_SKILL_COOLDOWN, RpkitSkillCooldown.RPKIT_SKILL_COOLDOWN.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<RpkitSkillBindingRecord> KEY_RPKIT_SKILL_BINDING_PRIMARY = Internal.createUniqueKey(RpkitSkillBinding.RPKIT_SKILL_BINDING, "KEY_rpkit_skill_binding_PRIMARY", RpkitSkillBinding.RPKIT_SKILL_BINDING.ID);
        public static final UniqueKey<RpkitSkillCooldownRecord> KEY_RPKIT_SKILL_COOLDOWN_PRIMARY = Internal.createUniqueKey(RpkitSkillCooldown.RPKIT_SKILL_COOLDOWN, "KEY_rpkit_skill_cooldown_PRIMARY", RpkitSkillCooldown.RPKIT_SKILL_COOLDOWN.ID);
    }
}
