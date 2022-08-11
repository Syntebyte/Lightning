package com.syntebyte.lightning;

import com.syntebyte.lightning.objects.LightningBolt;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class Debug implements Listener {

    private static boolean registered = false;
    private final Lightning lightning;

    /*
        Plugin debug class
    */

    public Debug() {

        lightning = Lightning.getPlugin(Lightning.class);
        if(lightning.isDebugEnabled() && !registered) {
            Bukkit.getPluginManager().registerEvents(this, lightning);
            lightning.getLogger().info("Debug class loaded.");
            registered = true;
        }
    }

    public boolean isDebugEnabled() {
        return lightning.isDebugEnabled();
    }

    @EventHandler
    public void onStickTapLightningTest(PlayerInteractEvent e) {

        String debugID = "stick-tap-lightning";
        String debugPermission = "debug-" + debugID;

        if(!e.getPlayer().hasPermission(debugPermission)) {
            return;
        }

        if(e.getClickedBlock() == null) {
            return;
        }

        if(!e.getHand().equals(EquipmentSlot.HAND)) {
            return;
        }

        ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
        if(item == null) {
            return;
        }

        if(!item.getItemMeta().getDisplayName().equals(debugID)) {
            return;
        }

        e.setCancelled(true);
        LightningBolt lightningBolt = new LightningBolt(e.getClickedBlock().getLocation());
        lightningBolt.invoke();
    }
}
