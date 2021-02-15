package tk.fridtjof.yggdrasil.cmds.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tk.fridtjof.yggdrasil.ConfigManager;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class YggdrasilCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage(p + plugin.getName() + " v" + plugin.getDescription().getVersion() + " for API v" + plugin.getDescription().getAPIVersion());

        } else if(args.length == 1) {
            if(args[0].equals("reload")) {
                if(sender.hasPermission("") || sender.isOp()) {
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
