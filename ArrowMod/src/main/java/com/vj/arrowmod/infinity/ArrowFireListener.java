package com.vj.arrowmod.infinity;


import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class ArrowFireListener implements Listener {
	
    @EventHandler
    public void onShootBow(EntityShootBowEvent event)
    {
    	//If the bow this is shot from has infinity, do not consume the item
    	//getBow() gets us the bow firing and setConsumeItem(bool) sets to take item or not. so does shouldConsumeItem() hmmm
    	
    	ItemStack firingBow = event.getBow();
    	Iterator iter = firingBow.getEnchantments().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            //Bukkit.broadcastMessage("Welcome to the server!");
            Bukkit.getLogger().info(pair.getKey() + " = " + pair.getValue());
            if(pair.getKey().toString().contains("ARROW_INFINITE")) {
            	//Bukkit.broadcastMessage("Infinity Bow is Fired!");
            	event.setConsumeItem(false);
            	Player shootingPlayer = (Player)event.getEntity();
            	shootingPlayer.updateInventory();
            	//Bukkit.broadcastMessage("Should consume -> "+event.shouldConsumeItem());
            }


            //iter.remove(); // avoids a ConcurrentModificationException
        }

    	
    }
}
