package tk.fridtjof.yggdrasil.utils;

import tk.fridtjof.yggdrasil.Yggdrasil;

public class Theme {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public static String getPrimary() {

        String p = plugin.getConfig().getString("theme.primary");
        ColorCodes c = new ColorCodes();
        FormattingCodes f = new FormattingCodes();
        p = c.Format(p);
        p = f.Format(p);

        return  p;
    }

    public static String getSecondary() {

        String s = plugin.getConfig().getString("theme.secondary");
        ColorCodes c = new ColorCodes();
        FormattingCodes f = new FormattingCodes();
        s = c.Format(s);
        s = f.Format(s);

        return  s;
    }
}