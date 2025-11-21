package org.example.artyom.rpgClasses.eventHandlers;

import com.google.common.collect.Multimap;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.artyom.rpgClasses.customEvents.ChangeJobEvent;
import org.example.artyom.rpgClasses.customEvents.ChangeLevelOrExpEvent;
import org.example.artyom.rpgClasses.plugins.Jobs;
import org.example.artyom.rpgClasses.utils.PlayerJobsUtils;

import java.util.Collection;

public class JobsEvents implements Listener {

    JavaPlugin plugin;
    public JobsEvents(JavaPlugin plugin) {

        this.plugin = plugin;
    }
    @EventHandler
    public void onCraftItemEvent(CraftItemEvent e){
        Player player = (Player) e.getWhoClicked();

        if(PlayerJobsUtils.getPlayerJob(player) != null && PlayerJobsUtils.getPlayerJob(player).equalsIgnoreCase(Jobs.BLACKSMITH.getName())){

            ItemStack item = e.getRecipe().getResult();




            if (item.getType().name().contains("BOOTS")) {
                NamespacedKey key = new NamespacedKey(this.plugin, "extra_boots");
                PlayerJobsUtils.addArmor(item, 2, EquipmentSlotGroup.FEET, key);
            }
            else if (item.getType().name().contains("CHEST")) {
                NamespacedKey key = new NamespacedKey(this.plugin, "extra_chest");
                    PlayerJobsUtils.addArmor(item, 2, EquipmentSlotGroup.CHEST, key);
                }

            else if (item.getType().name().contains("LEGGINGS")) {
                NamespacedKey key = new NamespacedKey(this.plugin, "extra_leggins");
                PlayerJobsUtils.addArmor(item, 2, EquipmentSlotGroup.LEGS, key);
            }
            else if (item.getType().name().contains("HELMET")) {
                NamespacedKey key = new NamespacedKey(this.plugin, "extra_helmet");
                PlayerJobsUtils.addArmor(item, 2, EquipmentSlotGroup.HEAD, key);
            }

//                AttributeModifier newMod = new AttributeModifier(
//                        key,
//                        5.0, // количество брони
//                        AttributeModifier.Operation.ADD_NUMBER,
//                        EquipmentSlotGroup.FEET
//                );
//                //System.out.println(meta.getAttributeModifiers(Attribute.GENERIC_ARMOR).toString());
//                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, newMod);
//                System.out.println(meta.getAttributeModifiers(Attribute.GENERIC_ARMOR).toString());
//                item.setItemMeta(meta);

                e.getInventory().setResult(item);

                int exp = PlayerJobsUtils.getPlayerJobExp(player);

                exp += 1;

                if (exp > 5) {
                    int level = PlayerJobsUtils.getPlayerJobLevel(player);
                    level += 1;
                    PlayerJobsUtils.setPlayerJobLevel(player, level);
                    PlayerJobsUtils.setPlayerJobExp(player, exp - 5);

                } else {
                    PlayerJobsUtils.setPlayerJobExp(player, exp);
                }
                Bukkit.getPluginManager().callEvent(new ChangeLevelOrExpEvent(player));
        }
    }



}
