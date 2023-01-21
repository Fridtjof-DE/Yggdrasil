package me.fridtjof.yggdrasil.cmds.cheats;

import me.clip.placeholderapi.PlaceholderAPI;
import me.fridtjof.puddingapi.bukkit.player.PlayerUtils;
import me.fridtjof.yggdrasil.utils.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCmd implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public FlyCmd() {
        plugin.getCommand("fly").setTabCompleter(new FlyTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch(args.length) {
            case 0 -> {
                if(sender instanceof Player) {
                    if (sender.hasPermission("yggdrasil.cmd.fly") || sender.isOp()) {
                        Player player = (Player) sender;
                        PlayerUtils.toggleFly(player);
                        player.sendMessage(MSG.toggledFly);
                        return false;
                    }
                    sender.sendMessage(MSG.noPermission);
                    return false;
                }
                sender.sendMessage(MSG.enterPlayer);
            }
            case 1 -> {
                if(sender.hasPermission("yggdrasil.cmd.fly.others") || sender.isOp()) {

                    Player targetPlayer = Bukkit.getPlayer(args[0]);
                    if(targetPlayer != null) {
                        PlayerUtils.toggleFly(targetPlayer);
                        sender.sendMessage(PlaceholderAPI.setPlaceholders(targetPlayer, MSG.toggledFlyOthers));
                        targetPlayer.sendMessage(MSG.toggledFly);
                        return false;
                    }
                    sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", args[0]));
                    return false;
                }
                sender.sendMessage(MSG.noPermission);
            }
            default -> sender.sendMessage(MSG.tooManyArguments);
        }
        return false;
    }
}