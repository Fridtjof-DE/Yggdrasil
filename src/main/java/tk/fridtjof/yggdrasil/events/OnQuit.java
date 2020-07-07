package tk.fridtjof.yggdrasil.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Templates;

public class OnQuit implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        Templates.sendTabList();

        if(plugin.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            String quitMSG = plugin.getConfig().getString("chat.quit_msg");
            event.setQuitMessage(quitMSG.replaceAll("%player%", player.getDisplayName()));
        }
    }
}
