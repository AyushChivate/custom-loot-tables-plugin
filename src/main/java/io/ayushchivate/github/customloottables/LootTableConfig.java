package io.ayushchivate.github.customloottables;

import net.dohaw.corelib.Config;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootTableConfig extends Config {

    public LootTableConfig() {
        super("config.yml");
    }

    public List<TableItem> getTableItems() {

        ConfigurationSection sectionOne = config.getConfigurationSection("Custom Loot Tables");
        List<TableItem> tableItems = new ArrayList<>();

        if (sectionOne == null) {
            plugin.getLogger().severe("Configuration section not found.");
            return null;
        }

        /* loop through materials */
        for (String sectionTwoName : sectionOne.getKeys(false)) {

            TableItem tableItem = new TableItem();
            ConfigurationSection sectionTwo = config.getConfigurationSection(sectionTwoName);

            if (sectionTwo != null) {

                Material material = Material.valueOf(sectionTwo.getString("Material", "APPLE"));
                int minimumQuantity = sectionTwo.getInt("Minimum Quantity", 1);
                int maximumQuantity = sectionTwo.getInt("Maximum Quantity", 64);
                int randomQuantity = rand(minimumQuantity, maximumQuantity); // inclusive

                ItemStack itemStack = new ItemStack(material, randomQuantity);
                tableItem.setItemStack(itemStack);

                int spawnProbability = sectionTwo.getInt("Spawn Probability", 100);
                tableItem.setSpawnProbability(spawnProbability);

                tableItems.add(tableItem);
            }

        }

        return tableItems;
    }

    private int rand(int low, int high) {
        high++;
        Random r = new Random();

        return r.nextInt(high - low) + low;
    }
}
