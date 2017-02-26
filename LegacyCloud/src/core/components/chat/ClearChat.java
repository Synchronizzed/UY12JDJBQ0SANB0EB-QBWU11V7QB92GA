package core.components.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.commandManager.CommandModule;

public class ClearChat extends CommandModule{

	public ClearChat(String label, int minArgs, int maxArgs, String usage) {
		super(label, minArgs, maxArgs, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		
		for(Player player: Bukkit.getOnlinePlayers()){
			for(int i = 0; i<100; i++){
				player.sendMessage("");
			}
		}
		
	}
	
	

}
