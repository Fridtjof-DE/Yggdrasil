package me.fridtjof.yggdrasil.events;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import static org.bukkit.Bukkit.getServer;

public class EventManager implements Listener {

    public EventManager(JavaPlugin plugin) {
        registerListeners(plugin);
    }

    private void registerListeners(JavaPlugin plugin) {
        getServer().getPluginManager().registerEvents(new OnPlayerJoinEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnPlayerMoveEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnPlayerQuitEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnPlayerRespawnEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnEntityDamageEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnEntityDamageByEntityEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnFoodLevelChangeEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnPlayerDropItemEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnPlayerInteractEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnInventoryClickEvent(), plugin);
        getServer().getPluginManager().registerEvents(new OnAsyncPlayerChatEvent(), plugin);
    }
}