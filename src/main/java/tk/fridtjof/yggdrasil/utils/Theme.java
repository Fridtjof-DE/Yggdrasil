package tk.fridtjof.yggdrasil.utils;

import org.bukkit.ChatColor;
import tk.fridtjof.yggdrasil.Yggdrasil;

public class Theme {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public static String getPrimary() {

        String p = plugin.getConfig().getString("theme.primary");
        p = ChatColor.translateAlternateColorCodes('&', p);
        return  p;
    }

    public static String getSecondary() {

        String s = plugin.getConfig().getString("theme.secondary");
        s = ChatColor.translateAlternateColorCodes('&', s);
        return  s;
    }
}