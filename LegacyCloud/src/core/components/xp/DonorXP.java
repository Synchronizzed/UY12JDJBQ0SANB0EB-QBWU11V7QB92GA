package core.components.xp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import core.commandManager.CommandModule;

public class DonorXP extends CommandModule {

	public DonorXP(String label, int minArgs, int maxArgs, String usage) {
		super(label, minArgs, maxArgs, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		
		if(!(sender instanceof Player)) return;
		
		Player player = (Player) sender;
		
		Inventory inventory = player.getInventory();
		
		int empty = inventory.firstEmpty();
		
		if(empty==-1){
			player.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "You must have a free slot in your inventory!");
			return;
		}
		
		ExperienceManager exp = new ExperienceManager(player);
		int amount =  exp.getTotalExperience();
		exp.setTotalExperience(0);
		
		ItemStack item = new ItemStack(Material.EXP_BOTTLE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(amount + " experience");
		item.setItemMeta(meta);
		
		
		inventory.addItem(item);

	}

}
