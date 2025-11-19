package org.example.artyom.rpgClasses.customEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.example.artyom.rpgClasses.plugins.Classes;
import org.example.artyom.rpgClasses.plugins.Jobs;

public class ChangeJobEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList(); //массив слушателей
    private final Player player;
    private final Jobs playerJob;

    public ChangeJobEvent(Player player, Jobs playerJob) {
        this.player = player;
        this.playerJob = playerJob;
    }

    public Player getPlayer() {
        return player;
    }

    public Jobs getPlayerJob() {
        return playerJob;
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
