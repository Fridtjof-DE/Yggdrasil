package tk.fridtjof.yggdrasil.cmds.user;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.utils.Theme;

public class MsgCMD implements CommandExecutor {

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

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

                    sender.sendMessage(p + "[" + s + "Me" + p + "] " + s + ">>> " + p + "[" + s + target.getName() + p + "]§r:" + msg);
                    target.sendMessage(p + "[" + s + sender.getName() + p + "] " + s + ">>> " + p + "[" + s + "Me" + p + "]§r:" + msg);

                } else if (!(target != null)) {
                    sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", p + args[0]));
                }
            }
        } else {
            sender.sendMessage(MSG.noPermission);
        }

        return false;
    }
}
