package core.components.enchantlimiting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;

import core.LegacyCloud;
import core.components.Component;
import core.components.enchantlimiting.events.AnvilEvent;
import core.components.enchantlimiting.events.EnchantingEvent;

/**
 * @version 0.0.0
 * 
 * This module limits the enchants that any item can be given.
 * 
 * @author Yoyo_
 *
 */

public class EnchantLimiting extends Component{
	
	private static EnchantLimiting instance = null;
	
	public Map<Enchantment, Integer> limits = new HashMap<>();
	
	public static EnchantLimiting getInstance(){
		return instance;
	}

	@Override
	public void onEnable() {
		Bukkit.getLogger().info("EnchantLimiting is enabled!");
		
		instance = this;
		
		this.setFileName("enchantlimits.yml");
		
		this.parseConfig();
		
		this.getCustomConfig().options().copyDefaults(true);
		
		this.saveCustomConfig();
		
		this.addEvent(new EnchantingEvent());
		this.addEvent(new AnvilEvent());
		
	}

	@Override
	public void onDisable() {
		Bukkit.getLogger().info("EnchantLimiting is disabled!");

	}
	
	private void parseConfig(){
		Logger logger = Bukkit.getLogger();
		logger.info("---Enchant Limits---");
		this.getCustomConfig().getStringList("enchantlimits").forEach(e -> {
			//formatting the string for the bukkit enchant parser
			e = e.toUpperCase().replaceAll(" ", "_");
			
			String[] parts = e.split(":");
			int level;
			
			try{
				level = Integer.parseInt(parts[1]);
			}
			catch(NumberFormatException error){
				Bukkit.getLogger().warning("Error with: " + parts[1]);
				level = 1;
			}
			
			Enchantment enchant = Enchantment.getByName(parts[0]);
			if(enchant==null){
				Bukkit.getLogger().warning("Error with: " + parts[0]);
				enchant = Enchantment.ARROW_DAMAGE;
			}
			logger.info(parts[0] + " " + parts[1]);
			
			this.limits.put(enchant, level);

		});
	}
}
