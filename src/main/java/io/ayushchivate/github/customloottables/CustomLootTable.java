package io.ayushchivate.github.customloottables;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CustomLootTable implements LootTable {

    LootTableConfig lootTableConfig;

    public CustomLootTable(LootTableConfig lootTableConfig) {
        this.lootTableConfig = lootTableConfig;
    }

    @Override
    public Collection<ItemStack> populateLoot(Random random, LootContext context) {

        return new ArrayList<>();
    }

    @Override
    public void fillInventory(Inventory inventory, Random random, LootContext context) {

        inventory.clear();

        List<TableItem> tableItems = this.lootTableConfig.getTableItems();

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (TableItem tableItem : tableItems) {

            if (inventory.firstEmpty() == -1) {
                return;
            }

            int randomNumber = threadLocalRandom.nextInt(1, 101);
            int threshold = tableItem.getSpawnProbability();

            if (randomNumber <= threshold) {

                int minimumQuantity = tableItem.getMinimumQuantity();
                int maximumQuantity = tableItem.getMaximumQuantity();
                ItemStack itemStack = tableItem.getItemStack();

                System.out.printf("Item Stack: %s\n", itemStack);

                int randomQuantity = rand(minimumQuantity, maximumQuantity); // inclusive
                itemStack.setAmount(randomQuantity);

                int randomSlot = rand(0, 27);

                while (inventory.getItem(randomSlot) != null) {
                    randomSlot = rand(0, 27);
                }

                ItemMeta itemMeta = itemStack.getItemMeta();

                itemMeta.setDisplayName(tableItem.getDisplayName());

                itemMeta.setLore(tableItem.getLore());

                for (Map.Entry<Enchantment, Integer> enchantment : tableItem.getEnchantments().entrySet()) {
                    itemMeta.addEnchant(enchantment.getKey(), enchantment.getValue(), false);
                }

                itemStack.setItemMeta(itemMeta);

                inventory.setItem(randomSlot, itemStack);
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
