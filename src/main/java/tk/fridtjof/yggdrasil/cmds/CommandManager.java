package tk.fridtjof.yggdrasil.cmds;

import org.bukkit.plugin.java.JavaPlugin;
import tk.fridtjof.yggdrasil.cmds.admin.*;
import tk.fridtjof.yggdrasil.cmds.mod.TimeCMD;
import tk.fridtjof.yggdrasil.cmds.user.MsgCMD;
import tk.fridtjof.yggdrasil.cmds.user.SpawnCMD;

public class CommandManager {

    public CommandManager(JavaPlugin plugin) {
        registerCommands(plugin);
    }

    private void registerCommands(JavaPlugin plugin) {

        plugin.getCommand("monitor").setExecutor(new MonitorCMD());

        plugin.getCommand("head").setExecutor(new HeadCMD());

        plugin.getCommand("msg").setExecutor(new MsgCMD());
        plugin.getCommand("tell").setExecutor(new MsgCMD());
        plugin.getCommand("whisper").setExecutor(new MsgCMD());

        plugin.getCommand("setspawn").setExecutor(new SetSpawnCMD());
        plugin.getCommand("spawn").setExecutor(new SpawnCMD());

        plugin.getCommand("yggdrasil").setExecutor(new YggdrasilCMD());

        plugin.getCommand("heal").setExecutor(new HealCMD());

        plugin.getCommand("day").setExecutor(new TimeCMD());
        plugin.getCommand("night").setExecutor(new TimeCMD());
        plugin.getCommand("noon").setExecutor(new TimeCMD());
        plugin.getCommand("midnight").setExecutor(new TimeCMD());

        plugin.getCommand("gm").setExecutor(new GamemodeCMD());
        plugin.getCommand("gamemode").setExecutor(new GamemodeCMD());
    }
}
