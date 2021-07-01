package io.ayushchivate.github.customloottables;

import org.bukkit.inventory.ItemStack;

public class TableItem {

    private ItemStack itemStack;
    private int spawnProbability;

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getSpawnProbability() {
        return spawnProbability;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void setSpawnProbability(int spawnProbability) {
        this.spawnProbability = spawnProbability;
    }
}
