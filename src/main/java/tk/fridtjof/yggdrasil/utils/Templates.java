package tk.fridtjof.yggdrasil.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.puddingapi.bukkit.chat.ChatAPI;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;

public class Templates {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public static void timeCommand(CommandSender sender, Command command, String[] args, int ticks) {
        if(args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("yggdrasil.cmd."+ command.getName())) {
                    setTimeInWorld(player, player.getWorld().getName(), ticks);
                }
            } else {
                sender.sendMessage(MSG.enterWorld);
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
            sender.sendMessage(MSG.worldNotFound.replaceAll("%world%", worldName));
        } else {
            long time = ticks;
            world.setTime(time);
            sender.sendMessage(MSG.timeSet.replaceAll("%time%", Long.toString(time)).replaceAll("%world%", worldName));
        }
    }

    public static void setSpeed(CommandSender sender, String[] args, Player player) {
        if (player == null) {
            sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", args[0]));
        } else {
            float speed = Float.parseFloat(args[0]) / 5F;
            if (speed <= 1F && speed >= -1F) {

                String name = player.getName() + "'s";

                if(sender instanceof Player) {
                    Player senderPlayer = (Player) sender;
                    if (senderPlayer != null) {
                        if (senderPlayer.getName().equalsIgnoreCase(player.getName())) {
                            name = "your";
                        }
                    }
                }

                if (player.isFlying()) {
                    player.setFlySpeed(speed);
                    sender.sendMessage(MSG.setFlySpeed.replaceAll("%speed%", args[0]).replaceAll("%player%", name));
                } else {
                    player.setWalkSpeed(speed);
                    sender.sendMessage(MSG.setWalkSpeed.replaceAll("%speed%", args[0]).replaceAll("%player%", name));
                }

            } else {
                player.sendMessage(MSG.incorrectArgument);
            }
        }
    }
}
