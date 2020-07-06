package tk.fridtjof.yggdrasil.cmds.cheats;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.fridtjof.puddingapi.bukkit.player.PlayerAPI;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class FlyCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    String p = Theme.getPrimary();
    String s = Theme.getSecondary();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            if(sender instanceof Player) {
                if (sender.hasPermission("yggdrasil.cmd.fly") || sender.isOp()) {
                    Player player = (Player) sender;
                    PlayerAPI.toggleFly(player);
                    player.sendMessage(MSG.toggledFly);
                } else {
                    sender.sendMessage(MSG.noPermission);
                }
            } else {
                sender.sendMessage(MSG.enterPlayer);
            }
        } else if(args.length == 1) {
            if(sender.hasPermission("yggdrasil.cmd.heal.others") || sender.isOp()) {
                Player player = Bukkit.getPlayer(args[0]);
                if(player != null) {
                    PlayerAPI.toggleFly(player);
                    sender.sendMessage(s + MSG.youToggledFly.replaceAll("%player%", p + args[0] + s));
                } else {
                    sender.sendMessage(s + MSG.playerNotFound.replaceAll("%player%", p + args[0]) + s);
                }
            } else {
                sender.sendMessage(MSG.noPermission);
            }
        } else {
            sender.sendMessage(MSG.tooManyArguments);
        }

        return false;
    }
}