package me.fridtjof.yggdrasil.events;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import static org.bukkit.Bukkit.getServer;

public class EventManager implements Listener {

    public EventManager(JavaPlugin plugin) {
        registerListeners(plugin);
    }

    private void registerListeners(JavaPlugin plugin) {
        getServer().getPluginManager().registerEvents(new OnJoin(), plugin);
        getServer().getPluginManager().registerEvents(new OnMove(), plugin);
        getServer().getPluginManager().registerEvents(new OnChat(), plugin);
        getServer().getPluginManager().registerEvents(new OnQuit(), plugin);
        getServer().getPluginManager().registerEvents(new OnRespawn(), plugin);
    }
}