package io.ayushchivate.github.customloottables;

import net.dohaw.corelib.Config;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

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

                tableItems.add(tableItem);
            }

        }

        return tableItems;
    }
}
