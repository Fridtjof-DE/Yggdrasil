package me.fridtjof.yggdrasil.cmds.mod;

import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.cmds.admin.YggdrasilTab;
import me.fridtjof.yggdrasil.utils.MSG;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class TimeCmd implements CommandExecutor {

    Yggdrasil plugin = Yggdrasil.getInstance();

    public TimeCmd() {
        plugin.getCommand("day").setTabCompleter(new TimeTab());
        plugin.getCommand("night").setTabCompleter(new TimeTab());
        plugin.getCommand("noon").setTabCompleter(new TimeTab());
        plugin.getCommand("midnight").setTabCompleter(new TimeTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String cmdName = command.getName();
        int ticks = -1;

        switch(cmdName) {
            case "day":
                ticks = 1000;
            case "midnight":
                ticks = 18000;
            case "night":
                ticks = 13000;
            case "noon":
                ticks = 6000;
        }

        timeCommand(sender, command, args, ticks);

        return false;
    }

    private void timeCommand(CommandSender sender, Command command, String[] args, int ticks) {

        if(args.length == 0) {

            if (sender instanceof Player player) {

                if (player.hasPermission("yggdrasil.cmd."+ command.getName())) {
                    setTimeInWorld(player, player.getWorld().getName(), ticks);
                }
                return;
            }
            sender.sendMessage(MSG.enterWorld);
            return;
        }

        if(args.length == 1) {

            if (sender instanceof Player player) {

                if (player.hasPermission("yggdrasil.cmd."+ command.getName())) {

                    setTimeInWorld(player, args[0], ticks);
                }
                return;
            }
            setTimeInWorld(sender, args[0], ticks);
            return;
        }
        sender.sendMessage(MSG.tooManyArguments);
    }

    private void setTimeInWorld(CommandSender sender, String worldName, int ticks) {
        World world = Bukkit.getWorld(worldName);

        if(world == null) {
            sender.sendMessage(MSG.worldNotFound.replaceAll("%world%", worldName));
            return;
        }

        world.setTime(ticks);
        sender.sendMessage(MSG.timeSet.replaceAll("%time%", Long.toString(ticks)).replaceAll("%world%", worldName));
    }
}