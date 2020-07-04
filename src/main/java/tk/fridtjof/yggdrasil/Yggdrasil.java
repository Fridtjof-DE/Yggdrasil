package tk.fridtjof.yggdrasil;

import org.bukkit.plugin.java.JavaPlugin;
import tk.fridtjof.puddingapi.bukkit.utils.Logger;
import tk.fridtjof.puddingapi.bukkit.utils.Metrics;
import tk.fridtjof.puddingapi.bukkit.utils.UpdateChecker;
import tk.fridtjof.yggdrasil.cmds.*;
import tk.fridtjof.yggdrasil.cmds.cheats.GamemodeCMD;
import tk.fridtjof.yggdrasil.cmds.cheats.HeadCMD;
import tk.fridtjof.yggdrasil.cmds.cheats.HealCMD;
import tk.fridtjof.yggdrasil.cmds.time.DayCMD;
import tk.fridtjof.yggdrasil.cmds.time.MidNightCMD;
import tk.fridtjof.yggdrasil.cmds.time.NightCMD;
import tk.fridtjof.yggdrasil.cmds.time.NoonCMD;

public final class Yggdrasil extends JavaPlugin {

    //TODO etc /fly /speed

    private static Yggdrasil instance;

    public Yggdrasil() {
        instance = this;
    }

    public static Yggdrasil getInstance() {
        return instance;
    }

    Logger logger = new Logger(this);

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new EventManager(), this);
        getCommand("monitor").setExecutor(new MonitorCMD());
        getCommand("head").setExecutor(new HeadCMD());
        getCommand("msg").setExecutor(new MsgCMD());
        getCommand("setspawn").setExecutor(new SetSpawnCMD());
        getCommand("spawn").setExecutor(new SpawnCMD());
        getCommand("yggdrasil").setExecutor(new YggdrasilCMD());
        getCommand("heal").setExecutor(new HealCMD());
        getCommand("gm").setExecutor(new GamemodeCMD());
        getCommand("day").setExecutor(new DayCMD());
        getCommand("night").setExecutor(new NightCMD());
        getCommand("noon").setExecutor(new NoonCMD());
        getCommand("midnight").setExecutor(new MidNightCMD());

        new UpdateChecker(this, 12253, "yggdrasil.update");
        new Metrics(this, 7954);

        logger.info("Thank you for using:\n" +
                " __   __                      _                        _   _ \n" +
                " \\ \\ / /   __ _    __ _    __| |  _ __    __ _   ___  (_) | |\n" +
                "  \\ V /   / _` |  / _` |  / _` | | '__|  / _` | / __| | | | |\n" +
                "   | |   | (_| | | (_| | | (_| | | |    | (_| | \\__ \\ | | | |\n" +
                "   |_|    \\__, |  \\__, |  \\__,_| |_|     \\__,_| |___/ |_| |_|\n" +
                "          |___/   |___/                                      \n\n" +
                " ~Yggdrasil - Coded with love by @Fridtjof_DE\n");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}