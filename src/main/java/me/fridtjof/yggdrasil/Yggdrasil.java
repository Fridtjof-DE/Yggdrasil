package me.fridtjof.yggdrasil;

import me.fridtjof.puddingapi.bukkit.utils.*;
import me.fridtjof.yggdrasil.cmds.CommandManager;
import me.fridtjof.yggdrasil.events.EventManager;
import me.fridtjof.yggdrasil.utils.ConfigManager;
import me.fridtjof.yggdrasil.utils.MSG;
import org.bukkit.plugin.java.JavaPlugin;

public final class Yggdrasil extends JavaPlugin {

    //TODO etc /fly /speed //msg
    //TODO Blitz wo man hinschaut
    //TODO TP in andere world
    //TODO others Rechte verbessern
    //TODO sun head

    private static Yggdrasil instance;

    public Yggdrasil() {
        instance = this;
    }

    public static Yggdrasil getInstance() {
        return instance;
    }

    Logger logger = new Logger(this);

    public ConfigManager configManager;

    private final DependencyChecker dependencyChecker = new DependencyChecker(this, logger);

    @Override
    public void onEnable() {

        new PuddingAPIVersionChecker(this, logger, 9999L);
        dependencyChecker.checkForDependency("PlaceholderAPI", true);

        configManager = new ConfigManager(this);
        new EventManager(this);
        new CommandManager(this);
        //TODO setup SpigotMC page for ID
        new UpdateChecker(this, 81151, "yggdrasil.update");
        new Metrics(this, 7954);

        if(configManager.mainConfig.getConfig().getBoolean("yggdrasil.show_logo_on_startup")) {
            logger.info(MSG.startupLogo);
        }

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}