package me.fridtjof.yggdrasil.cmds.admin;

import me.clip.placeholderapi.PlaceholderAPI;
import me.fridtjof.yggdrasil.utils.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class GameModeCmd implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public GameModeCmd() {
        plugin.getCommand("gamemode").setTabCompleter(new GameModeTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String others = "";
        Player targetPlayer = null;

        switch (args.length) {
            case 1 -> {
                if(sender instanceof ConsoleCommandSender) {
                    return false;
                }
                targetPlayer = (Player) sender;
            }
            case 2 -> {
                others = ".others";
                targetPlayer = Bukkit.getPlayer(args[1]);
            }
            default -> {
                return false;
            }
        }

        if(targetPlayer == null) {
            sender.sendMessage(MSG.playerNotFound.replaceAll("%ygg_player%", args[1]));
            return true;
        }

        switch(args[0]) {
            case "0", "survival" -> {
                if (sender.hasPermission("yggdrasil.cmd.gamemode" + others + ".survival") || sender.hasPermission("yggdrasil.cmd.gamemode.others.survival")) {
                    targetPlayer.setGameMode(GameMode.SURVIVAL);
                    sendMessages(sender, args, targetPlayer);
                    return true;
                }
            }
            case "1", "creative" -> {
                if(sender.hasPermission("yggdrasil.cmd.gamemode" + others + ".creative") || sender.hasPermission("yggdrasil.cmd.gamemode.others.creative")) {
                    targetPlayer.setGameMode(GameMode.CREATIVE);
                    sendMessages(sender, args, targetPlayer);
                    return true;
                }
            }
            case "2", "adventure" -> {
                if(sender.hasPermission("yggdrasil.cmd.gamemode" + others + ".adventure") || sender.hasPermission("yggdrasil.cmd.gamemode.others.adventure")) {
                    targetPlayer.setGameMode(GameMode.ADVENTURE);
                    sendMessages(sender, args, targetPlayer);
                    return true;
                }
            }
            case "3", "spectator" -> {
                if(sender.hasPermission("yggdrasil.cmd.gamemode" + others + ".spectator") || sender.hasPermission("yggdrasil.cmd.gamemode.others.spectator")) {
                    targetPlayer.setGameMode(GameMode.SPECTATOR);
                    sendMessages(sender, args, targetPlayer);
                    return true;
                }
            }
            default -> {
                return false;
            }
        }

        sender.sendMessage(MSG.noPermission);
        return true;
    }

    private void sendMessages(CommandSender sender, String[] args, Player targetPlayer) {

        if(args.length == 1) {
            targetPlayer.sendMessage(MSG.setGamemode.replaceAll("%ygg_gamemode%", args[0]));
            return;
        }

        if(sender instanceof Player) {
            if(((Player) sender).getPlayer() == targetPlayer) {
                targetPlayer.sendMessage(MSG.setGamemode.replaceAll("%ygg_gamemode%", args[0]));
                return;
            }
        }

        sender.sendMessage(PlaceholderAPI.setPlaceholders(targetPlayer, MSG.setGamemodeOthers).replaceAll("%ygg_gamemode%", args[0]));
        targetPlayer.sendMessage(MSG.setGamemode.replaceAll("%ygg_gamemode%", args[0]));
    }
}