package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.puddingapi.general.utils.RegexUtils;
import me.fridtjof.yggdrasil.utils.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCmd implements CommandExecutor {

    Yggdrasil plugin = Yggdrasil.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("yggdrasil.cmd.spawn.set")) {

            double posX = 0, posY = 0, posZ = 0;
            float yaw = 0, pitch = 0;

            switch (args.length) {
                case 0 -> {
                    if (sender instanceof ConsoleCommandSender) {
                        return false;
                    }
                    Player player = (Player) sender;
                    Location loc = player.getLocation();
                    posX = loc.getX();
                    posY = loc.getY();
                    posZ = loc.getZ();
                    yaw = loc.getYaw();
                    pitch = loc.getPitch();
                }
                case 3 -> {
                    if (!(RegexUtils.isNumeric(args[0]) && RegexUtils.isNumeric(args[1]) && RegexUtils.isNumeric(args[2]))) {
                        return false;
                    }
                    posX = Float.parseFloat(args[0]);
                    posY = Float.parseFloat(args[1]);
                    posZ = Float.parseFloat(args[2]);
                }
                case 5 -> {
                    if (!(RegexUtils.isNumeric(args[0]) && RegexUtils.isNumeric(args[1]) && RegexUtils.isNumeric(args[2]) && RegexUtils.isNumeric(args[3]) && RegexUtils.isNumeric(args[4]))) {
                        return false;
                    }
                    posX = Double.parseDouble(args[0]);
                    posY = Double.parseDouble(args[1]);
                    posZ = Double.parseDouble(args[2]);
                    yaw = Float.parseFloat(args[3]);
                    pitch = Float.parseFloat(args[4]);
                }
                default -> {
                    return false;
                }
            }

            plugin.configManager.dataFile.getConfig().set("spawn.x", posX);
            plugin.configManager.dataFile.getConfig().set("spawn.y", posY);
            plugin.configManager.dataFile.getConfig().set("spawn.z", posZ);
            plugin.configManager.dataFile.getConfig().set("spawn.yaw", yaw);
            plugin.configManager.dataFile.getConfig().set("spawn.pitch", pitch);

            plugin.configManager.dataFile.getConfig().options().copyDefaults(true);
            plugin.configManager.dataFile.save();

            sender.sendMessage(MSG.spawnSetTo + posX + "/" + posY + "/" + posZ + " - " + yaw + "/" + pitch);

            return true;
        }
        sender.sendMessage(MSG.noPermission);
        return true;
    }
}
