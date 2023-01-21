package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.puddingapi.bukkit.cmds.ArgumentParser;
import me.fridtjof.puddingapi.bukkit.player.PlayerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class GameModeTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> argList1 = new ArrayList<String>();
        List<String> argList2 = new ArrayList<String>();

        if(sender.hasPermission("yggdrasil.cmd.gm.0") || sender.isOp()) {
            argList1.add("0");
            argList1.add("survival");
        }
        if(sender.hasPermission("yggdrasil.cmd.gm.1") || sender.isOp()) {
            argList1.add("1");
            argList1.add("creative");
        }
        if(sender.hasPermission("yggdrasil.cmd.gm.2") || sender.isOp()) {
            argList1.add("2");
            argList1.add("adventure");
        }
        if(sender.hasPermission("yggdrasil.cmd.gm.3") || sender.isOp()) {
            argList1.add("3");
            argList1.add("spectator");
        }

        if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.0.others") || sender.isOp()) {
                PlayerUtils.addAllPlayers(argList2);
            }
        }
        if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.1.others") || sender.isOp()) {
                PlayerUtils.addAllPlayers(argList2);
            }
        }
        if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.2.others") || sender.isOp()) {
                PlayerUtils.addAllPlayers(argList2);
            }
        }
        if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
            if(sender.hasPermission("yggdrasil.cmd.gm.3.others") || sender.isOp()) {
                PlayerUtils.addAllPlayers(argList2);
            }
        }

        return ArgumentParser.parseArgs(args ,argList1, argList2);
    }
}