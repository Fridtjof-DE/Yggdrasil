package me.fridtjof.yggdrasil.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.fridtjof.puddingapi.bukkit.chat.ChatUtils;
import me.fridtjof.yggdrasil.utils.MSG;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import me.fridtjof.yggdrasil.Yggdrasil;

public class OnAsyncPlayerChatEvent implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler (priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent event) {

        event.setCancelled(true);

        if(event.getPlayer().hasPermission("yggdrasil.chat.formatting_codes") || event.getPlayer().isOp()) {
            event.setMessage(ChatUtils.format(event.getMessage()));
        }

        event.setMessage(PlaceholderAPI.setPlaceholders(event.getPlayer(), ChatUtils.format(MSG.chatPrefix) + event.getMessage()));

        //make server message
        Bukkit.broadcastMessage(event.getMessage());
    }
}
