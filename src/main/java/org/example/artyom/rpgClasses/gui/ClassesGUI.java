package org.example.artyom.rpgClasses.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.example.artyom.rpgClasses.plugins.Classes;
import org.example.artyom.rpgClasses.utils.ItemUtils;

public class ClassesGUI {
    public static void openGUI(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9, "Выбор класса");
        p.sendMessage("in openggui!");
        Classes wizard = Classes.WIZARD;
        Classes warrior = Classes.WARRIOR;
        Classes sacrifier = Classes.SACRIFIER;

        inv.setItem(0, ItemUtils.create(wizard.getClassMaterial(), 1, wizard.getName(), "Волшебник"));
        inv.setItem(1, ItemUtils.create(warrior.getClassMaterial(), 1, warrior.getName(), "Воин"));
        inv.setItem(2, ItemUtils.create(sacrifier.getClassMaterial(), 1, sacrifier.getName(), "Жрец"));
        inv.setItem(8, ItemUtils.create(Material.OAK_DOOR, ChatColor.RED + "Выход"));

        p.openInventory(inv);
    }
}
