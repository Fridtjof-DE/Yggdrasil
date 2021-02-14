package tk.fridtjof.yggdrasil;

import org.bukkit.plugin.java.JavaPlugin;
import tk.fridtjof.puddingapi.bukkit.utils.Logger;
import tk.fridtjof.puddingapi.bukkit.utils.YamlConfig;

public class ConfigManager {

    JavaPlugin plugin;

    private Logger logger;
    public YamlConfig mainConfig, dataFile, messagesFile;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        logger = new Logger(plugin);
        loadMainConfig();
        loadDataFile();
        loadMessagesFile();
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

        messagesFile.getConfig().options().copyDefaults(true);
        messagesFile.save();
        logger.info("Successfully (re)loaded messages.yml");
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
        mainConfig.getConfig().addDefault("spawn.auto_tp.y", -10);

        mainConfig.getConfig().addDefault("spawn.tp_on_respawn", false);
        mainConfig.getConfig().addDefault("spawn.tp_on_join", false);

        mainConfig.getConfig().addDefault("chat.custom_join_quit_msg", true);

        mainConfig.getConfig().addDefault("cmds.heal.feed_on_heal", true);

        mainConfig.getConfig().options().copyDefaults(true);
        mainConfig.save();
        logger.info("Successfully (re)loaded config.yml");
    }
}