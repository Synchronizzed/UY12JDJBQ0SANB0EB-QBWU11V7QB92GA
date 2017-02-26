package core.components.enchantlimiting.events;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import core.components.enchantlimiting.EnchantLimiting;

public class AnvilEvent implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onAnvilClick(InventoryClickEvent event){
		if(event.getInventory().getType() != InventoryType.ANVIL) return;
		
		Map<Enchantment, Integer> mapOfEnchantments = EnchantLimiting.getInstance().limits;
		
		if(event.getSlotType() == InventoryType.SlotType.RESULT){
			
			ItemStack item = event.getCurrentItem();
			
			Map<Enchantment, Integer> itemsEnchantments = item.getEnchantments();
			
			mapOfEnchantments.keySet()
			.stream()
			.filter(e -> item.containsEnchantment(e))
			.forEach(e -> {
				int level = mapOfEnchantments.get(e);
				if(itemsEnchantments.get(e)>level){
					item.removeEnchantment(e);
					item.addEnchantment(e, level);
				}
			});
		}
	}
	
	

}
