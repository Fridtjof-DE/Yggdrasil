package me.fridtjof.yggdrasil.cmds.cheats;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HealTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> arguments1 = new ArrayList<String>();
        List<String> result = new ArrayList<>();

        if(sender.hasPermission("yggdrasil.cmd.heal.others") || sender.isOp()) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                arguments1.add(p.getName());
            }
        }

        if (args.length == 1) {
            for (String a : arguments1) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        } else if (args.length >= 2) {
            return result;
        }

        return null;
    }
}