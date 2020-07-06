package tk.fridtjof.yggdrasil.cmds.cheats;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import tk.fridtjof.puddingapi.bukkit.items.PlayerHead;
import tk.fridtjof.yggdrasil.MSG;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class HeadCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String p = Theme.getPrimary();
        String s = Theme.getSecondary();

        if(sender.hasPermission("yggdrasil.cmd.head") || sender.isOp()) {

            if(args.length == 0) {
                if(sender instanceof Player) {

                    Player player = (Player) sender;
                    addHeadToInv(player, player.getName());
                    sender.sendMessage(s + MSG.heresYourHead);
                } else {
                    sender.sendMessage(MSG.enterPlayer);
                }
            } else if(args.length == 1) {

                Player player = (Player) sender;
                addHeadToInv(player, args[0]);
                sender.sendMessage(s + MSG.heresHeadOf.replaceAll("%player%", p + args[0] + s));

            } else if (args.length == 2) {
                Player player = Bukkit.getPlayer(args[1]);
                if(player != null) {
                    addHeadToInv(player, args[0]);
                    sender.sendMessage(s + MSG.gaveHead.replaceAll("%target%", p + args[1] + s).replaceAll("%head%", p + args[0] + s));
                } else {
                    sender.sendMessage(s + MSG.playerNotFound.replaceAll("%player%", p + args[1]) + s);
                }
            } else {
                sender.sendMessage(MSG.tooManyArguments);
            }
        } else {
            sender.sendMessage(MSG.noPermission);
        }

        return false;
    }

    private void addHeadToInv(Player player, String skullName) {
        PlayerInventory inv = player.getInventory();
        inv.addItem(PlayerHead.getSkullFromOwner(skullName));
    }
}