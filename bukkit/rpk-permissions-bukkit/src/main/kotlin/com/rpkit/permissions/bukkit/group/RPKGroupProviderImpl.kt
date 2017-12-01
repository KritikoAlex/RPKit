/*
 * Copyright 2016 Ross Binden
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

package com.rpkit.permissions.bukkit.group

import com.rpkit.permissions.bukkit.RPKPermissionsBukkit
import com.rpkit.permissions.bukkit.database.table.PlayerGroupTable
import com.rpkit.permissions.bukkit.database.table.RPKProfileGroupTable
import com.rpkit.players.bukkit.player.RPKPlayer
import com.rpkit.players.bukkit.profile.RPKMinecraftProfile
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import com.rpkit.players.bukkit.profile.RPKProfile
import org.bukkit.Bukkit
import org.bukkit.permissions.PermissionAttachment

/**
 * Group provider implementation.
 */
class RPKGroupProviderImpl(private val plugin: RPKPermissionsBukkit): RPKGroupProvider {

    override val groups: List<RPKGroup> = plugin.config.getList("groups") as List<RPKGroupImpl>
    val defaultGroup = plugin.config.get("default-group") as RPKGroup
    val permissionsAttachments = mutableMapOf<Int, PermissionAttachment>()

    override fun getGroup(name: String): RPKGroup? {
        return groups.filter { group -> group.name == name }.firstOrNull()
    }

    override fun addGroup(player: RPKPlayer, group: RPKGroup) {
        if (!getGroups(player).contains(group)) {
            plugin.core.database.getTable(PlayerGroupTable::class).insert(
                    PlayerGroup(player = player, group = group)
            )
            assignPermissions(player)
        }
    }

    override fun addGroup(profile: RPKProfile, group: RPKGroup) {
        if (!getGroups(profile).contains(group)) {
            plugin.core.database.getTable(RPKProfileGroupTable::class).insert(
                    RPKProfileGroup(profile = profile, group = group)
            )
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            minecraftProfileProvider.getMinecraftProfiles(profile).forEach { minecraftProfile ->
                assignPermissions(minecraftProfile)
            }
        }
    }

    private fun assignGroupPermissions(minecraftProfile: RPKMinecraftProfile, group: RPKGroup, assignedGroups: MutableList<RPKGroup>) {
        if (assignedGroups.contains(group)) return
        assignedGroups.add(group)
        for (inheritedGroup in group.inheritance) {
            assignGroupPermissions(minecraftProfile, inheritedGroup, assignedGroups)
        }
        val permissionsAttachment = permissionsAttachments[minecraftProfile.id]
        if (permissionsAttachment != null) {
            for (node in group.allow) {
                if (permissionsAttachment.permissions.containsKey(node)) {
                    permissionsAttachment.unsetPermission(node)
                }
                permissionsAttachment.setPermission(node, true)
            }
            for (node in group.deny) {
                if (permissionsAttachment.permissions.containsKey(node)) {
                    permissionsAttachment.unsetPermission(node)
                }
                permissionsAttachment.setPermission(node, false)
            }
        }
    }

    override fun removeGroup(player: RPKPlayer, group: RPKGroup) {
        val playerGroupTable = plugin.core.database.getTable(PlayerGroupTable::class)
        val playerGroup = playerGroupTable.get(player)
                .filter { playerGroup -> playerGroup.group == group }
                .firstOrNull()
        if (playerGroup != null) {
            playerGroupTable.delete(playerGroup)
            assignPermissions(player)
        }
    }

    override fun removeGroup(profile: RPKProfile, group: RPKGroup) {
        val profileGroupTable = plugin.core.database.getTable(RPKProfileGroupTable::class)
        val profileGroup = profileGroupTable.get(profile)
                .filter { profileGroup -> profileGroup.group == group }
                .firstOrNull()
        if (profileGroup != null) {
            profileGroupTable.delete(profileGroup)
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            minecraftProfileProvider.getMinecraftProfiles(profile).forEach { minecraftProfile ->
                assignPermissions(minecraftProfile)
            }
        }
    }

    override fun assignPermissions(player: RPKPlayer) {
        val bukkitPlayer = player.bukkitPlayer
        if (bukkitPlayer != null) {
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(bukkitPlayer)
            if (minecraftProfile != null) {
                assignPermissions(minecraftProfile)
            }
        }
    }

