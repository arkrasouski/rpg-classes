package org.example.artyom.rpgClasses.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.artyom.rpgClasses.customEvents.ChangeClassEvent;
import org.example.artyom.rpgClasses.plugins.Classes;
import org.example.artyom.rpgClasses.utils.PlayerClassesUtils;

public class HandleClasses implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;

        if (strings.length == 0) {
            player.sendMessage("Укажи имя класса");
            return true;
        }

        try {
            Classes gameClass = Classes.valueOf(strings[0]);
            //ArmsHandler.handle(scroll, player);

            if (gameClass.getName().equalsIgnoreCase("wizard")){
                player.sendMessage("I`m wizard!");
                PlayerClassesUtils.setPlayerClass(player, "wizard");
                Bukkit.getPluginManager().callEvent(new ChangeClassEvent(player, Classes.WIZARD));
            } else if (gameClass.getName().equalsIgnoreCase("warrior")){
                player.sendMessage("I'm warrior");
                PlayerClassesUtils.setPlayerClass(player, "warrior");
                Bukkit.getPluginManager().callEvent(new ChangeClassEvent(player, Classes.WARRIOR));

            }   else if (gameClass.getName().equalsIgnoreCase("sacrifier")){
                player.sendMessage("I'm sacrifier!");
                PlayerClassesUtils.setPlayerClass(player, "sacrifier");
                Bukkit.getPluginManager().callEvent(new ChangeClassEvent(player, Classes.SACRIFIER));
            }
            player.sendMessage("Успех!");
            return true;
        }
        catch (IllegalArgumentException e) {
            player.sendMessage("Неверное имя класса!");
            return true;
        }
        //return false;
    }
}
