package me.fridtjof.yggdrasil.cmds.user;

import me.fridtjof.yggdrasil.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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