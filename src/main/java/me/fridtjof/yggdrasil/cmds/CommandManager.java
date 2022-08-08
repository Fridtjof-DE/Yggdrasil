package me.fridtjof.yggdrasil.cmds;

import me.fridtjof.yggdrasil.cmds.admin.*;
import me.fridtjof.yggdrasil.cmds.mod.TimeCMD;
import org.bukkit.plugin.java.JavaPlugin;
import me.fridtjof.yggdrasil.cmds.cheats.FlyCmd;
import me.fridtjof.yggdrasil.cmds.cheats.HeadCmd;
import me.fridtjof.yggdrasil.cmds.cheats.HealCmd;
import me.fridtjof.yggdrasil.cmds.cheats.SpeedCmd;
import me.fridtjof.yggdrasil.cmds.user.MsgCMD;
import me.fridtjof.yggdrasil.cmds.user.RulesCMD;
import me.fridtjof.yggdrasil.cmds.user.SpawnCMD;

public class CommandManager {

    public CommandManager(JavaPlugin plugin) {
        registerCommands(plugin);
    }

    private void registerCommands(JavaPlugin plugin) {

        //ADMIN
        plugin.getCommand("setspawn").setExecutor(new SetSpawnCmd());
        plugin.getCommand("yggdrasil").setExecutor(new YggdrasilCmd());
        plugin.getCommand("gm").setExecutor(new GameModeCmd());
        plugin.getCommand("gamemode").setExecutor(new GameModeCmd());

        //MOD
        plugin.getCommand("day").setExecutor(new TimeCMD());
        plugin.getCommand("night").setExecutor(new TimeCMD());
        plugin.getCommand("noon").setExecutor(new TimeCMD());
        plugin.getCommand("midnight").setExecutor(new TimeCMD());

        //PLAYER
        plugin.getCommand("msg").setExecutor(new MsgCMD());
        plugin.getCommand("tell").setExecutor(new MsgCMD());
        plugin.getCommand("whisper").setExecutor(new MsgCMD());
        plugin.getCommand("spawn").setExecutor(new SpawnCMD());
        plugin.getCommand("rules").setExecutor(new RulesCMD());

        //CHEATS
        plugin.getCommand("head").setExecutor(new HeadCmd());
        plugin.getCommand("heal").setExecutor(new HealCmd());
        plugin.getCommand("fly").setExecutor(new FlyCmd());
        plugin.getCommand("speed").setExecutor(new SpeedCmd());
    }
}
