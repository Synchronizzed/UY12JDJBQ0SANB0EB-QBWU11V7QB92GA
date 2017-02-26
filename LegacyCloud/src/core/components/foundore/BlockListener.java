package core.components.foundore;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener{
	
	@EventHandler(priority = EventPriority.LOW)
	public void onBreakingBlock(BlockBreakEvent event){
		Block block = event.getBlock();
		
		if(!FoundOre.materials.contains(block.getType())) return;
		
		if(FoundOre.blocks.contains(block)){
			FoundOre.blocks.remove(block);
			return;
		}
		
		CountBlocks counter = new CountBlocks(block);
		event.getPlayer().sendMessage("" + ChatColor.RED + ChatColor.BOLD + event.getPlayer().getName() + ChatColor.GRAY +
				" has found a vein of " + ChatColor.RED + ChatColor.BOLD + counter.getLength() + " diamonds!");
		FoundOre.blocks.remove(block);
		
	}

}
