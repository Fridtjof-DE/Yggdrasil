package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.puddingapi.bukkit.player.PlayerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class SpeedTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> arguments1 = new ArrayList<String>();
        List<String> arguments2 = new ArrayList<String>();
        List<String> result = new ArrayList<>();

        String s = "speed";

        for(int i = -5; i <= 5; i++) {
            if(sender.hasPermission("yggdrasil.cmd." + s + "." + i) || sender.isOp()) {
                arguments1.add(i + "");
            }
        }

        for(int i = -5; i <= 5; i++) {
            if(sender.hasPermission("yggdrasil.cmd." + s + ".others." + i) || sender.isOp()) {
                PlayerUtils.addAllPlayers(arguments2);
            }
        }

        if (args.length == 1) {
            for (String a : arguments1) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        }

        if (args.length == 2) {
            for (String a : arguments2) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        }

        if (args.length >= 3) {
            return result;
        }

        return null;
    }
}