package org.example.artyom.rpgClasses.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerClassesUtils {
    public static void setPlayerClass(Player player, String className) {
        player.getPersistentDataContainer().set(
                NamespacedKey.fromString( "player_class"),
                PersistentDataType.STRING,
                className
        );
    }

    public String getPlayerClass(Player player, JavaPlugin plugin) {
        return player.getPersistentDataContainer().get(
                NamespacedKey.fromString( "player_class"),
                PersistentDataType.STRING
        );
    }
}
