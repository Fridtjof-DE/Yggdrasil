package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.yggdrasil.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GameModeCmd implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public GameModeCmd() {
        plugin.getCommand("gamemode").setTabCompleter(new GameModeTab());
        plugin.getCommand("gm").setTabCompleter(new GameModeTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                setGameModes(player, args, player, false);
            } else {
                sender.sendMessage(MSG.enterPlayer);
            }
        } else if (args.length == 2) {
            Player player = Bukkit.getPlayer(args[1]);

            if (player == null) {
                sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", args[1]));
            } else {
                setGameModes(sender, args, player, true);
            }
        } else if(args.length == 0) {
            sender.sendMessage(MSG.enterGameMode);
        } else {
            sender.sendMessage(MSG.tooManyArguments);
        }

        return false;
    }

    private void setGameModes(CommandSender sender, String[] args, Player player, Boolean others) {
        String s = "";

        if(others == true) {
            s = ".others";
        }

        if (args[0].equals("0") || args[0].equals("survival")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.0" + s)) {
                player.setGameMode(GameMode.SURVIVAL);
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else if (args[0].equals("1") || args[0].equals("creative")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.1" + s)) {
                player.setGameMode(GameMode.CREATIVE);
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else if (args[0].equals("2") || args[0].equals("adventure")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.2" + s)) {
                player.setGameMode(GameMode.ADVENTURE);
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else if (args[0].equals("3") || args[0].equals("spectator")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.3" + s)) {
                player.setGameMode(GameMode.SPECTATOR);
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else {
            sender.sendMessage(MSG.incorrectArgument);
        }
    }
}