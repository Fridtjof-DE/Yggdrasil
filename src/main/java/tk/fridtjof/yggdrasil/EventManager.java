package tk.fridtjof.yggdrasil;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import tk.fridtjof.yggdrasil.cmds.SpawnCMD;
import tk.fridtjof.yggdrasil.utils.ColorCodes;
import tk.fridtjof.yggdrasil.utils.FormattingCodes;
import tk.fridtjof.yggdrasil.utils.Log;

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
        if(plugin.getConfig().getBoolean("spawn.tp_on_join")) {
            Player player = event.getPlayer();
            SpawnCMD.sendToSpawn(player);
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

            //SpawnCMD.sendToSpawn(player);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWrite(SignChangeEvent e) {
        if (!e.getPlayer().hasPermission("yggdrasil.signs.color_codes") || e.getPlayer().isOp()) {

            ColorCodes c = new ColorCodes();

            e.setLine(0, c.Format(e.getLine(0)));
            e.setLine(1, c.Format(e.getLine(1)));
            e.setLine(2, c.Format(e.getLine(2)));
            e.setLine(3, c.Format(e.getLine(3)));
        }

        if (!e.getPlayer().hasPermission("yggdrasil.signs.formatting_codes") || e.getPlayer().isOp()) {

            FormattingCodes c = new FormattingCodes();

            e.setLine(0, c.Format(e.getLine(0)));
            e.setLine(1, c.Format(e.getLine(1)));
            e.setLine(2, c.Format(e.getLine(2)));
            e.setLine(3, c.Format(e.getLine(3)));
        }
    }
}