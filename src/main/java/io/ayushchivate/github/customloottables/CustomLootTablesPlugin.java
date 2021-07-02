package io.ayushchivate.github.customloottables;

import net.dohaw.corelib.CoreLib;
import net.dohaw.corelib.JPUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomLootTablesPlugin extends JavaPlugin {

    private LootTableConfig lootTableConfig;

    @Override
    public void onEnable() {
        CoreLib.setInstance(this);
        this.lootTableConfig = new LootTableConfig();
        JPUtils.registerEvents(new PlayerWatcher(this.lootTableConfig));
        JPUtils.registerCommand("customlootables", new ReloadCommand(this));
        JPUtils.validateFiles("config.yml");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void reloadConfig() {
        this.lootTableConfig.reloadConfig();
    }
}
