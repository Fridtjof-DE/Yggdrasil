package tk.fridtjof.yggdrasil.cmds;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class GamemodeCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                setGamemodes(player, args, player, false);
            } else {
                sender.sendMessage(MSG.enterPlayer);
            }
        } else if (args.length == 2) {
            Player player = Bukkit.getPlayer(args[1]);

            if (player == null) {
                sender.sendMessage(MSG.playerNotFound.replaceAll("%player%", p + args[1]));
            } else {
                setGamemodes(sender, args, player, true);
            }
        } else if(args.length == 0) {
            sender.sendMessage(MSG.enterGameMode);
        } else {
            sender.sendMessage(MSG.tooManyArgs);
        }

        return false;
    }

    private void setGamemodes(CommandSender sender, String[] args, Player player, Boolean others) {
        String s = "";

        if(others == true) {
            s = ".others";
        }

        if (args[0].equals("0")) {
            if(sender.hasPermission("yggdrasil.gm.0" + s)) {
                player.setGameMode(GameMode.SURVIVAL);
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else if (args[0].equals("1")) {
            if(sender.hasPermission("yggdrasil.gm.1" + s)) {
                player.setGameMode(GameMode.CREATIVE);
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else if (args[0].equals("2")) {
            if(sender.hasPermission("yggdrasil.gm.2" + s)) {
                player.setGameMode(GameMode.ADVENTURE);
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else if (args[0].equals("3")) {
            if(sender.hasPermission("yggdrasil.gm.3" + s)) {
                player.setGameMode(GameMode.SPECTATOR);
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        }
    }
}