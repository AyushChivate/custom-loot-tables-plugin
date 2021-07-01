package io.ayushchivate.github.customloottables;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CustomLootTable implements LootTable {

    @Override
    public Collection<ItemStack> populateLoot(Random random, LootContext context) {

        Collection<ItemStack> itemStacks = new ArrayList<>();
        LootTableConfig lootTableConfig = new LootTableConfig();

        List<TableItem> tableItems = lootTableConfig.getTableItems();

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (TableItem tableItem : tableItems) {

            int randomNumber = threadLocalRandom.nextInt(1, 101);
            int threshold = tableItem.getSpawnProbability();

            if (randomNumber <= threshold) {
                itemStacks.add(tableItem.getItemStack());
            }
        }

        return itemStacks;
    }

    @Override
    public void fillInventory(Inventory inventory, Random random, LootContext context) {

    }

    @Override
    public NamespacedKey getKey() {
        return NamespacedKey.minecraft("custom-loot-table");
    }
}
