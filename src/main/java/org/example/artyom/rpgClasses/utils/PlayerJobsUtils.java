package org.example.artyom.rpgClasses.utils;

import com.google.common.collect.Multimap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.example.artyom.rpgClasses.RpgClasses;
import org.example.artyom.rpgClasses.customEvents.ChangeClassEvent;
import org.example.artyom.rpgClasses.customEvents.ChangeJobEvent;
import org.example.artyom.rpgClasses.plugins.Classes;
import org.example.artyom.rpgClasses.plugins.Jobs;

import java.util.Collection;

public class PlayerJobsUtils {
    public static void setPlayerJob(Player player, String className) {
        player.getPersistentDataContainer().set(
                new NamespacedKey(RpgClasses.getInstance(), "player_job"),
                PersistentDataType.STRING,
                className
        );
    }

    public static void setPlayerJobLevel(Player player, int level) {
        player.getPersistentDataContainer().set(
                new NamespacedKey(RpgClasses.getInstance(),getPlayerJob(player) + "_level" ),
                PersistentDataType.INTEGER,
                level
        );

    }

    public static void setPlayerJobExp(Player player, int exp) {
        player.getPersistentDataContainer().set(
                new NamespacedKey(RpgClasses.getInstance(), getPlayerJob(player) + "_exp"),
                PersistentDataType.INTEGER,
                exp
        );

    }

    public static String getPlayerJob(Player player) {
        return player.getPersistentDataContainer().get(
                new NamespacedKey(RpgClasses.getInstance(),"player_job"),
                PersistentDataType.STRING
        );
    }

    public static int getPlayerJobLevel(Player player) {
        String job = getPlayerJob(player);

        if (job == null || job.equalsIgnoreCase("NULL")) {
            return 0;
        }
        return player.getPersistentDataContainer().get(
                new NamespacedKey(RpgClasses.getInstance(),getPlayerJob(player) + "_level"),
                PersistentDataType.INTEGER
        ) == null ? 0 : player.getPersistentDataContainer().get(new NamespacedKey(RpgClasses.getInstance(),getPlayerJob(player) + "_level"),
                PersistentDataType.INTEGER);



//        return getPlayerJob(player).equalsIgnoreCase("NULL") ? 0 : player.getPersistentDataContainer().get(
//                NamespacedKey.fromString(getPlayerJob(player) + "_level"),
//                PersistentDataType.INTEGER
//        );
    }

    public static int getPlayerJobExp(Player player) {
        String job = getPlayerJob(player);

        if (job == null || job.equalsIgnoreCase("NULL")) {
            return 0;
        }
        return player.getPersistentDataContainer().get(
                new NamespacedKey(RpgClasses.getInstance(),getPlayerJob(player) + "_exp"),
                PersistentDataType.INTEGER
        ) == null ? 0 : player.getPersistentDataContainer().get(new NamespacedKey(RpgClasses.getInstance(),getPlayerJob(player) + "_exp"),
                PersistentDataType.INTEGER);
    }

    public static void giveJobParametersToPlayer(Player player, String className) {
        player.sendMessage("I`m " + className + "!");
        PlayerJobsUtils.setPlayerJob(player, className);
        Bukkit.getPluginManager().callEvent(new ChangeJobEvent(player, Jobs.valueOf(className.toUpperCase())));
    }

    public static void addArmor(ItemStack item, double addAmount, EquipmentSlotGroup slot, NamespacedKey key) {
        if (item == null || item.getType().isAir()) return;

        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
//        double currentArmor = 0;
//        // Получаем существующие модификаторы (если их нет — будет null)
//        Multimap<Attribute, AttributeModifier> map = meta.getAttributeModifiers(); //мультимап - объект где
////        // одному ключу соответствует НЕ одно, а сразу несколько значений.
//        if (map != null) {
//            Collection<AttributeModifier> armorMods = map.get(Attribute.GENERIC_ARMOR);
//            if (armorMods != null) {
//                for (AttributeModifier mod : armorMods) {
//                    // Суммируем ВСЕ модификаторы ADD_NUMBER (обычные цифры)
//                    if (mod.getOperation() == AttributeModifier.Operation.ADD_NUMBER &&
//                            mod.getSlotGroup() == slot) {
//
//                        currentArmor += mod.getAmount();
//                    }
//                }
//
//                // Удаляем старые модификаторы брони (иначе они удвоятся)
//                //meta.removeAttributeModifier(Attribute.GENERIC_ARMOR);
//            }
//
//
//        }
        ;

        // Новый итог
        double newArmor = PlayerJobsUtils.getVanillaArmorValue(item.getType()) + addAmount; // + currentArmor;

        AttributeModifier newMod = new AttributeModifier(
                key,
                newArmor, // количество брони
                AttributeModifier.Operation.ADD_NUMBER,
                slot
        );
        //System.out.println(meta.getAttributeModifiers(Attribute.GENERIC_ARMOR).toString());

        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, newMod);
        item.setItemMeta(meta);
    }

    private static int getVanillaArmorValue(Material mat) {
        // ногi (boots)
        switch (mat) {
            case LEATHER_BOOTS: return 1;
            case GOLDEN_BOOTS: return 1;
            case CHAINMAIL_BOOTS: return 1;
            case IRON_BOOTS: return 2;
            case DIAMOND_BOOTS: return 3;
            case NETHERITE_BOOTS: return 3;

            // legs (leggings)
            case LEATHER_LEGGINGS: return 2;
            case GOLDEN_LEGGINGS: return 2;
            case CHAINMAIL_LEGGINGS: return 4;
            case IRON_LEGGINGS: return 5;
            case DIAMOND_LEGGINGS: return 6;
            case NETHERITE_LEGGINGS: return 6;

            // chest (chestplate)
            case LEATHER_CHESTPLATE: return 3;
            case GOLDEN_CHESTPLATE: return 5;
            case CHAINMAIL_CHESTPLATE: return 6;
            case IRON_CHESTPLATE: return 8;
            case DIAMOND_CHESTPLATE: return 8;
            case NETHERITE_CHESTPLATE: return 8;

            // head (helmet)
            case LEATHER_HELMET: return 1;
            case GOLDEN_HELMET: return 1;
            case CHAINMAIL_HELMET: return 1;
            case IRON_HELMET: return 2;
            case DIAMOND_HELMET: return 3;
            case NETHERITE_HELMET: return 3;

            default:
                return 0;
        }
    }
}
