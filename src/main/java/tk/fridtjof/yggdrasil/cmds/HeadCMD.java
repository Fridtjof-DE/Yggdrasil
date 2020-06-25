package tk.fridtjof.yggdrasil.cmds;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;
import tk.fridtjof.yggdrasil.Yggdrasil;
import tk.fridtjof.yggdrasil.utils.Theme;

public class HeadCMD implements CommandExecutor {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String p = Theme.getPrimary();
        String s = Theme.getSecondary();

        if(sender.hasPermission("yggdrasil.head") || sender.isOp()) {

            Player player = (Player) sender;
            PlayerInventory inv = player.getInventory();

            if(args.length == 0) {
                sender.sendMessage(s + "Here's " + p + "your" + s + " head!");
                inv.addItem(getPlayerHead(sender.getName()));
            } else if(args.length == 1) {
                sender.sendMessage(s + "Here's the head of " + p + args[0] + s + "!");
                inv.addItem(getPlayerHead(args[0]));
            } else if (args.length == 2) {
                Player player2 = Bukkit.getPlayer(args[1]);
                if(player2 != null) {
                    PlayerInventory inv2 = player2.getInventory();
                    sender.sendMessage(s + "Gave " + p + args[1] + s + " the head of " + p + args[0] + s + "!");
                    inv2.addItem(getPlayerHead(args[0]));
                } else {
                    sender.sendMessage("§cThe player " + p + args[1] + "§c is not online!");
                }
            } else {
                sender.sendMessage("§cToo many args!");
            }
        } else {
            sender.sendMessage("§cYou don't have the permission to do that!");
        }

        return false;
    }

    private ItemStack getPlayerHead(String playerName) {
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        //meta.setDisplayName("Test");
        meta.setOwner(playerName);
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}