    override fun assignPermissions(minecraftProfile: RPKMinecraftProfile) {
        val bukkitPlayer = Bukkit.getOfflinePlayer(minecraftProfile.minecraftUUID)
        if (bukkitPlayer != null) {
            val onlineBukkitPlayer = bukkitPlayer.player
            if (onlineBukkitPlayer != null) {
                if (!permissionsAttachments.containsKey(minecraftProfile.id)) {
                    permissionsAttachments[minecraftProfile.id] = onlineBukkitPlayer.addAttachment(plugin)
                } else {
                    onlineBukkitPlayer.removeAttachment(permissionsAttachments[minecraftProfile.id])
                    permissionsAttachments[minecraftProfile.id] = onlineBukkitPlayer.addAttachment(plugin)
                }
                val profile = minecraftProfile.profile
                if (profile != null) {
                    val groups = getGroups(profile)
                    if (groups.isEmpty()) {
                        assignGroupPermissions(minecraftProfile, defaultGroup, mutableListOf<RPKGroup>())
                    } else {
                        val assignedGroups = mutableListOf<RPKGroup>()
                        for (group in groups) {
                            assignGroupPermissions(minecraftProfile, group, assignedGroups)
                        }
                    }
                }
            }
        }
    }

    override fun unassignPermissions(player: RPKPlayer) {
        val bukkitPlayer = player.bukkitPlayer
        if (bukkitPlayer != null) {
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(bukkitPlayer)
            if (minecraftProfile != null) {
                unassignPermissions(minecraftProfile)
            }
        }
    }

    override fun unassignPermissions(minecraftProfile: RPKMinecraftProfile) {
        val bukkitPlayer = plugin.server.getOfflinePlayer(minecraftProfile.minecraftUUID)
        if (bukkitPlayer != null) {
            val onlineBukkitPlayer = bukkitPlayer.player
            if (onlineBukkitPlayer != null) {
                onlineBukkitPlayer.removeAttachment(permissionsAttachments[minecraftProfile.id])
                permissionsAttachments.remove(minecraftProfile.id)
            }
        }
    }

    override fun getGroups(player: RPKPlayer): List<RPKGroup> {
        val bukkitPlayer = player.bukkitPlayer
        if (bukkitPlayer != null) {
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(bukkitPlayer)
            if (minecraftProfile != null) {
                val profile = minecraftProfile.profile
                if (profile != null) {
                    return getGroups(profile)
                }
            }
        }
        return emptyList()
    }

    override fun getGroups(profile: RPKProfile): List<RPKGroup> {
        return plugin.core.database.getTable(RPKProfileGroupTable::class).get(profile).map(RPKProfileGroup::group)
    }

    override fun hasPermission(group: RPKGroup, node: String): Boolean {
        var hasPermission = plugin.server.pluginManager.getPermission(node)?.default?.getValue(false)?:false
        for (inheritedGroup in group.inheritance) {
            hasPermission = hasPermission(inheritedGroup, node)
        }
        if (node in group.allow) {
            hasPermission = true
        }
        if (node in group.deny) {
            hasPermission = false
        }
        return hasPermission
    }

    override fun hasPermission(player: RPKPlayer, node: String): Boolean {
        var hasPermission = plugin.server.pluginManager.getPermission(node)?.default?.getValue(false)?:false
        val bukkitPlayer = player.bukkitPlayer
        if (bukkitPlayer != null) {
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(bukkitPlayer)
            if (minecraftProfile != null) {
                val profile = minecraftProfile.profile
                if (profile != null) {
                    hasPermission = hasPermission(profile, node)
                }
            }
        }
        return hasPermission
    }

    override fun hasPermission(profile: RPKProfile, node: String): Boolean {
        var hasPermission = plugin.server.pluginManager.getPermission(node)?.default?.getValue(false)?:false
        val groups = getGroups(profile)
        if (groups.isEmpty()) {
            hasPermission = hasPermission(defaultGroup, node)
        } else {
            for (group in groups) {
                hasPermission = hasPermission(group, node)
            }
        }
        return hasPermission
    }

}