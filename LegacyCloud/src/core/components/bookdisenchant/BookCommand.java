package core.components.bookdisenchant;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import core.commandManager.CommandModule;

public class BookCommand extends CommandModule{

	public BookCommand(String label, int minArgs, int maxArgs, String usage) {
		super(label, minArgs, maxArgs, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("Only players can use this command!");
			return;
		}
		
		
		Player player = (Player) sender;
		
		if(player.getInventory().getItemInHand().getType()==Material.ENCHANTED_BOOK){
			player.getInventory().setItemInHand(new ItemStack(Material.BOOK));
		}
		
		
	}

}
