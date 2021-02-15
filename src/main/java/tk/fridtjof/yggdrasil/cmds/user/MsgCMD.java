package tk.fridtjof.yggdrasil.cmds.user;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.MSG;

public class MsgCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("yggdrasil.msg") || sender.isOp()) {

            if (args.length == 1) {
                sender.sendMessage(MSG.enterMessage);
            } else if (args.length >= 2) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    String msg = "";

                    int i = 1;

                    while (i < args.length) {
                        msg = msg + " " + args[i];
                        i = i + 1;
                    }

                    sender.sendMessage("[" + "Me" + "] " + ">>> " + "[" + target.getName() + "]§r:" + msg);
                    target.sendMessage("[" + sender.getName() + "] " + ">>> " + "[" + "Me" + "]§r:" + msg);

                } else if (!(target != null)) {
                    sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", args[0]));
                }
            }
        } else {
            sender.sendMessage(MSG.noPermission);
        }

        return false;
    }
}
