package core.commandManager;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import core.LegacyCloud;
import core.commandManager.LegacyExecutor;

public abstract class CommandModule {
	
	public String label;
	
	public String usage;
	
	public int minArgs;
	
	public int maxArgs;
	
	/**
	 * Super Initializer for commands
	 * 
	 * @param label The command label, eg for /help "help" is the label
	 * @param minArgs The minimum amount of arguments the command can recieve
	 * @param maxArgs The maximum amount of arguments the command can recieve
	 * @param usage The usage of the command
	 * 
	 */
	
	public CommandModule(String label, int minArgs, int maxArgs, String usage){
		this.label = label;
		this.minArgs = minArgs;
		this.maxArgs = maxArgs;
		this.usage = usage;
		
		LegacyCloud.commands.put(label, this);
		
		LegacyCloud.getInstance().getCommand(label).setExecutor(new LegacyExecutor());
	}
	
	public abstract void run(CommandSender sender, String[] args);
	
	
	
	

}
