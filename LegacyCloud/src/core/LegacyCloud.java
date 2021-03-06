package core;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import core.commandManager.CommandModule;

public class LegacyCloud extends JavaPlugin {
	
	private static LegacyCloud instance = null;
	
	public static Map<String, CommandModule> commands = new HashMap<>();
	
	/**
	 * Singleton pattern, returns the instance of JavaPlugin
	 * @return instance of JavaPlugin
	 */
	public static LegacyCloud getInstance(){
		if(instance==null){
			Bukkit.getLogger().warning("shit happens");
		}
		return instance;
	}
	
	public void onEnable(){
		
		this.instance = this;
		
		if(!this.getDataFolder().exists()){
			this.getDataFolder().mkdir();
		}
		
		ComponentRegistration reg = ComponentRegistration.getInstance();
		reg.onEnable();
	}
	
	public void onDisable(){
		ComponentRegistration reg = ComponentRegistration.getInstance();
		reg.onDisable();
		
	}

}
