package io.ayushchivate.github.customloottables;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

public class PlayerWatcher implements Listener {


//    @EventHandler
//    public void onInteract(PlayerInteractEvent event) {
//
//        Player player = event.getPlayer();
//
//        if (event.hasBlock()) {
//            Block block = event.getClickedBlock();
//
//            if (block.getType() == Material.CHEST) {
//                Chest chest = (Chest) block.getState();
//
//                LootTable lootTable = chest.getLootTable();
//
//                if (lootTable == null) {
//                    return;
//                }
//
//                System.out.println("loot table key: " + lootTable.getKey());
//
//                chest.setLootTable(null);
//
//            }
//        }
//    }

    @EventHandler
    public void onLootGeneration(LootGenerateEvent e) {

        LootTable lootTable = e.getLootTable();

        System.out.printf("LootTable: %s", lootTable);

        if (lootTable.getKey().equals(LootTables.EMPTY.getKey())) {
            return;
        }
    }
}
