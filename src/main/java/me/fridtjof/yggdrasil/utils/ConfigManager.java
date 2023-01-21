package me.fridtjof.yggdrasil.utils;

import org.bukkit.plugin.java.JavaPlugin;
import me.fridtjof.puddingapi.bukkit.utils.Logger;
import me.fridtjof.puddingapi.bukkit.utils.YamlConfig;

public class ConfigManager {

    JavaPlugin plugin;

    private Logger logger;
    public YamlConfig mainConfig, lobbyConfig, dataFile, messagesFile;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        logger = new Logger(plugin);
        reloadConfigs();
    }

    public void reloadConfigs() {
        loadMainConfig();
        loadDataFile();
        loadMessagesFile();
    }

    public void loadDataFile() {
        dataFile = new YamlConfig(plugin.getDataFolder(), "data");
        dataFile.getConfig().options().header("This is the data file - Don't touch!");

        mainConfig.getConfig().addDefault("spawn.x", -1);
        mainConfig.getConfig().addDefault("spawn.y", -1);
        mainConfig.getConfig().addDefault("spawn.z", -1);

        dataFile.getConfig().options().copyDefaults(true);
        dataFile.save();
        logger.info("Successfully (re)loaded data.yml");
    }

    public void loadMainConfig() {
        mainConfig = new YamlConfig(plugin.getDataFolder(), "config");
        mainConfig.getConfig().options().header("This is the main configuration file - Read the wiki for help!");

        mainConfig.getConfig().addDefault("spawn.auto_tp.enable", true);
        mainConfig.getConfig().addDefault("spawn.auto_tp.y", -70);

        mainConfig.getConfig().addDefault("spawn.tp_on_respawn", false);
        mainConfig.getConfig().addDefault("spawn.tp_on_join", false);

        mainConfig.getConfig().addDefault("chat.custom_join_quit_msg", true);

        mainConfig.getConfig().addDefault("cmds.heal.feed_on_heal", true);

        mainConfig.getConfig().addDefault("yggdrasil.show_logo_on_startup", true);

        mainConfig.getConfig().options().copyDefaults(true);
        mainConfig.save();
        logger.info("Successfully (re)loaded config.yml");
    }

    public void loadMessagesFile() {
        messagesFile = new YamlConfig(plugin.getDataFolder(), "messages");
        messagesFile.getConfig().options().header("This is the localization file.");

        messagesFile.getConfig().addDefault("tablist.header", "&bTablist Header");
        messagesFile.getConfig().addDefault("tablist.footer", "&bTablist Footer");

        messagesFile.getConfig().addDefault("chat.join_msg", "§a%player_displayname% joined the server!");
        messagesFile.getConfig().addDefault("chat.quit_msg", "§a%player_displayname% left the server!");
        messagesFile.getConfig().addDefault("chat.msg_format", "§b%player_displayname%§7: §f");

        messagesFile.getConfig().addDefault("info.rules", "§lRules:§r\n" +
                "0. Rule\n" +
                "1. Ruleeeeee\n" +
                "2. Rulesssss\n");

        messagesFile.getConfig().addDefault("error.no_permission", "§cMissing permission!");
        messagesFile.getConfig().addDefault("error.too_many_args", "§cToo many arguments!");
        messagesFile.getConfig().addDefault("error.not_enough_args", "§cNot enough arguments!");
        messagesFile.getConfig().addDefault("error.incorrect_args", "§cIncorrect argument!");
        messagesFile.getConfig().addDefault("error.player_only", "§cThis command is player-only!");

        messagesFile.getConfig().addDefault("spawn.spawn", "§bYou've been teleported to the spawn!");
        messagesFile.getConfig().addDefault("spawn.set_spawn", "§bThe spawn was set to: §f");
        messagesFile.getConfig().addDefault("spawn.spawn_others", "§bYou teleported §f%target%§b to the spawn!");

        messagesFile.getConfig().addDefault("enter.player", "§cPlease enter a player!");
        messagesFile.getConfig().addDefault("enter.world", "§cPlease enter a world!");
        messagesFile.getConfig().addDefault("enter.value", "§cPlease enter a value!");
        messagesFile.getConfig().addDefault("enter.gamemode", "§cPlease enter a gamemode!");
        messagesFile.getConfig().addDefault("enter.message", "§cPlease enter a message!");

        messagesFile.getConfig().addDefault("not_found.player", "§cThe player §f%player%§c was not found!");
        messagesFile.getConfig().addDefault("not_found.world", "§cThe world §f%world%§c was not found!");

        messagesFile.getConfig().addDefault("set.fly_speed", "§bThe fly-speed of §f%player%§b was set to %speed%!");
        messagesFile.getConfig().addDefault("set.walk_speed", "§bThe walk-speed of §f%player%§b was set to %speed%!");
        messagesFile.getConfig().addDefault("set.time", "§bThe time was set to §f%time%§b ticks in world §f%world%!§b");
        messagesFile.getConfig().addDefault("set.gamemode", "§bYour gamemode has been set to §f%ygg_gamemode%§b!");
        messagesFile.getConfig().addDefault("set.gamemode_others", "§bThe gamemode of §f%player_displayname%§b has been set to §f%ygg_gamemode%§b!");

        messagesFile.getConfig().addDefault("toggle.fly-mode", "§bToggled fly-mode!");
        messagesFile.getConfig().addDefault("toggle.fly-mode_others", "§bToggled the fly-mode of §f%player_displayname%§f!");

        messagesFile.getConfig().addDefault("heal.heal", "§bYou've been healed!");
        messagesFile.getConfig().addDefault("heal.heal_others", "§bYou healed %player%!");

        messagesFile.getConfig().addDefault("give.head", "§bHere's your head!");
        messagesFile.getConfig().addDefault("give.head_others", "§bHere's the head of %player%!");
        messagesFile.getConfig().addDefault("give.player_head", "§bGave %target% the head of %head%!");

        messagesFile.getConfig().options().copyDefaults(true);
        messagesFile.save();
        logger.info("Successfully (re)loaded messages.yml");
    }
}