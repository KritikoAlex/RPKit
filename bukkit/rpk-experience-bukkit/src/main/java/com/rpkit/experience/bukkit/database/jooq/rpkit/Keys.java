/*
 * This file is generated by jOOQ.
*/
package com.rpkit.experience.bukkit.database.jooq.rpkit;


import com.rpkit.experience.bukkit.database.jooq.rpkit.tables.RpkitExperience;
import com.rpkit.experience.bukkit.database.jooq.rpkit.tables.records.RpkitExperienceRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>rpkit</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<RpkitExperienceRecord, Integer> IDENTITY_RPKIT_EXPERIENCE = Identities0.IDENTITY_RPKIT_EXPERIENCE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitExperienceRecord> KEY_RPKIT_EXPERIENCE_PRIMARY = UniqueKeys0.KEY_RPKIT_EXPERIENCE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<RpkitExperienceRecord, Integer> IDENTITY_RPKIT_EXPERIENCE = createIdentity(RpkitExperience.RPKIT_EXPERIENCE, RpkitExperience.RPKIT_EXPERIENCE.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<RpkitExperienceRecord> KEY_RPKIT_EXPERIENCE_PRIMARY = createUniqueKey(RpkitExperience.RPKIT_EXPERIENCE, "KEY_rpkit_experience_PRIMARY", RpkitExperience.RPKIT_EXPERIENCE.ID);
    }
}