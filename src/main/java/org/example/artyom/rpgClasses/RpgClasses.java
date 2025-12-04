package org.example.artyom.rpgClasses;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.artyom.rpgClasses.commands.GUICommand;
import org.example.artyom.rpgClasses.commands.HandleClasses;
import org.example.artyom.rpgClasses.commands.HandleJobs;
import org.example.artyom.rpgClasses.eventHandlers.ClassesGuiEvents;
import org.example.artyom.rpgClasses.eventHandlers.JobsEvents;
import org.example.artyom.rpgClasses.eventHandlers.JobsGUIEvents;

public final class RpgClasses extends JavaPlugin {
    @Getter
    private static RpgClasses instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ClassesGuiEvents(), this);
        Bukkit.getPluginManager().registerEvents(new JobsGUIEvents(), this);
        Bukkit.getPluginManager().registerEvents(new JobsEvents(), this);

        getCommand("getclass").setExecutor(new HandleClasses());
        getCommand("getjobs").setExecutor(new HandleJobs());
        getCommand("gui").setExecutor(new GUICommand());
        getCommand("jobs").setExecutor(new GUICommand());
    }
}
