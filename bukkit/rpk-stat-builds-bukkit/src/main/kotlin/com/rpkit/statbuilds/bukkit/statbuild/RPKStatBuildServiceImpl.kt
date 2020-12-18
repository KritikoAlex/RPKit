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

package com.rpkit.statbuilds.bukkit.statbuild

import com.rpkit.characters.bukkit.character.RPKCharacter
import com.rpkit.core.service.Services
import com.rpkit.experience.bukkit.experience.RPKExperienceService
import com.rpkit.statbuilds.bukkit.RPKStatBuildsBukkit
import com.rpkit.statbuilds.bukkit.database.table.RPKCharacterStatPointsTable
import com.rpkit.statbuilds.bukkit.statattribute.RPKStatAttribute
import com.rpkit.statbuilds.bukkit.statattribute.RPKStatAttributeService
import org.nfunk.jep.JEP
import kotlin.math.roundToInt

class RPKStatBuildServiceImpl(override val plugin: RPKStatBuildsBukkit) : RPKStatBuildService {

    override fun getStatPoints(character: RPKCharacter, statAttribute: RPKStatAttribute): Int {
        return plugin.database.getTable(RPKCharacterStatPointsTable::class.java)[character, statAttribute]?.points
                ?: 0
    }

    override fun setStatPoints(character: RPKCharacter, statAttribute: RPKStatAttribute, amount: Int) {
        val characterStatPointsTable = plugin.database.getTable(RPKCharacterStatPointsTable::class.java)
        var characterStatPoints = characterStatPointsTable.get(character, statAttribute)
        if (characterStatPoints == null) {
            characterStatPoints = RPKCharacterStatPoints(
                    character = character,
                    statAttribute = statAttribute,
                    points = amount
            )
            characterStatPointsTable.insert(characterStatPoints)
        } else {
            characterStatPoints.points = amount
            characterStatPointsTable.update(characterStatPoints)
        }
    }

    override fun getMaxStatPoints(character: RPKCharacter, statAttribute: RPKStatAttribute): Int {
        val expression = plugin.config.getString("stat-attributes.${statAttribute.name}.max-points")
        val parser = JEP()
        parser.addStandardConstants()
        parser.addStandardFunctions()
        parser.addVariable("level", Services[RPKExperienceService::class.java]?.getLevel(character)?.toDouble() ?: 1.0)
        parser.parseExpression(expression)
        return parser.value.roundToInt()
    }

    override fun getTotalStatPoints(character: RPKCharacter): Int {
        val expression = plugin.config.getString("stat-attribute-points-formula")
        val parser = JEP()
        parser.addStandardConstants()
        parser.addStandardFunctions()
        parser.addVariable("level", Services[RPKExperienceService::class.java]?.getLevel(character)?.toDouble() ?: 1.0)
        parser.parseExpression(expression)
        return parser.value.roundToInt()
    }

    override fun getUnassignedStatPoints(character: RPKCharacter): Int {
        return getTotalStatPoints(character) - getAssignedStatPoints(character)
    }

    override fun getAssignedStatPoints(character: RPKCharacter): Int {
        return Services[RPKStatAttributeService::class.java]
                ?.statAttributes
                ?.map { statAttribute -> getStatPoints(character, statAttribute) }
                ?.sum()
                ?: 0
    }


}