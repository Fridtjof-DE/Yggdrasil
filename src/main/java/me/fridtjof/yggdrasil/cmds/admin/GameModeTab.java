package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.puddingapi.bukkit.utils.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameModeTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> arguments1 = new ArrayList<String>();
        List<String> arguments2 = new ArrayList<String>();
        List<String> result = new ArrayList<>();

        if(sender.hasPermission("yggdrasil.cmd.gm.0") || sender.isOp()) {
            arguments1.add("0");
            arguments1.add("survival");
        }
        if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.0.others") || sender.isOp()) {
                ArrayUtils.addAllPlayers(arguments2);
            }
        }

        if(sender.hasPermission("yggdrasil.cmd.gm.1") || sender.isOp()) {
            arguments1.add("1");
            arguments1.add("creative");
        }

        if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.1.others") || sender.isOp()) {
                ArrayUtils.addAllPlayers(arguments2);
            }
        }

        if(sender.hasPermission("yggdrasil.cmd.gm.2") || sender.isOp()) {
            arguments1.add("2");
            arguments1.add("adventure");
        }

        if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.2.others") || sender.isOp()) {
                ArrayUtils.addAllPlayers(arguments2);
            }
        }

        if(sender.hasPermission("yggdrasil.cmd.gm.3") || sender.isOp()) {
            arguments1.add("3");
            arguments1.add("spectator");
        }

        if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.3.others") || sender.isOp()) {
                ArrayUtils.addAllPlayers(arguments2);
            }
        }



        if (args.length == 1) {
            for (String a : arguments1) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        } else if (args.length == 2) {
            for (String a : arguments2) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        } else if (args.length >= 3) {
            return result;
        }

        return null;
    }
}