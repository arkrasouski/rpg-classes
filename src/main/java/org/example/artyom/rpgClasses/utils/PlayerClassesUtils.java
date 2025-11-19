package org.example.artyom.rpgClasses.utils;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.artyom.rpgClasses.customEvents.ChangeClassEvent;
import org.example.artyom.rpgClasses.plugins.Classes;

public class PlayerClassesUtils {
    public static void setPlayerClass(Player player, String className) {
        player.getPersistentDataContainer().set(
                NamespacedKey.fromString( "player_class"),
                PersistentDataType.STRING,
                className
        );
    }

    public static String getPlayerClass(Player player) {
        return player.getPersistentDataContainer().get(
                NamespacedKey.fromString( "player_class"),
                PersistentDataType.STRING
        );
    }

    public static void giveClassParametersToPlayer(Player player, String className) {
        player.sendMessage("I`m " + className + "!");
        PlayerClassesUtils.setPlayerClass(player, className);
        Bukkit.getPluginManager().callEvent(new ChangeClassEvent(player, Classes.valueOf(className.toUpperCase())));
    }
}
