package tk.fridtjof.yggdrasil.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class HealCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            if(sender instanceof Player) {
                if (sender.hasPermission("yggdrasil.cmd.heal") || sender.isOp()) {
                    Player player = (Player) sender;
                    player.setHealth(20D);
                    if (plugin.getConfig().getBoolean("cmds.heal.feed_on_heal")) {
                        player.setFoodLevel(20);
                    }
                    player.sendMessage(MSG.youveBeenHealed);
                } else {
                    sender.sendMessage(MSG.noPermission);
                }
            } else {
                sender.sendMessage(MSG.enterPlayer);
            }
        } else if(args.length == 1) {
            if(sender.hasPermission("yggdrasil.cmd.heal.others") || sender.isOp()) {
                Player player = Bukkit.getPlayer(args[0]);
                if(player != null) {
                    player.setHealth(20D);
                    if (plugin.getConfig().getBoolean("cmds.heal.feed_on_heal")) {
                        player.setFoodLevel(20);
                    }
                    sender.sendMessage(MSG.youHealed.replaceAll("%play er%", p + args[0] + s));
                } else {
                    sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", p + args[0]));
                }
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else {
            sender.sendMessage(MSG.tooManyArgs);
        }

        return false;
    }
}
