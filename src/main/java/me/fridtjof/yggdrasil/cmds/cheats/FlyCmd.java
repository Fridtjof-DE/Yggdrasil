package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.yggdrasil.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.cmds.admin.GameModeTab;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.fridtjof.puddingapi.bukkit.player.PlayerAPI;

public class FlyCmd implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public FlyCmd() {
        plugin.getCommand("fly").setTabCompleter(new FlyTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            if(sender instanceof Player) {
                if (sender.hasPermission("yggdrasil.cmd.fly") || sender.isOp()) {
                    Player player = (Player) sender;
                    PlayerAPI.toggleFly(player);
                    player.sendMessage(MSG.toggledFly);
                } else {
                    sender.sendMessage(MSG.noPermission);
                }
            } else {
                sender.sendMessage(MSG.enterPlayer);
            }
        } else if(args.length == 1) {
            if(sender.hasPermission("yggdrasil.cmd.fly.others") || sender.isOp()) {
                Player player = Bukkit.getPlayer(args[0]);
                if(player != null) {
                    PlayerAPI.toggleFly(player);
                    sender.sendMessage(MSG.youToggledFly.replaceAll("%player%", args[0]));
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