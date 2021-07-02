package io.ayushchivate.github.customloottables;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TableItem {

    private ItemStack itemStack;
    private int spawnProbability;
    private int minimumQuantity;
    private int maximumQuantity;
    private String displayName;
    private List<String> lore;
    private Map<Enchantment, Integer> enchantments;

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

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getLore() {
        return lore;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
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

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public void setEnchantments(Map<Enchantment, Integer> enchantments) {
        this.enchantments = enchantments;
    }
}
