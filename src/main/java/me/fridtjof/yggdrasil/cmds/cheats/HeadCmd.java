package me.fridtjof.yggdrasil.cmds.cheats;

import me.fridtjof.yggdrasil.MSG;
import me.fridtjof.yggdrasil.Yggdrasil;
import me.fridtjof.yggdrasil.cmds.admin.GameModeTab;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import me.fridtjof.puddingapi.bukkit.items.PlayerHead;

public class HeadCmd implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    public HeadCmd() {
        plugin.getCommand("head").setTabCompleter(new HeadTab());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length >= 3) {
            sender.sendMessage(MSG.tooManyArguments);
            return false;
        }

        Player senderPlayer = (Player) sender;

        if(sender.hasPermission("yggdrasil.cmd.head") || sender.isOp()) {

            if(args.length == 0) {
                if (sender instanceof Player) {
                    addHeadToInv(senderPlayer, senderPlayer.getName());
                    sender.sendMessage(MSG.heresYourHead);
                } else {
                    sender.sendMessage(MSG.enterPlayer);
                }
            }

        }
        if(sender.hasPermission("yggdrasil.cmd.head.others") || sender.isOp()) {
            if (args.length == 1) {
                addHeadToInv(senderPlayer, args[0]);
                sender.sendMessage(MSG.heresHeadOf.replaceAll("%player%", args[0]));

            }

        }
        if(sender.hasPermission("yggdrasil.cmd.head.give_others") || sender.isOp()) {
            if (args.length == 2) {
                Player targetPlayer = Bukkit.getPlayer(args[1]);
                if(targetPlayer != null) {
                    addHeadToInv(targetPlayer, args[0]);
                    sender.sendMessage(MSG.gaveHead.replaceAll("%target%",args[1]).replaceAll("%head%", args[0]));
                } else {
                    MSG.playerNotFound.replaceAll("%player%", args[1]);
                }
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