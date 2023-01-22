package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.utils.MSG;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class YggdrasilCmd implements CommandExecutor {

    Yggdrasil plugin = Yggdrasil.getInstance();

    public YggdrasilCmd() {

        plugin.getCommand("yggdrasil").setTabCompleter(new YggdrasilTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 1) {
            switch(args[0]) {
                case "info" -> {
                    if (sender.hasPermission("yggdrasil.plugin.info")) {
                        sender.sendMessage("§b" + plugin.getName() + " v" + plugin.getDescription().getVersion() + " for Spigot v" + plugin.getDescription().getAPIVersion());
                        return true;
                    }
                    sender.sendMessage(MSG.noPermission);
                    return true;
                }
                case "reload" -> {
                    if (sender.hasPermission("yggdrasil.plugin.reload")) {
                        sender.sendMessage("§eReloading the plugin...");
                        plugin.configManager.reloadConfigs();
                        sender.sendMessage("§aReload complete!");
                        return true;
                    }
                    sender.sendMessage(MSG.noPermission);
                    return true;
                }
                default -> {
                    return false;
                }
            }
        }
        return false;
    }
}
