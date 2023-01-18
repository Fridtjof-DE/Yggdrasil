package me.fridtjof.yggdrasil.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.fridtjof.puddingapi.bukkit.chat.ChatUtils;
import me.fridtjof.yggdrasil.utils.MSG;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.cmds.user.SpawnCMD;

public class OnPlayerJoinEvent implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ChatUtils.sendTabList(MSG.tabListHeader, MSG.tabListFooter);

        if(plugin.configManager.mainConfig.getConfig().getBoolean("spawn.tp_on_join")) {
            SpawnCMD.sendToSpawn(player);
        }

        if(plugin.configManager.mainConfig.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            event.setJoinMessage(PlaceholderAPI.setPlaceholders(event.getPlayer(), plugin.configManager.messagesFile.getConfig().getString("chat.join_msg")));
        }
    }
}
