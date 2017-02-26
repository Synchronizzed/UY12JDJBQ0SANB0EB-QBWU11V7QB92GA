package core.components.enderchests;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OpenEnderEvent implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onEnderOpen(PlayerInteractEvent event){
		if(event.getClickedBlock()==null) return;
		if(event.getClickedBlock().getType()==Material.ENDER_CHEST){
			if(!event.getPlayer().hasPermission("legacycloud.core.ender")){
				event.setCancelled(true);
				event.getPlayer().sendMessage(ChatColor.RED + "You do not have permission to open this!");
				return;
			}
		}
	}

}
