package me.fridtjof.yggdrasil.cmds.admin;

import me.clip.placeholderapi.PlaceholderAPI;
import me.fridtjof.yggdrasil.utils.MSG;
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

        switch(args.length) {
            case 0 -> {
                sender.sendMessage(MSG.enterGameMode);
            }
            case 1 -> {
                if (sender instanceof Player player) {
                    setGameModes(player, args, player, false);
                    player.sendMessage(MSG.setGamemode.replaceAll("%ygg_gamemode%", args[0]));
                    return false;
                }
                sender.sendMessage(MSG.enterPlayer);
            }
            case 2 -> {
                Player targetPlayer = Bukkit.getPlayer(args[1]);

                if (targetPlayer == null) {
                    sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", args[1]));
                    return false;
                }
                setGameModes(sender, args, targetPlayer, true);
                sender.sendMessage(PlaceholderAPI.setPlaceholders(targetPlayer, MSG.setGamemodeOthers).replaceAll("%ygg_gamemode%", args[0]));
                targetPlayer.sendMessage(MSG.setGamemode.replaceAll("%ygg_gamemode%", args[0]));
            }
            default -> sender.sendMessage(MSG.tooManyArguments);
        }
        return false;
    }

    private void setGameModes(CommandSender sender, String[] args, Player targetPlayer, Boolean others) {

        String s = "";
        if(others) {
            s = ".others";
        }

        switch(args[0]) {
            case "0", "survival" -> {
                if (sender.hasPermission("yggdrasil.cmd.gm.0" + s)) {
                    targetPlayer.setGameMode(GameMode.SURVIVAL);
                    return;
                }
            }
            case "1", "creative" -> {
                if (sender.hasPermission("yggdrasil.cmd.gm.1" + s)) {
                    targetPlayer.setGameMode(GameMode.CREATIVE);
                    return;
                }
            }
            case "2", "adventure" -> {
                if (sender.hasPermission("yggdrasil.cmd.gm.2" + s)) {
                    targetPlayer.setGameMode(GameMode.ADVENTURE);
                    return;
                }
            }
            case "3", "spectator" -> {
                if (sender.hasPermission("yggdrasil.cmd.gm.3" + s)) {
                    targetPlayer.setGameMode(GameMode.SPECTATOR);
                    return;
                }
            }
            default -> {
                sender.sendMessage(MSG.incorrectArgument);
                return;
            }
        }

        sender.sendMessage(MSG.noPermission);
    }
}