package tk.fridtjof.yggdrasil;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;
import tk.fridtjof.yggdrasil.cmds.*;
import tk.fridtjof.yggdrasil.utils.Log;
import tk.fridtjof.yggdrasil.utils.UpdateChecker;

public final class Yggdrasil extends JavaPlugin {

    private static Yggdrasil instance;

    public Yggdrasil() {
        instance = this;
    }

    public static Yggdrasil getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        Config.loadConfig();

        getServer().getPluginManager().registerEvents(new EventManager(), this);
        getCommand("monitor").setExecutor(new MonitorCMD());
        getCommand("head").setExecutor(new HeadCMD());
        getCommand("msg").setExecutor(new MsgCMD());
        getCommand("setspawn").setExecutor(new SetSpawnCMD());
        getCommand("spawn").setExecutor(new SpawnCMD());
        getCommand("yggdrasil").setExecutor(new YggdrasilCMD());
        getCommand("heal").setExecutor(new HealCMD());

        int pluginId = 7954;
        new Metrics(this, pluginId);

        Log.info("Thank you for using:\n" +
                " __   __                      _                        _   _ \n" +
                " \\ \\ / /   __ _    __ _    __| |  _ __    __ _   ___  (_) | |\n" +
                "  \\ V /   / _` |  / _` |  / _` | | '__|  / _` | / __| | | | |\n" +
                "   | |   | (_| | | (_| | | (_| | | |    | (_| | \\__ \\ | | | |\n" +
                "   |_|    \\__, |  \\__, |  \\__,_| |_|     \\__,_| |___/ |_| |_|\n" +
                "          |___/   |___/                                      \n\n" +
                " ~Yggdrasil - Coded with love by @Fridtjof_DE\n");

        UpdateChecker updateChecker = new UpdateChecker(this);
        updateChecker.checkForUpdate();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}