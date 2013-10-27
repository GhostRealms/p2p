package com.saesdev.p2p;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class p2pListener implements Listener {
	
	PayToPlace plugin;
	FileConfiguration config = plugin.getConfig();
	Economy econ = PayToPlace.economy;
	
	@EventHandler (priority = EventPriority.HIGH)
	public void onBlockPlace(BlockPlaceEvent e) {
		if(config.contains("items." + e.getBlock().getTypeId())) {
			int price = config.getInt("items." + e.getBlock().getTypeId() + ".price");
			if(econ.has(e.getPlayer().getName(), price)) {
				econ.withdrawPlayer(e.getPlayer().getName(), price);
				e.getPlayer().sendMessage(ChatColor.GRAY + "[p2p] " + ChatColor.WHITE + "You Were Charged " + ChatColor.GREEN + price  + ChatColor.WHITE + " For placing " + e.getBlock().toString());
			}
		}
	}

}
