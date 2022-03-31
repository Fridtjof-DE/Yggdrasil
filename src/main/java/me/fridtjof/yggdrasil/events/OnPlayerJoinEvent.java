package me.fridtjof.yggdrasil.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.fridtjof.puddingapi.bukkit.items.PlayerHead;
import me.fridtjof.yggdrasil.utils.Lobby;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.fridtjof.puddingapi.bukkit.chat.ChatAPI;
import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.cmds.user.SpawnCMD;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnPlayerJoinEvent implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ChatAPI.sendTabList(plugin.configManager.messagesFile.getConfig().getString("tablist.header"), plugin.configManager.messagesFile.getConfig().getString("tablist.footer"));

        if(plugin.configManager.mainConfig.getConfig().getBoolean("spawn.tp_on_join")) {
            SpawnCMD.sendToSpawn(player);
        }

        if(plugin.configManager.mainConfig.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            event.setJoinMessage(PlaceholderAPI.setPlaceholders(event.getPlayer(), plugin.configManager.messagesFile.getConfig().getString("chat.join_msg")));
        }
    }
}
