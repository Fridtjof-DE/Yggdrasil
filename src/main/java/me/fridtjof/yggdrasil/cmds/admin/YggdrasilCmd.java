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

        switch(args.length) {
            case 0 -> {
                if(sender.hasPermission("yggdrasil.info") || sender.isOp()) {
                    sender.sendMessage(MSG.notEnoughArgs);
                    return false;
                }
                sender.sendMessage(MSG.noPermission);
            }
            case 1 -> {
                if(args[0].equals("info")) {
                    if(sender.hasPermission("yggdrasil.info") || sender.isOp()) {
                        sender.sendMessage("§b" + plugin.getName() + " v" + plugin.getDescription().getVersion() + " for Spigot v" + plugin.getDescription().getAPIVersion());
                    }
                    return false;
                }
                if(args[0].equals("reload")) {
                    if(sender.hasPermission("yggdrasil.reload") || sender.isOp()) {
                        sender.sendMessage("§eReloading the plugin...");
                        plugin.configManager.reloadConfigs();
                        sender.sendMessage("§aReload complete!");
                    }
                    return false;
                }
                sender.sendMessage(MSG.incorrectArgument);
            }
            default -> sender.sendMessage(MSG.tooManyArguments);
        }
        return false;
    }
}
