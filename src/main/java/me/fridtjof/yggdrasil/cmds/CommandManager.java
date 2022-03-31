package me.fridtjof.yggdrasil.cmds;

import me.fridtjof.puddingapi.bukkit.utils.TabCompleter;
import me.fridtjof.yggdrasil.cmds.admin.*;
import me.fridtjof.yggdrasil.cmds.mod.TimeCMD;
import org.bukkit.plugin.java.JavaPlugin;
import me.fridtjof.yggdrasil.cmds.cheats.FlyCMD;
import me.fridtjof.yggdrasil.cmds.cheats.HeadCMD;
import me.fridtjof.yggdrasil.cmds.cheats.HealCMD;
import me.fridtjof.yggdrasil.cmds.cheats.SpeedCMD;
import me.fridtjof.yggdrasil.cmds.user.MsgCMD;
import me.fridtjof.yggdrasil.cmds.user.RulesCMD;
import me.fridtjof.yggdrasil.cmds.user.SpawnCMD;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {

    public CommandManager(JavaPlugin plugin) {
        registerCommands(plugin);
    }

    private void registerCommands(JavaPlugin plugin) {

        //ADMIN
        plugin.getCommand("monitor").setExecutor(new MonitorCMD());
        plugin.getCommand("setspawn").setExecutor(new SetSpawnCMD());
        plugin.getCommand("yggdrasil").setExecutor(new YggdrasilCMD());
        plugin.getCommand("gm").setExecutor(new GamemodeCMD());
        plugin.getCommand("gamemode").setExecutor(new GamemodeCMD());
        plugin.getCommand("easteregg").setExecutor(new EasterEggCMD());

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
        plugin.getCommand("head").setExecutor(new HeadCMD());
        plugin.getCommand("heal").setExecutor(new HealCMD());
        plugin.getCommand("fly").setExecutor(new FlyCMD());
        plugin.getCommand("speed").setExecutor(new SpeedCMD());
    }
}
