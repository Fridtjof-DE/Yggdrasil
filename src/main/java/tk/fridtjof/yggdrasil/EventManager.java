package tk.fridtjof.yggdrasil;

import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tk.fridtjof.yggdrasil.cmds.SpawnCMD;
import tk.fridtjof.yggdrasil.utils.ColorCodes;
import tk.fridtjof.yggdrasil.utils.FormattingCodes;
import tk.fridtjof.yggdrasil.utils.Log;

public class EventManager implements Listener {

    static Yggdrasil plugin = Yggdrasil.getInstance();

    ColorCodes c = new ColorCodes();
    FormattingCodes f = new FormattingCodes();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(plugin.getConfig().getBoolean("spawn.auto_tp.enable")) {
            Player player = event.getPlayer();
            if (player.getLocation().getY() <= plugin.getConfig().getDouble("spawn.auto_tp.y")) {
                SpawnCMD.sendToSpawn(player);
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(plugin.getConfig().getBoolean("spawn.tp_on_join")) {
            SpawnCMD.sendToSpawn(player);
        }

        if(plugin.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            String joinMSG = plugin.getConfig().getString("chat.join_msg");
            event.setJoinMessage(joinMSG.replaceAll("%player%", player.getDisplayName()));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if(plugin.getConfig().getBoolean("chat.custom_join_quit_msg")) {
            String quitMSG = plugin.getConfig().getString("chat.quit_msg");
            event.setQuitMessage(quitMSG.replaceAll("%player%", player.getDisplayName()));
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if(player.hasPermission("yggdrasil.chat.color_codes") || player.isOp()) {
            event.setMessage(c.Format(event.getMessage()));
        }

        if(player.hasPermission("yggdrasil.chat.formatting_codes") || player.isOp()) {
            event.setMessage(f.Format(event.getMessage()));
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {

        if(!event.isCancelled()) {
            HumanEntity entity = event.getWhoClicked();
            if(entity instanceof Player){
                Player player = (Player)entity;
                Inventory inv = event.getInventory();

                if(inv instanceof AnvilInventory) {
                    InventoryView view = event.getView();
                    int rawSlot = event.getRawSlot();

                    if(rawSlot == view.convertSlot(rawSlot)) {
                        if(rawSlot == 2) {
                            ItemStack itemStack = event.getCurrentItem();

                            if(itemStack != null) {
                                ItemMeta meta = itemStack.getItemMeta();
                                meta.setDisplayName(c.Format(meta.getDisplayName()));
                                itemStack.setItemMeta(meta);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if(plugin.getConfig().getBoolean("spawn.tp_on_respawn")) {
            Player player = event.getPlayer();

            double posX = plugin.getConfig().getDouble("spawn.x");
            double posY = plugin.getConfig().getDouble("spawn.y");
            double posZ = plugin.getConfig().getDouble("spawn.z");
            Location loc = new Location(player.getWorld(), posX, posY, posZ);
            event.setRespawnLocation(loc);

            //SpawnCMD.sendToSpawn(player);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWrite(SignChangeEvent e) {
        if (!e.getPlayer().hasPermission("yggdrasil.signs.color_codes") || e.getPlayer().isOp()) {

            e.setLine(0, c.Format(e.getLine(0)));
            e.setLine(1, c.Format(e.getLine(1)));
            e.setLine(2, c.Format(e.getLine(2)));
            e.setLine(3, c.Format(e.getLine(3)));
        }

        if (!e.getPlayer().hasPermission("yggdrasil.signs.formatting_codes") || e.getPlayer().isOp()) {

            e.setLine(0, f.Format(e.getLine(0)));
            e.setLine(1, f.Format(e.getLine(1)));
            e.setLine(2, f.Format(e.getLine(2)));
            e.setLine(3, f.Format(e.getLine(3)));
        }
    }
}