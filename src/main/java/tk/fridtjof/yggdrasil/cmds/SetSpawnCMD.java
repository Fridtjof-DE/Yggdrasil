package tk.fridtjof.yggdrasil.cmds;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class SetSpawnCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if (sender.hasPermission("yggdrasil.cmd.setspawn") || sender.isOp()) {
                Player player = (Player) sender;
                Location loc = player.getLocation();
                double posX = loc.getX();
                double posY = loc.getY();
                double posZ = loc.getZ();
                player.sendMessage(s + MSG.spawnSetTo + p + posX + " " + posY + " " + posZ);

                plugin.reloadConfig();

                plugin.getConfig().set("spawn.x", posX);
                plugin.getConfig().set("spawn.y", posY);
                plugin.getConfig().set("spawn.z", posZ);

                plugin.getConfig().options().copyDefaults(true);
                plugin.saveConfig();
            }
        } else {
            sender.sendMessage(MSG.playerOnly);
        }

        return false;
    }
}
