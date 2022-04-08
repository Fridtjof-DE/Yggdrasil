package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.yggdrasil.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.cmds.admin.GameModeTab;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCmd implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public Heal() {
        plugin.getCommand("heal").setTabCompleter(new HealTab());
    }

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
                    sender.sendMessage(MSG.youHealed.replaceAll("%player%", args[0]));
                } else {
                    sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", args[0]));
                }
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else {
            sender.sendMessage(MSG.tooManyArguments);
        }

        return false;
    }
}
