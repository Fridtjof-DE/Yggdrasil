package me.fridtjof.yggdrasil.events;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import me.fridtjof.puddingapi.bukkit.chat.ChatAPI;
import me.fridtjof.yggdrasil.Yggdrasil;

public class OnPlayerQuitEvent implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        ChatAPI.sendTabList(plugin.configManager.messagesFile.getConfig().getString("tablist.header"), plugin.configManager.messagesFile.getConfig().getString("tablist.footer"));

        if(plugin.configManager.mainConfig.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            event.setQuitMessage(PlaceholderAPI.setPlaceholders(event.getPlayer(), plugin.configManager.messagesFile.getConfig().getString("chat.quit_msg")));
        }
    }
}
