package tk.fridtjof.yggdrasil;

import org.bukkit.plugin.java.JavaPlugin;
import tk.fridtjof.puddingapi.bukkit.utils.Logger;

public class ConfigManager {

    JavaPlugin plugin;

    private Logger logger;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        logger = new Logger(plugin);
        loadConfig();
    }

    public void loadConfig() {

        plugin.reloadConfig();
        plugin.getConfig().options().header("This is the main configuration file - Read the wiki for help!");

        plugin.getConfig().addDefault("tablist.header", "&bTablist Header");
        plugin.getConfig().addDefault("tablist.footer", "&bTablist Footer");

        plugin.getConfig().addDefault("theme.primary", "&b");
        plugin.getConfig().addDefault("theme.secondary", "&f");

        plugin.getConfig().addDefault("spawn.auto_tp.enable", true);
        plugin.getConfig().addDefault("spawn.auto_tp.y", -10);

        plugin.getConfig().addDefault("spawn.x", -1);
        plugin.getConfig().addDefault("spawn.y", -1);
        plugin.getConfig().addDefault("spawn.z", -1);
        plugin.getConfig().addDefault("spawn.tp_on_respawn", false);
        plugin.getConfig().addDefault("spawn.tp_on_join", false);

        plugin.getConfig().addDefault("chat.custom_join_quit_msg", true);
        plugin.getConfig().addDefault("chat.join_msg", "§a%player% joined the server!");
        plugin.getConfig().addDefault("chat.quit_msg", "§a%player% left the server!");

        plugin.getConfig().addDefault("cmds.heal.feed_on_heal", true);

        plugin.getConfig().addDefault("info.rules", "§lRegeln:§r\n" +
                "0. Fridtjof_DE ist der Boss\n" +
                "1. Fischies ist vogelfrei\n" +
                "2. Keiner hat mehr Tode als Fornox\n" +
                "3. Kein Griefing\n" +
                "4. Kein Klauen\n" +
                "5. Keine Kämpfe ohne Absprache");

        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        logger.info("Successfully (re)loaded config.yml");
    }
}