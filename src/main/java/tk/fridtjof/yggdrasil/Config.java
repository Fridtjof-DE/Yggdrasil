package tk.fridtjof.yggdrasil;

import tk.fridtjof.yggdrasil.utils.Log;

public class Config {

    static Yggdrasil plugin = Yggdrasil.getInstance();

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


        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        Log.info("Successfully (re)loaded config.yml");
    }
}