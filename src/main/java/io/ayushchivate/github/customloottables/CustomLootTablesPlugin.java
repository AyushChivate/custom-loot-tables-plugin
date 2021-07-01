package io.ayushchivate.github.customloottables;

import net.dohaw.corelib.CoreLib;
import net.dohaw.corelib.JPUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomLootTablesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        CoreLib.setInstance(this);
        JPUtils.registerEvents(new PlayerWatcher());
        JPUtils.validateFiles("config.yml");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
