package tk.fridtjof.yggdrasil;

import org.bukkit.plugin.java.JavaPlugin;
import tk.fridtjof.puddingapi.bukkit.utils.Logger;
import tk.fridtjof.puddingapi.bukkit.utils.Metrics;
import tk.fridtjof.puddingapi.bukkit.utils.UpdateChecker;
import tk.fridtjof.yggdrasil.cmds.CommandManager;
import tk.fridtjof.yggdrasil.events.EventManager;

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

    public ConfigManager configManager;

    @Override
    public void onEnable() {

        configManager = new ConfigManager(this);
        new EventManager(this);
        new CommandManager(this);
        new UpdateChecker(this, 81151, "yggdrasil.update");
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