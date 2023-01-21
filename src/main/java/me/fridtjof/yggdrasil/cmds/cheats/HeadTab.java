package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.puddingapi.bukkit.cmds.ArgumentParser;
import me.fridtjof.puddingapi.bukkit.player.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HeadTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> argList1 = new ArrayList<String>();
        List<String> argList2 = new ArrayList<String>();

        if(sender.hasPermission("yggdrasil.cmd.head.others") || sender.isOp()) {
            PlayerUtils.addAllPlayers(argList1);
        }
        if(sender.hasPermission("yggdrasil.cmd.head.give_others") || sender.isOp()) {
            PlayerUtils.addAllPlayers(argList2);
        }

        return ArgumentParser.parseArgs(args, argList1, argList2);
    }
}