package core.components.firstjoin;

import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LoginEvent implements Listener{
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoinEvent(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(!player.hasPlayedBefore()){
			Inventory inventory = player.getInventory();
			for(Map.Entry<ItemStack, Integer> entry: FirstJoin.mapOfItems.entrySet()){
				
				inventory.setItem(entry.getValue(), entry.getKey());			
			}
		}
	}
	

}
