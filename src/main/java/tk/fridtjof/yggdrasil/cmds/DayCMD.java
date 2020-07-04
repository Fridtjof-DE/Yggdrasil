package tk.fridtjof.yggdrasil.cmds;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class DayCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yggdrasil.day")) {
                    setTimeInWorld(player, player.getWorld().getName());
                }
            } else {
                sender.sendMessage(MSG.enterWord);
            }
        } else if(args.length == 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yggdrasil.day")) {

                    setTimeInWorld(player, args[0]);
                }
            } else {
                setTimeInWorld(sender, args[0]);
            }
        } else {
            sender.sendMessage(MSG.tooManyArgs);
        }

        return false;
    }

    private void setTimeInWorld(CommandSender sender, String worldName) {
        World world = Bukkit.getWorld(worldName);
        if(world == null) {
            sender.sendMessage(MSG.worldNotFound.replaceAll("%world%", p + worldName));
        } else {
            long time = 1000;
            world.setTime(time);
            sender.sendMessage(s + MSG.timeSet.replaceAll("%time%", p + time + s).replaceAll("%world%", p + worldName));
        }
    }
}