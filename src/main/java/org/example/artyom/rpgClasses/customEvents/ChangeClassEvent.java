package org.example.artyom.rpgClasses.customEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.example.artyom.rpgClasses.plugins.Classes;

public class ChangeClassEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList(); //массив слушателей
    private final Player player;
    private final Classes playerClass;

    public ChangeClassEvent(Player player, Classes playerClass) {
        this.player = player;
        this.playerClass = playerClass;
    }

    public Player getPlayer() {
        return player;
    }

    public Classes getPlayerClass() {
        return playerClass;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    // Статический метод тоже обязателен для Bukkit
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
