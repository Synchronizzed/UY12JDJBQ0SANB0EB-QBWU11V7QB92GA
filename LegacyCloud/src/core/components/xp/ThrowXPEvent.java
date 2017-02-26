package core.components.xp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

import org.bukkit.event.player.PlayerInteractEvent;

public class ThrowXPEvent implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void throwBottle(PlayerInteractEvent event){
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			if(event.getMaterial()!=Material.EXP_BOTTLE) return;
			
			String[] parts = event.getItem().getItemMeta().getDisplayName().split(" ");
			
			int amount = 0;
			try{
				amount = Integer.parseInt(parts[0]);
			}
			catch(NumberFormatException e){
				Bukkit.getLogger().warning(parts[0]);
				return;
			}
			
			XP.mapOfEnchants.put(event.getPlayer().getName(), amount);
			System.out.println("here");
			
			
		}
	}

}
