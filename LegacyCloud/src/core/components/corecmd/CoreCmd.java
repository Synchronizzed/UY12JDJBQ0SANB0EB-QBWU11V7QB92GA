package core.components.corecmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.commandManager.CommandModule;
import net.md_5.bungee.api.ChatColor;

public class CoreCmd extends CommandModule{

	public CoreCmd(String label, int minArgs, int maxArgs, String usage) {
		super(label, minArgs, maxArgs, usage);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		
		if(!(sender instanceof Player)) return;
		
		if(args.length == 0) {
		
			for(String string : CoreCmdLoader.getCmd().getList()) {
				sender.sendMessage(string);
			}
			
		} else if (args.length == 1) {
			
			if(args[0].equalsIgnoreCase("reload")) {
				
			  //TODO: EVERYONE PUT THE CODE TO RELOAD HERE 
				
			} else {
				sender.sendMessage(ChatColor.RED + "Invalid arguments.");
			}
			
		}
		
		
	}
}