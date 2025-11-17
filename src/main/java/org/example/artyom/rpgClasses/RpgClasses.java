package org.example.artyom.rpgClasses;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.artyom.rpgClasses.commands.GUICommand;
import org.example.artyom.rpgClasses.commands.HandleClasses;
import org.example.artyom.rpgClasses.eventHandlers.ClassesGuiEvents;
import org.example.artyom.rpgClasses.plugins.Classes;

public final class RpgClasses extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new ClassesGuiEvents(), this);
        getCommand("getclass").setExecutor(new HandleClasses());
        getCommand("gui").setExecutor(new GUICommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
