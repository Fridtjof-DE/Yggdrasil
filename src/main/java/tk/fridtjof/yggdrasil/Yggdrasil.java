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

        if(configManager.mainConfig.getConfig().getBoolean("yggdrasil.show_logo_on_startup")) {
            logger.info(MSG.startupLogo);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}