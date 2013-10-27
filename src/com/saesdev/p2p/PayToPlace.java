package com.saesdev.p2p;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class PayToPlace extends JavaPlugin {
	
	public static Economy economy = null;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		setupEconomy();
		getServer().getPluginManager().registerEvents(new p2pListener(), this);
	}
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if(economyProvider != null) {
			economy = economyProvider.getProvider();
		}
		
		return (economy != null);
	}

	@Override
	public void onDisable() {
		
	}
}
