package core.components.pearls;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ThrowPearl implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onPearlThrow(PlayerInteractEvent event){
	
		Action action = event.getAction();
		if(action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR){
			if(event.getMaterial() != Material.ENDER_PEARL) return;
			
			//System.out.println("hi");
			
			Player player = event.getPlayer();
			String playerName = player.getName();
			
			if(Pearls.getInstance().contains(playerName)){
				player.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "You can't use this right now!");
				event.setCancelled(true);
				return;
			}
			
			Pearls.getInstance().add(playerName);
			
		}
		
		
		
	}

}
