package me.fridtjof.yggdrasil.cmds.admin;

import me.fridtjof.yggdrasil.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if (sender.hasPermission("yggdrasil.cmd.setspawn") || sender.isOp()) {
                Player player = (Player) sender;
                Location loc = player.getLocation();
                double posX = loc.getX();
                double posY = loc.getY();
                double posZ = loc.getZ();
                player.sendMessage(MSG.spawnSetTo + posX + " " + posY + " " + posZ);

                plugin.configManager.dataFile.getConfig().set("spawn.x", posX);
                plugin.configManager.dataFile.getConfig().set("spawn.y", posY);
                plugin.configManager.dataFile.getConfig().set("spawn.z", posZ);

                plugin.configManager.dataFile.getConfig().options().copyDefaults(true);
                plugin.configManager.dataFile.save();
            }
        } else {
            sender.sendMessage(MSG.playerOnly);
        }

        return false;
    }
}
