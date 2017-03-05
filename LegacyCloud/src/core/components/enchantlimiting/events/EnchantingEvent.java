package core.components.enchantlimiting.events;

import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

import core.components.enchantlimiting.EnchantLimiting;

public final class EnchantingEvent implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onEnchantItem(EnchantItemEvent event){
		Map<Enchantment, Integer> mapOfEnchants = EnchantLimiting.getInstance().limits;
		event.getEnchantsToAdd().keySet()
		.stream()
		.filter(mapOfEnchants::containsKey)
		.forEach(e -> {
			int level = mapOfEnchants.get(e);
			if(event.getEnchantsToAdd().get(e)>level){
				event.getEnchantsToAdd().put(e, level);
			}
			
		});
	}
	
}
