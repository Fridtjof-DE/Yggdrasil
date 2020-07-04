package tk.fridtjof.yggdrasil;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import tk.fridtjof.yggdrasil.cmds.SpawnCMD;

public class EventManager implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(plugin.getConfig().getBoolean("spawn.auto_tp.enable")) {
            Player player = event.getPlayer();
            if (player.getLocation().getY() <= plugin.getConfig().getDouble("spawn.auto_tp.y")) {
                SpawnCMD.sendToSpawn(player);
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(plugin.getConfig().getBoolean("spawn.tp_on_join")) {
            SpawnCMD.sendToSpawn(player);
        }

        if(plugin.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            String joinMSG = plugin.getConfig().getString("chat.join_msg");
            event.setJoinMessage(joinMSG.replaceAll("%player%", player.getDisplayName()));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if(plugin.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            String quitMSG = plugin.getConfig().getString("chat.quit_msg");
            event.setQuitMessage(quitMSG.replaceAll("%player%", player.getDisplayName()));
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if(player.hasPermission("yggdrasil.chat.color_codes") || player.isOp()) {
            event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
        }

        if(player.hasPermission("yggdrasil.chat.formatting_codes") || player.isOp()) {
            event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if(plugin.getConfig().getBoolean("spawn.tp_on_respawn")) {
            Player player = event.getPlayer();

            double posX = plugin.getConfig().getDouble("spawn.x");
            double posY = plugin.getConfig().getDouble("spawn.y");
            double posZ = plugin.getConfig().getDouble("spawn.z");
            Location loc = new Location(player.getWorld(), posX, posY, posZ);
            event.setRespawnLocation(loc);
        }
    }
}