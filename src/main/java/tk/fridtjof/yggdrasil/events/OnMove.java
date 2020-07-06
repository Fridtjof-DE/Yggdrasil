package tk.fridtjof.yggdrasil.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.cmds.user.SpawnCMD;

public class OnMove implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (plugin.getConfig().getBoolean("spawn.auto_tp.enable")) {
            Player player = event.getPlayer();
            if (player.getLocation().getY() <= plugin.getConfig().getDouble("spawn.auto_tp.y")) {
                SpawnCMD.sendToSpawn(player);
            }
        }
    }
}