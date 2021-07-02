package io.ayushchivate.github.customloottables;

import net.dohaw.corelib.Config;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class LootTableConfig extends Config {

    public LootTableConfig() {
        super("config.yml");
    }

    public List<TableItem> getTableItems() {

        ConfigurationSection sectionOne = config.getConfigurationSection("Custom Loot Table");
        List<TableItem> tableItems = new ArrayList<>();

        if (sectionOne == null) {
            plugin.getLogger().severe("Configuration section not found.");
            return null;
        }

        /* loop through materials */
        for (String sectionTwoName : sectionOne.getKeys(false)) {

            TableItem tableItem = new TableItem();
            ConfigurationSection sectionTwo = sectionOne.getConfigurationSection(sectionTwoName);

            if (sectionTwo != null) {

                Material material = Material.valueOf(sectionTwo.getString("Material", "APPLE"));

                int minimumQuantity = sectionTwo.getInt("Minimum Quantity", 1);
                tableItem.setMinimumQuantity(minimumQuantity);

                int maximumQuantity = sectionTwo.getInt("Maximum Quantity", 64);
                tableItem.setMaximumQuantity(maximumQuantity);

                ItemStack itemStack = new ItemStack(material);
                tableItem.setItemStack(itemStack);

                int spawnProbability = sectionTwo.getInt("Spawn Probability", 100);
                tableItem.setSpawnProbability(spawnProbability);

                String displayName = sectionTwo.getString("Display Name");
                tableItem.setDisplayName(displayName);

                List<String> lore = sectionTwo.getStringList("Lore");
                tableItem.setLore(lore);

                Collection<String> enchantmentList = sectionTwo.getStringList("Enchantments");
                Map<Enchantment, Integer> enchantments = new HashMap<>();

                for (String enchantment : enchantmentList) {
                    String[] parts = enchantment.split(" ");

                    enchantments.put(EnchantmentWrapper.getByKey(NamespacedKey.minecraft(parts[0].toLowerCase())),
                            Integer.parseInt(parts[1]));
                }
                tableItem.setEnchantments(enchantments);

                tableItems.add(tableItem);
            }

        }

        return tableItems;
    }
}
