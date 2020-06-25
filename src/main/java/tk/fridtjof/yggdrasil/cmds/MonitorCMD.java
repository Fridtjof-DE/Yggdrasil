package tk.fridtjof.yggdrasil.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

public class MonitorCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("yggdrasil.cmd.monitor") || sender.isOp()) {

            Runtime r = Runtime.getRuntime();
            long memTotal = r.totalMemory() / 1048576;
            long memFree = r.freeMemory() / 1048576;
            long memUsed = memTotal - memFree;
            double memPercent = (double) memUsed / (double) memTotal * 100;

            String memPercentPrefix = "§a";
            if(memPercent >= 65) {
                memPercentPrefix = "§2";
            } else if(memPercent >= 80) {
                memPercentPrefix = "§e";
            } else if(memPercent >= 90) {
                memPercentPrefix = "§c";
            } else if(memPercent >= 95) {
                memPercentPrefix = "§4";
            }

            DecimalFormat df2 = new DecimalFormat("##.##");
           // double tps1 = Array.getDouble(Bukkit.getServer().getTPS(), 0);
            //double tps5 = Array.getDouble(Bukkit.getServer().getTPS(), 1);
            //double tps15 = Array.getDouble(Bukkit.getServer().recentTps, 2);

            //sender.sendMessage(p + "§l§nPerformance Overview:§r\n" + s + "TPS from last 1m, 5m, 15m: " + String.format("%.2f", tps1) + ", " + String.format("%.2f", tps5) + ", " + String.format("%.2f", tps15) + "\n" + s +
            //        "Memory Usage: " + memPercentPrefix + (int) memPercent + "% - " + memUsed + "mb/" + memTotal + "mb - " + memFree + "mb free");
        } else {
            sender.sendMessage("§cYou don't have the permission to do that!");
        }

        return false;
    }
}