package io.ayushchivate.github.customloottables;

import org.bukkit.inventory.ItemStack;

public class TableItem {

    private ItemStack itemStack;
    private int spawnProbability;
    private int minimumQuantity;
    private int maximumQuantity;

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getSpawnProbability() {
        return spawnProbability;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void setSpawnProbability(int spawnProbability) {
        this.spawnProbability = spawnProbability;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }
}
