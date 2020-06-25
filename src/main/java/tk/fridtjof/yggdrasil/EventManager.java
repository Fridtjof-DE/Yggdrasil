package tk.fridtjof.yggdrasil;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import tk.fridtjof.yggdrasil.utils.ColorCodes;
import tk.fridtjof.yggdrasil.utils.FormattingCodes;

public class EventManager implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getLocation().getY() <= - 10) {
            Location loc = new Location(player.getWorld(), 8D, 4D, 8D);
            player.teleport(loc);
            player.setFallDistance(0F);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWrite(SignChangeEvent e) {

        if(plugin.getConfig().getBoolean("modules.sign_formatting")) {

            if (!e.getPlayer().hasPermission("sss.sign.color_codes") || e.getPlayer().isOp()) {

                ColorCodes c = new ColorCodes();

                e.setLine(0, c.Format(e.getLine(0)));
                e.setLine(1, c.Format(e.getLine(1)));
                e.setLine(2, c.Format(e.getLine(2)));
                e.setLine(3, c.Format(e.getLine(3)));
            }

            if (!e.getPlayer().hasPermission("sss.sign.formatting_codes") || e.getPlayer().isOp()) {

                FormattingCodes c = new FormattingCodes();

                e.setLine(0, c.Format(e.getLine(0)));
                e.setLine(1, c.Format(e.getLine(1)));
                e.setLine(2, c.Format(e.getLine(2)));
                e.setLine(3, c.Format(e.getLine(3)));
            }
        }
    }
}