package me.fridtjof.yggdrasil.events;

import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.cmds.user.SpawnCMD;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnEntityDamageEvent implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onRespawn(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {

            if(event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if(plugin.configManager.mainConfig.getConfig().getBoolean("lobby.no_fall_damage")) {
                    event.setCancelled(true);
                }
            }

            if(plugin.configManager.mainConfig.getConfig().getBoolean("lobby.no_damage")) {
                event.setCancelled(true);
            }
        }
    }
}
