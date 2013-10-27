package com.saesdev.p2p;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class p2pCmd implements CommandExecutor {
	
	PayToPlace plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			sendInfoMessage();
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("help")) {
				sendHelpMessage();
			} else if(args[0].equalsIgnoreCase("reload")) {
				plugin.reloadConfig();
			}
		}
		return false;
	}

}
