package me.fridtjof.yggdrasil.events;

import me.fridtjof.yggdrasil.cmds.user.SpawnCMD;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import me.fridtjof.yggdrasil.Yggdrasil;

public class OnPlayerRespawnEvent implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if(plugin.configManager.mainConfig.getConfig().getBoolean("spawn.tp_on_respawn")) {

            double posX = plugin.configManager.dataFile.getConfig().getDouble("spawn.x");
            double posY = plugin.configManager.dataFile.getConfig().getDouble("spawn.y");
            double posZ = plugin.configManager.dataFile.getConfig().getDouble("spawn.z");
            Location location = new Location(Bukkit.getWorld("world"), posX, posY, posZ);

            event.setRespawnLocation(location);
        }
    }
}
