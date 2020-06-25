package tk.fridtjof.yggdrasil.cmds;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class SpawnCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("yggdrasil.cmd.spawn") || sender.isOp()) {
            Player player = (Player) sender;
            sendToSpawn(player);
        }

        return false;
    }

    public static void sendToSpawn(Player player) {
        double posX = plugin.getConfig().getDouble("spawn.x");
        double posY = plugin.getConfig().getDouble("spawn.y");
        double posZ = plugin.getConfig().getDouble("spawn.z");

        Location loc = new Location(player.getWorld(), posX, posY, posZ);
        player.teleport(loc);
        player.setFallDistance(0F);
    }
}
