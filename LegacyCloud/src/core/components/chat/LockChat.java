package core.components.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import core.commandManager.CommandModule;

public class LockChat extends CommandModule {

	public LockChat(String label, int minArgs, int maxArgs, String usage) {
		super(label, minArgs, maxArgs, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		
		if(Chat.locked){
			Chat.locked = false;
			Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "Chat is no longer locked!");
		}
		else{
			Chat.locked = true;
			Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "Chat is now locked!");
		}

	}

}
