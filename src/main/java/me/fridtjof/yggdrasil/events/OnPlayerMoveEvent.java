package me.fridtjof.yggdrasil.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.cmds.user.SpawnCMD;

public class OnPlayerMoveEvent implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (plugin.configManager.mainConfig.getConfig().getBoolean("spawn.auto_tp.enable")) {
            Player player = event.getPlayer();
            if (player.getLocation().getY() <= plugin.configManager.mainConfig.getConfig().getDouble("spawn.auto_tp.y")) {
                SpawnCMD.sendToSpawn(player);
            }
        }
    }
}