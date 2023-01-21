package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.puddingapi.bukkit.cmds.ArgumentParser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class YggdrasilTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> argList = new ArrayList<String>();

        if(sender.hasPermission("yggdrasil.reload") || sender.isOp()) {
            argList.add("reload");
        }
        if(sender.hasPermission("yggdrasil.info") || sender.isOp()) {
            argList.add("info");
        }

        return ArgumentParser.parseArgs(args, argList);
    }
}

