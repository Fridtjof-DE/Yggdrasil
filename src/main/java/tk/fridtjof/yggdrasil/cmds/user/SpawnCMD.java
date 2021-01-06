package tk.fridtjof.yggdrasil.cmds.user;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class SpawnCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            if (sender instanceof Player) {
                if (sender.hasPermission("yggdrasil.cmd.spawn") || sender.isOp()) {
                    Player player = (Player) sender;
                    sendToSpawn(player);
                    sender.sendMessage(MSG.sendToSpawn);
                } else {
                    sender.sendMessage(MSG.noPermission);
                }
            } else {
                sender.sendMessage(MSG.enterPlayer);
            }
        } else if(args.length == 1) {
            if (sender.hasPermission("yggdrasil.cmd.spawn.others") || sender.isOp()) {
                Player player = Bukkit.getPlayer(args[0]);
                sendToSpawn(player);
                player.sendMessage(MSG.sendToSpawn);
                sender.sendMessage(s + MSG.sendToSpawnOthers.replaceAll("%target%", p + args[0] + s));
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else {
            sender.sendMessage(MSG.tooManyArguments);
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