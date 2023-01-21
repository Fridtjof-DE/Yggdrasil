package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.puddingapi.bukkit.cmds.ArgumentParser;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FlyTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> argList = new ArrayList<String>();

        if(sender.hasPermission("yggdrasil.cmd.fly.others") || sender.isOp()) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                argList.add(p.getName());
            }
        }

        return ArgumentParser.parseArgs(args, argList);
    }
}