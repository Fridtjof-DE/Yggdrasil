package tk.fridtjof.yggdrasil.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.fridtjof.puddingapi.bukkit.chat.ChatAPI;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.cmds.user.SpawnCMD;
import tk.fridtjof.yggdrasil.utils.Templates;

public class OnJoin implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ChatAPI.sendTabList(plugin.configManager.messagesFile.getConfig().getString("tablist.header"), plugin.configManager.messagesFile.getConfig().getString("tablist.footer"));

        if(plugin.configManager.mainConfig.getConfig().getBoolean("spawn.tp_on_join")) {
            SpawnCMD.sendToSpawn(player);
        }

        if(plugin.configManager.mainConfig.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            String joinMSG = plugin.configManager.messagesFile.getConfig().getString("chat.join_msg");
            event.setJoinMessage(joinMSG.replaceAll("%player%", player.getDisplayName()));
        }
    }
}
