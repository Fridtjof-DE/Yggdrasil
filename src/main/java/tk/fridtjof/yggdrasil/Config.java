package tk.fridtjof.yggdrasil;

import tk.fridtjof.puddingapi.bukkit.utils.Logger;

public class Config {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    private static Logger logger = plugin.logger;

    public static void loadConfig() {

        plugin.reloadConfig();
        plugin.getConfig().options().header("This is the main configuration file - Read the wiki for help!");

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

        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        logger.info("Successfully (re)loaded config.yml");
    }
}