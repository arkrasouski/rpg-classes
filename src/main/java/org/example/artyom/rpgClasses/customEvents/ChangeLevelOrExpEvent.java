package org.example.artyom.rpgClasses.customEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.example.artyom.rpgClasses.utils.PlayerJobsUtils;


public class ChangeLevelOrExpEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList(); //массив слушателей
    private final Player player;
    private final int playerLevel;
    private final int playerExp;

    public ChangeLevelOrExpEvent (Player player) {
        this.player = player;
        this.playerLevel = PlayerJobsUtils.getPlayerJobLevel(player);
        this.playerExp = PlayerJobsUtils.getPlayerJobExp(player);
    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public int getPlayerExp() {
        return playerExp;
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
