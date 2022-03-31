package me.fridtjof.yggdrasil;

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
        loadLobbyConfig();
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

    public void loadLobbyConfig() {
        lobbyConfig = new YamlConfig(plugin.getDataFolder(), "lobby_config");
        lobbyConfig.getConfig().options().header("This is the lobby configuration file - Read the wiki for help!");

        lobbyConfig.getConfig().addDefault("lobby.no_fall_damage", false);
        lobbyConfig.getConfig().addDefault("lobby.no_pvp", false);
        lobbyConfig.getConfig().addDefault("lobby.no_pve", false);
        lobbyConfig.getConfig().addDefault("lobby.no_hunger", false);
        lobbyConfig.getConfig().addDefault("lobby.no_damage", false);
        lobbyConfig.getConfig().addDefault("lobby.no_item_dropping", false);

        lobbyConfig.getConfig().addDefault("lobby.compass.enable", false);
        lobbyConfig.getConfig().addDefault("lobby.compass.name", "§9§lNavigator");
        lobbyConfig.getConfig().addDefault("lobby.compass.slot", 0);
        lobbyConfig.getConfig().addDefault("lobby.compass.slot_1.name", "§cSurvival");
        lobbyConfig.getConfig().addDefault("lobby.compass.slot_3.name", "§bCreative");
        lobbyConfig.getConfig().addDefault("lobby.compass.slot_1.server", "Survival");
        lobbyConfig.getConfig().addDefault("lobby.compass.slot_3.server", "Creative");
        lobbyConfig.getConfig().addDefault("lobby.compass.slot_1.material", "APPLE");
        lobbyConfig.getConfig().addDefault("lobby.compass.slot_3.material", "DIAMOND_BLOCK");

        lobbyConfig.getConfig().addDefault("lobby.head.enable", false);
        lobbyConfig.getConfig().addDefault("lobby.head.name", "§e§lPlayer Profile");
        lobbyConfig.getConfig().addDefault("lobby.head.slot", 8);
        lobbyConfig.getConfig().addDefault("lobby.head.slot_10.name", "§9%player_name%");
        lobbyConfig.getConfig().addDefault("lobby.head.slot_12.name", "§l§eSpielzeit: §a%plan_player_time_total%");
        lobbyConfig.getConfig().addDefault("lobby.head.slot_14.name", "§l§bRegistriert: §a%plan_player_registered%");
        lobbyConfig.getConfig().addDefault("lobby.head.slot_16.name", "§l§cKill/Death-Rate: §a%plan_player_kill_death_ratio%");
        lobbyConfig.getConfig().addDefault("lobby.head.slot_10.material", "PLAYER_HEAD");
        lobbyConfig.getConfig().addDefault("lobby.head.slot_12.material", "CLOCK");
        lobbyConfig.getConfig().addDefault("lobby.head.slot_14.material", "OAK_SAPLING");
        lobbyConfig.getConfig().addDefault("lobby.head.slot_16.material", "IRON_SWORD");

        lobbyConfig.getConfig().addDefault("lobby.egg.enable", false);
        lobbyConfig.getConfig().addDefault("lobby.egg.name", "§d§lEaster Eggs");
        lobbyConfig.getConfig().addDefault("lobby.egg.slot", 4);

        lobbyConfig.getConfig().options().copyDefaults(true);
        lobbyConfig.save();
        logger.info("Successfully (re)loaded lobby_config.yml");
    }

    public void loadMessagesFile() {
        messagesFile = new YamlConfig(plugin.getDataFolder(), "messages");
        messagesFile.getConfig().options().header("This is the localization file.");

        messagesFile.getConfig().addDefault("tablist.header", "&bTablist Header");
        messagesFile.getConfig().addDefault("tablist.footer", "&bTablist Footer");

        messagesFile.getConfig().addDefault("chat.join_msg", "§a%player% joined the server!");
        messagesFile.getConfig().addDefault("chat.quit_msg", "§a%player% left the server!");

        messagesFile.getConfig().addDefault("info.rules", "§lRegeln:§r\n" +
                "0. Fridtjof_DE ist der Boss\n" +
                "1. Fischies ist vogelfrei\n" +
                "2. Keiner hat mehr Tode als Fornox\n" +
                "3. Kein Griefing\n" +
                "4. Kein Klauen\n" +
                "5. Keine Kämpfe ohne Absprache");

        messagesFile.getConfig().addDefault("error.no_permission", "§cYou don't have the permission to do that!");
        messagesFile.getConfig().addDefault("error.too_many_args", "§cToo many arguments!");
        messagesFile.getConfig().addDefault("error.not_enough_args", "§cNot enough arguments!");
        messagesFile.getConfig().addDefault("error.incorrect_args", "§cIncorrect argument!");
        messagesFile.getConfig().addDefault("error.player_only", "§cThis command is player-only!");
        messagesFile.getConfig().addDefault("error.slot_occupied", "§cThis slot is already occupied!");

        messagesFile.getConfig().addDefault("spawn.spawn", "§bYou've been teleported to the spawn!");
        messagesFile.getConfig().addDefault("spawn.set_spawn", "§bThe spawn was set to: ");
        messagesFile.getConfig().addDefault("spawn.spawn_others", "§bYou teleported %target% to the spawn!");

        messagesFile.getConfig().addDefault("enter.player", "§cPlease enter a player!");
        messagesFile.getConfig().addDefault("enter.world", "§cPlease enter a world!");
        messagesFile.getConfig().addDefault("enter.value", "§cPlease enter a value!");
        messagesFile.getConfig().addDefault("enter.gamemode", "§cPlease enter a gamemode!");
        messagesFile.getConfig().addDefault("enter.message", "§cPlease enter a message!");

        messagesFile.getConfig().addDefault("not_found.player", "§cThe player %player% §cwas not found!");
        messagesFile.getConfig().addDefault("not_found.world", "§cThe world %world% §cwas not found!");

        messagesFile.getConfig().addDefault("set.fly_speed", "§bYou've set %player% fly-speed for to %speed%!");
        messagesFile.getConfig().addDefault("set.walk_speed", "§bYou've set %player% walk-speed for to %speed%!");
        messagesFile.getConfig().addDefault("set.time", "§bTime was set to %time% ticks in %world%");

        messagesFile.getConfig().addDefault("toggle.fly-mode", "§bYou've toggled fly-mode!");
        messagesFile.getConfig().addDefault("toggle.fly-mode_others", "§bYou've toggled fly-mode for %player%!");

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