package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.puddingapi.bukkit.cmds.ArgumentParser;
import me.fridtjof.puddingapi.bukkit.player.PlayerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class SpeedTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> argList1 = new ArrayList<String>();
        List<String> argList2 = new ArrayList<String>();

        String s = "speed";

        for(int i = -5; i <= 5; i++) {
            if(sender.hasPermission("yggdrasil.cmd." + s + "." + i) || sender.isOp()) {
                argList1.add(i + "");
            }
        }

        for(int i = -5; i <= 5; i++) {
            if(sender.hasPermission("yggdrasil.cmd." + s + ".others." + i) || sender.isOp()) {
                PlayerUtils.addAllPlayers(argList2);
            }
        }

        return ArgumentParser.parseArgs(args, argList1, argList2);
    }
}