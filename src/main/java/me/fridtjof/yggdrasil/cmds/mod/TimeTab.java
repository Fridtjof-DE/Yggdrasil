package me.fridtjof.yggdrasil.cmds.mod;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TimeTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> arguments = new ArrayList<String>();
        List<String> result = new ArrayList<>();

        if (sender.hasPermission("yggdrasil.cmd." + command.getName() + ".other_worlds")) {

            for(World worlds : Bukkit.getWorlds()) {
                arguments.add(worlds.getName());
            }
        }

        if (args.length == 1) {

            for (String a : arguments) {

                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
            }
        }

        return result;
    }
}
