package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.yggdrasil.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.utils.Templates;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage(MSG.enterValue);
        } else if(args.length == 1) {

            if(sender instanceof Player) {

                Player player = (Player) sender;

                String s = "walkspeed";
                if(player.isFlying()) {
                    s = "flyspeed";
                }

                if(sender.hasPermission("yggdrasil.cmd." + s + "." + args[0]) || player.isOp()) {
                    Templates.setSpeed(sender, args, player);
                }

            } else {
                sender.sendMessage(MSG.enterPlayer);
            }

        } else if(args.length == 2) {

            Player player = Bukkit.getPlayer(args[1]);

            if(player != null) {
                String s = "walkspeed";
                if (player.isFlying()) {
                    s = "flyspeed";
                }

                if (sender.hasPermission("yggdrasil.cmd." + s + ".others." + args[0]) || player.isOp()) {
                    Templates.setSpeed(sender, args, player);
                }
            } else {
                sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", args[0]));
            }

        } else {
            sender.sendMessage(MSG.tooManyArguments);
        }

        return false;
    }
}