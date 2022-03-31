package me.fridtjof.yggdrasil.utils;

import me.fridtjof.puddingapi.bukkit.utils.Logger;
import me.fridtjof.yggdrasil.Yggdrasil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CheckPuddingAPIVersion {

    private Logger logger;

    public CheckPuddingAPIVersion(JavaPlugin plugin) {
        logger = new Logger(plugin);

        String version = Bukkit.getPluginManager().getPlugin("PuddingAPI").getDescription().getVersion();
        version = version.replaceAll("-SNAPSHOT", "");
        version = version.replaceAll("\\.", "");
        int versionInt = Integer.parseInt(version);
        if (versionInt < 200) {
            logger.info("§4The server is using an outdated version of the PuddingAPI!");
            //try {
                Bukkit.getPluginManager().disablePlugin(plugin);
            //} catch (IllegalStateException exception) {

            //}
        }
    }
}
