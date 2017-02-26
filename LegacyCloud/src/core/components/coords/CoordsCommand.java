package core.components.coords;

import org.bukkit.command.CommandSender;

import core.commandManager.CommandModule;

public class CoordsCommand extends CommandModule{

	public CoordsCommand(String label, int minArgs, int maxArgs, String usage) {
		super(label, minArgs, maxArgs, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		sender.sendMessage("--- Coordinates ---");
		Coords.getInstance().listOfCoords.forEach(e -> sender.sendMessage(e));
	}
	
	

}
