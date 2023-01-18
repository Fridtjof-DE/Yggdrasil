package me.fridtjof.yggdrasil.cmds.mod;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.fridtjof.yggdrasil.utils.SharedMethods;

public class TimeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String cmdName = command.getName();
        int ticks = -1;

        if(cmdName.equalsIgnoreCase("day")) {
            ticks = 1000;
        } else if(cmdName.equalsIgnoreCase("midnight")) {
            ticks = 18000;
        } else if(cmdName.equalsIgnoreCase("night")) {
            ticks = 13000;
        } else if(cmdName.equalsIgnoreCase("noon")) {
            ticks = 6000;
        }

        if(ticks != -1) {
            SharedMethods.timeCommand(sender, command, args, ticks);
        }

        return false;
    }
}