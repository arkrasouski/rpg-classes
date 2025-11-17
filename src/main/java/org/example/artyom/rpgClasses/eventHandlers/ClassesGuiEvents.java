package org.example.artyom.rpgClasses.eventHandlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.example.artyom.rpgClasses.plugins.Classes;

public class ClassesGuiEvents implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) { //вызовется когда буду кликать по открытому ранее инвернтарю
        Player p = (Player) e.getWhoClicked();
        p.sendMessage("Открылся инвентарь!");
        if(e.getView().getTitle().equalsIgnoreCase("Выбор класса")){
            e.setCancelled(true);
            ItemStack item = e.getCurrentItem();

            if(item.getType() == Material.OAK_DOOR){
                p.closeInventory();
            }
            else if(item.hasItemMeta()){
                System.out.println(item.getItemMeta().getDisplayName());
                p.performCommand("getclass " + item.getItemMeta().getDisplayName().toUpperCase());
            }
            p.closeInventory();}

    }
}
