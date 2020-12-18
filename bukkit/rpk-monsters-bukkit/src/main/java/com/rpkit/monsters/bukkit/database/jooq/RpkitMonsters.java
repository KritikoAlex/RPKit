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
package com.rpkit.monsters.bukkit.database.jooq;


import com.rpkit.monsters.bukkit.database.jooq.tables.RpkitMonsterSpawnArea;
import com.rpkit.monsters.bukkit.database.jooq.tables.RpkitMonsterSpawnAreaMonster;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitMonsters extends SchemaImpl {

    private static final long serialVersionUID = -2108908508;

    /**
     * The reference instance of <code>rpkit_monsters</code>
     */
    public static final RpkitMonsters RPKIT_MONSTERS = new RpkitMonsters();

    /**
     * The table <code>rpkit_monsters.rpkit_monster_spawn_area</code>.
     */
    public final RpkitMonsterSpawnArea RPKIT_MONSTER_SPAWN_AREA = RpkitMonsterSpawnArea.RPKIT_MONSTER_SPAWN_AREA;

    /**
     * The table <code>rpkit_monsters.rpkit_monster_spawn_area_monster</code>.
     */
    public final RpkitMonsterSpawnAreaMonster RPKIT_MONSTER_SPAWN_AREA_MONSTER = RpkitMonsterSpawnAreaMonster.RPKIT_MONSTER_SPAWN_AREA_MONSTER;

    /**
     * No further instances allowed
     */
    private RpkitMonsters() {
        super("rpkit_monsters", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            RpkitMonsterSpawnArea.RPKIT_MONSTER_SPAWN_AREA,
            RpkitMonsterSpawnAreaMonster.RPKIT_MONSTER_SPAWN_AREA_MONSTER);
    }
}