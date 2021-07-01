package io.ayushchivate.github.customloottables;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CustomLootTable implements LootTable {

    @Override
    public Collection<ItemStack> populateLoot(Random random, LootContext context) {

        return new ArrayList<>();
    }

    @Override
    public void fillInventory(Inventory inventory, Random random, LootContext context) {

        inventory.clear();

        LootTableConfig lootTableConfig = new LootTableConfig();

        List<TableItem> tableItems = lootTableConfig.getTableItems();

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (TableItem tableItem : tableItems) {

            int randomNumber = threadLocalRandom.nextInt(1, 101);
            int threshold = tableItem.getSpawnProbability();

            if (randomNumber <= threshold) {

                int minimumQuantity = tableItem.getMinimumQuantity();
                int maximumQuantity = tableItem.getMaximumQuantity();
                ItemStack itemStack = tableItem.getItemStack();

                int randomQuantity = rand(minimumQuantity, maximumQuantity); // inclusive
                itemStack.setAmount(randomQuantity);
                int randomSlot = rand(0, 27);
                inventory.setItem(randomSlot, tableItem.getItemStack());
            }
        }
    }

    @Override
    public NamespacedKey getKey() {
        return NamespacedKey.minecraft("custom-loot-table");
    }

    private int rand(int low, int high) {
        high++;
        Random r = new Random();

        return r.nextInt(high - low) + low;
    }
}
