package me.fridtjof.yggdrasil.cmds.mod;

import me.fridtjof.puddingapi.bukkit.cmds.ArgumentParser;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TimeTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> argList = new ArrayList<String>();

        if (sender.hasPermission("yggdrasil.cmd." + command.getName() + ".other_worlds")) {
            for(World worlds : Bukkit.getWorlds()) {
                argList.add(worlds.getName());
            }
        }

        return ArgumentParser.parseArgs(args, argList);
    }
}
