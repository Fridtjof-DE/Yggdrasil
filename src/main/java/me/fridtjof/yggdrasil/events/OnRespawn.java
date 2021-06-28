package me.fridtjof.yggdrasil.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import me.fridtjof.yggdrasil.Yggdrasil;

public class OnRespawn implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

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
