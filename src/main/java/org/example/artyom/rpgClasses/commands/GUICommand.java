package org.example.artyom.rpgClasses.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.artyom.rpgClasses.gui.ClassesGUI;

public class GUICommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("gui")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                ClassesGUI.openGUI(player);
            }
        }
        return true;
    }
}
