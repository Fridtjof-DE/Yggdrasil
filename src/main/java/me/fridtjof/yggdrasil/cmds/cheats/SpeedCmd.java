package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.puddingapi.general.utils.RegexUtils;
import me.fridtjof.yggdrasil.utils.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCmd implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public SpeedCmd() {
        plugin.getCommand("speed").setTabCompleter(new SpeedTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage(MSG.enterValue);
            return false;
        }

        if(args.length == 1) {

            if(sender instanceof Player player) {
                String s = "speed";

                if(player.isFlying()) {
                    s = "fly_speed";
                }

                if(sender.hasPermission("yggdrasil.cmd." + s + "." + args[0]) || player.isOp()) {
                    setSpeed(sender, args, player);
                }
                return false;
            }

            sender.sendMessage(MSG.notEnoughArgs);
            return false;
        }

        if(args.length == 2) {

            Player player = Bukkit.getPlayer(args[1]);

            if(player != null) {
                String s = "speed";

                if (player.isFlying()) {
                    s = "fly_speed";
                }

                if (sender.hasPermission("yggdrasil.cmd." + s + ".others." + args[0]) || player.isOp()) {
                    setSpeed(sender, args, player);
                }
                return false;
            }

            sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", args[1]));
            return false;
        }

        sender.sendMessage(MSG.tooManyArguments);
        return false;
    }

    private void setSpeed(CommandSender sender, String[] args, Player player) {

        if(RegexUtils.isNumeric(args[0])) {
            float speed = Float.parseFloat(args[0]) / 5F;

            if (speed <= 1F && speed >= -1F) {
                String name = player.getName() + "'s";

                if (sender instanceof Player senderPlayer) {

                    if (senderPlayer.getName().equalsIgnoreCase(player.getName())) {
                        name = "your";
                    }
                }
                if (player.isFlying()) {
                    player.setFlySpeed(speed);
                    sender.sendMessage(MSG.setFlySpeed.replaceAll("%speed%", args[0]).replaceAll("%player%", name));
                    return;
                }
                player.setWalkSpeed(speed);
                sender.sendMessage(MSG.setWalkSpeed.replaceAll("%speed%", args[0]).replaceAll("%player%", name));
                return;
            }
            player.sendMessage(MSG.incorrectArgument);
            return;
        }
        player.sendMessage(MSG.incorrectArgument);
    }
}