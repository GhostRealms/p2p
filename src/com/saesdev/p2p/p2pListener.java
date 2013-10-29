package com.saesdev.p2p;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
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
		if(shouldCharge(e.getPlayer())) {
			if(hasTax(e.getBlock())) {
				Player p = e.getPlayer();
				p.sendMessage(ChatColor.GRAY + "[p2p] " + ChatColor.WHITE + "You have been Charged a Tax of " + ChatColor.GREEN + getTax(e.getBlock()));
			}
		}
	}
	
	public boolean shouldCharge(Player p) {
		if(p.hasPermission("p2p.exempt")) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean hasTax(Block b) {
		@SuppressWarnings("deprecation")
		int id = b.getTypeId();
		String s = Integer.toString(id);
		if(config.contains(s)) {
			return true;
		} else {
			return false;
		}
	}
	
	public double getTax(Block b) {
		@SuppressWarnings("deprecation")
		String id = Integer.toString(b.getTypeId());
		int tax = config.getInt(Integer.toString(config.getInt(id)));
		return tax;
	}

}
