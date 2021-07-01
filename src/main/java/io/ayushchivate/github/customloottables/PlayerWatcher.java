package io.ayushchivate.github.customloottables;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;

import java.util.Random;

public class PlayerWatcher implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (event.hasBlock()) {
            Block block = event.getClickedBlock();

            if (block.getType() == Material.CHEST) {
                Chest chest = (Chest) block.getState();

                LootTable lootTable = chest.getLootTable();

                if (lootTable == null) {
                    return;
                }

                CustomLootTable customLootTable = new CustomLootTable();
                customLootTable.fillInventory(chest.getBlockInventory(), new Random(), new LootContext.Builder(chest.getLocation()).build());

                chest.setLootTable(null);

            }
        }
    }
}
