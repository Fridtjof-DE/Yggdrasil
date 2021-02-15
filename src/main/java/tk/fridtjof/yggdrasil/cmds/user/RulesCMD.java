package tk.fridtjof.yggdrasil.cmds.user;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;

public class RulesCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("yggdrasil.cmd.rules") || sender.isOp()) {

            sender.sendMessage(plugin.configManager.messagesFile.getConfig().getString("info.rules"));

        } else {
            sender.sendMessage(MSG.noPermission);
        }

        return false;
    }
}