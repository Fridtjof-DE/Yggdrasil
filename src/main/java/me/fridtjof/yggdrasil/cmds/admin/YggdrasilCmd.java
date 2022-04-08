package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.puddingapi.bukkit.utils.TabCompleter;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class YggdrasilCmd implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public YggdrasilCmd() {

        plugin.getCommand("yggdrasil").setTabCompleter(new YggdrasilTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0 || args[0].equals("info")) {
            if(sender.hasPermission("yggdrasil.info") || sender.isOp()) {
                sender.sendMessage(plugin.getName() + " v" + plugin.getDescription().getVersion() + " for API v" + plugin.getDescription().getAPIVersion());
            }

        } else if(args.length == 1) {
            if(args[0].equals("reload")) {
                if(sender.hasPermission("yggdrasil.reload") || sender.isOp()) {
                    sender.sendMessage("§eReloading the plugin...");
                    plugin.configManager.reloadConfigs();
                    sender.sendMessage("§aReload complete!");
                }
            } else {
                sender.sendMessage("§cUnknown args!");
            }
        }

        return false;
    }
}
