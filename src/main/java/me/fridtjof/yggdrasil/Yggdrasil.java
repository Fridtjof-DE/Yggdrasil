package me.fridtjof.yggdrasil;

import me.fridtjof.yggdrasil.cmds.CommandManager;
import me.fridtjof.yggdrasil.events.EventManager;
import me.fridtjof.yggdrasil.utils.CheckPuddingAPIVersion;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import me.fridtjof.puddingapi.bukkit.utils.Logger;
import me.fridtjof.puddingapi.bukkit.utils.Metrics;
import me.fridtjof.puddingapi.bukkit.utils.UpdateChecker;

import java.util.Optional;

//TODO Blitz wo man hinschaut

public final class Yggdrasil extends JavaPlugin {

    //TODO etc /fly /speed

    private static Yggdrasil instance;

    public Yggdrasil() {
        instance = this;
    }

    public static Yggdrasil getInstance() {
        return instance;
    }

    Logger logger = new Logger(this);

    public ConfigManager configManager;

    @Override
    public void onEnable() {

        if (Bukkit.getPluginManager().getPlugin("PuddingAPI") != null) {
            logger.info("PuddingAPI has been found, hooking in!");
        } else {
            logger.warn("PuddingAPI was not found, but is needed!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            logger.info("PlaceholderAPI has been found, hooking in!");
        } else {
            logger.warn("PlaceholderAPI was not found, but is needed!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        if (Bukkit.getPluginManager().getPlugin("Plan") != null) {
            logger.info("Plan has been found, hooking in!");
        } else {
            logger.warn("Plan was not found, continuing without!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        new CheckPuddingAPIVersion(this);
        configManager = new ConfigManager(this);
        new EventManager(this);
        new CommandManager(this);
        new UpdateChecker(this, 81151, "yggdrasil.update");
        new Metrics(this, 7954);

        if(configManager.mainConfig.getConfig().getBoolean("yggdrasil.show_logo_on_startup")) {
            logger.info(MSG.startupLogo);
        }

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}