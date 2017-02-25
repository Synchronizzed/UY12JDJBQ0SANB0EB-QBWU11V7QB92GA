package core;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Log.Level;

import core.components.Component;
import core.components.enchantlimiting.EnchantLimiting;

public class ComponentRegistration {
	
	private static ComponentRegistration instance = null;
	
	public static ComponentRegistration getInstance(){
		if(instance == null){
			instance = new ComponentRegistration();
		}
		return instance;
	}
	
	private Set<Component> listOfModules = new HashSet<>();
	
	private FileConfiguration customConfig = null;
	
	private File customConfigFile = null;
	
	private void reloadCustomConfig() throws UnsupportedEncodingException {
	    if (customConfigFile == null) {
	    customConfigFile = new File(LegacyCloud.getInstance().getDataFolder(), "modules.yml");
	    }
	    customConfig = YamlConfiguration.loadConfiguration(customConfigFile);

	    // Look for defaults in the jar
	    Reader defConfigStream = new InputStreamReader(LegacyCloud.getInstance().getResource("modules.yml"), "UTF8");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        customConfig.setDefaults(defConfig);
	    }
	}
	
	private FileConfiguration getCustomConfig() {
	    if (customConfig == null) {
	        try {
				reloadCustomConfig();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return customConfig;
	}
	
	public void saveCustomConfig() {
	    if (customConfig == null || customConfigFile == null) {
	        return;
	    }
	    try {
	        getCustomConfig().save(customConfigFile);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public void saveDefaultConfig() {
	    if (customConfigFile == null) {
	        customConfigFile = new File(LegacyCloud.getInstance().getDataFolder(), "modules.yml");
	    }
	    if (!customConfigFile.exists()) {            
	         LegacyCloud.getInstance().saveResource("modules.yml", false);
	     }
	}
	
	
	private ComponentRegistration(){
		this.registerComponent();
		//this.onEnable();
	}
	
	private void registerComponent(){
		this.listOfModules.add(new EnchantLimiting());
	}
	
	public void onEnable(){
		this.listOfModules.forEach(e -> e.onEnable());
	}
	
	public void onDisable(){
		this.listOfModules.forEach(e -> e.onDisable());
		
	}

}
