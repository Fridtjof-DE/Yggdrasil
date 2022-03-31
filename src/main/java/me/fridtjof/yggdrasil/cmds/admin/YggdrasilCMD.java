package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.puddingapi.bukkit.utils.TabCompleter;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class YggdrasilCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public YggdrasilCMD() {
        TabCompleter tabCompleter = new TabCompleter();
        tabCompleter.addArgument("info", 1);
        tabCompleter.addArgument("reload", 1);
        tabCompleter.addArgument("s", 2);
        tabCompleter.addArgument(null, 3);
        plugin.getCommand("yggdrasil").setTabCompleter(tabCompleter);

        plugin.getCommand("yggdrasil").setTabCompleter(new YggdrasilTab());

        /*List<String> arguments = new ArrayList<String>();
        arguments.add("info");
        arguments.add("reload");
        TabCompleter tabCompleter = new TabCompleter();
        plugin.getCommand("yggdrasil").setTabCompleter(new TabCompleter(1, arguments));
        plugin.getCommand("yggdrasil").setTabCompleter(new TabCompleter(2, true));*/
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
