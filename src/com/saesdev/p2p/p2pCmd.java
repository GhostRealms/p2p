package com.saesdev.p2p;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class p2pCmd implements CommandExecutor {
	
	PayToPlace plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			sendInfoMessage(sender);
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("help")) {
				sendHelpMessage(sender);
			} else if(args[0].equalsIgnoreCase("reload")) {
				if(sender.hasPermission("p2p.reload")) {
					plugin.reloadConfig();
				}
			}
		}
		return false;
	}

	private void sendHelpMessage(CommandSender sender) {
		sender.sendMessage(ChatColor.GRAY + "[p2p] " + ChatColor.YELLOW + "Help & Commands!");
		sender.sendMessage(ChatColor.GRAY + "[p2p] " + ChatColor.WHITE + "/p2p reload :: Reload The Configuration");
	}

	private void sendInfoMessage(CommandSender sender) {
		sender.sendMessage(ChatColor.GRAY + "[p2p] " + ChatColor.YELLOW + "PayToPlace - SaesDevelopment");
		sender.sendMessage(ChatColor.GRAY + "[p2p] " + ChatColor.WHITE + "Rmarmorstein, Pluto1099, hkminenub");
		
	}

}
