package org.example.artyom.rpgClasses.utils;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.example.artyom.rpgClasses.customEvents.ChangeClassEvent;
import org.example.artyom.rpgClasses.customEvents.ChangeJobEvent;
import org.example.artyom.rpgClasses.plugins.Classes;
import org.example.artyom.rpgClasses.plugins.Jobs;

public class PlayerJobsUtils {
    public static void setPlayerJob(Player player, String className) {
        player.getPersistentDataContainer().set(
                NamespacedKey.fromString( "player_job"),
                PersistentDataType.STRING,
                className
        );
    }

    public static String getPlayerJob(Player player) {
        return player.getPersistentDataContainer().get(
                NamespacedKey.fromString( "player_job"),
                PersistentDataType.STRING
        );
    }

    public static void giveJobParametersToPlayer(Player player, String className) {
        player.sendMessage("I`m " + className + "!");
        PlayerJobsUtils.setPlayerJob(player, className);
        Bukkit.getPluginManager().callEvent(new ChangeJobEvent(player, Jobs.valueOf(className.toUpperCase())));
    }
}
