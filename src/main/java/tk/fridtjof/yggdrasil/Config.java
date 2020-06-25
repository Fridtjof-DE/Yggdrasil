package tk.fridtjof.yggdrasil;

import tk.fridtjof.yggdrasil.utils.Log;

public class Config {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public static void prepareConfig() {

        plugin.reloadConfig();
        plugin.getConfig().options().header("This is the main configuration file - Read the wiki for help!");

        plugin.getConfig().addDefault("theme.primary", "&b");
        plugin.getConfig().addDefault("theme.secondary", "&f");

        plugin.getConfig().addDefault("modules.sign_formatting", true);

        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        Log.info("Successfully (re)loaded config.yml");
    }
}