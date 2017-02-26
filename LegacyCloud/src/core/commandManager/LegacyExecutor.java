package core.commandManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import core.LegacyCloud;

public class LegacyExecutor implements CommandExecutor{
	
	
	/**
	 * This method processes every command, running the standard if checks to make sure the command can run
	 */
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(LegacyCloud.commands.containsKey(command.getName())){
			
			if((!sender.hasPermission("legacycloud.core." + command.getName()))||!sender.hasPermission("legacycloud.admin")){
				sender.sendMessage(ChatColor.RED + "You do not have permission for this command!");
				return true;
			}
			
			CommandModule module = LegacyCloud.commands.get(command.getName());
			
			 if(args.length >= module.minArgs && args.length <= module.maxArgs){
				 module.run(sender, args);
			 }
			 else{
				 sender.sendMessage(ChatColor.RED + "Usage: "+ module.usage);
			 }
		}
		return true;
	}
	
	


}
