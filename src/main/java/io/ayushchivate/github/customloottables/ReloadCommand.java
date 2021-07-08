package io.ayushchivate.github.customloottables;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    CustomLootTablesPlugin plugin;

    public ReloadCommand(CustomLootTablesPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0 && args[0].equals("reload")) {

            if (!sender.hasPermission("customloottables.reload")) {
                sender.sendMessage("You do not have permissions to use this command!");
                return false;
            }

            this.plugin.reloadConfig();
            sender.sendMessage("The plugin has been reloaded.");
            return true;
        }

        return false;
    }

}
