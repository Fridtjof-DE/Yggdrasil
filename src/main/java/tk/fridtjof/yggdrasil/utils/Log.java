package tk.fridtjof.yggdrasil.utils;

import org.bukkit.Bukkit;
import tk.fridtjof.yggdrasil.Yggdrasil;

import java.util.logging.Logger;

public class Log {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public static Logger log = Bukkit.getLogger();

    public static void info(String msg) {
        log.info("[" + plugin.getName() + "] " + msg);
    }

    public static void warning(String msg) {
        log.warning("[Yggdrasil] " + msg);
    }
}