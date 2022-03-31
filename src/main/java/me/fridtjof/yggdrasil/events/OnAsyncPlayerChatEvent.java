package me.fridtjof.yggdrasil.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import me.fridtjof.yggdrasil.Yggdrasil;

public class OnAsyncPlayerChatEvent implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

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
}
