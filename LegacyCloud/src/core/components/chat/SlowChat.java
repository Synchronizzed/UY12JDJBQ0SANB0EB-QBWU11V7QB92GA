package core.components.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import core.commandManager.CommandModule;

public class SlowChat extends CommandModule {

	public SlowChat(String label, int minArgs, int maxArgs, String usage) {
		super(label, minArgs, maxArgs, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		
		if(Chat.slow){
			Chat.slow = false;
			Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "Chat is no longer slowed!");
			Chat.slowed.clear();
			
		}
		else{
			Chat.slow = true;
			Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "Chat is slowed!");
		}

	}

}
