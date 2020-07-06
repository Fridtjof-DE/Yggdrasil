package tk.fridtjof.yggdrasil.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.MSG;

public class Templates {

    static String p = Theme.getPrimary();
    static String s = Theme.getSecondary();

    public static void timeCommand(CommandSender sender, Command command, String[] args, int ticks) {
        if(args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yggdrasil.cmd."+ command.getName())) {
                    setTimeInWorld(player, player.getWorld().getName(), ticks);
                }
            } else {
                sender.sendMessage(MSG.enterWord);
            }
        } else if(args.length == 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yggdrasil.cmd."+ command.getName())) {

                    setTimeInWorld(player, args[0], ticks);
                }
            } else {
                setTimeInWorld(sender, args[0], ticks);
            }
        } else {
            sender.sendMessage(MSG.tooManyArguments);
        }
    }

    private static void setTimeInWorld(CommandSender sender, String worldName, int ticks) {
        World world = Bukkit.getWorld(worldName);
        if(world == null) {
            sender.sendMessage(MSG.worldNotFound.replaceAll("%world%", p + worldName));
        } else {
            long time = ticks;
            world.setTime(time);
            sender.sendMessage(s + MSG.timeSet.replaceAll("%time%", p + time + s).replaceAll("%world%", p + worldName));
        }
    }
}
