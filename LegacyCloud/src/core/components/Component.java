package core.components;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import core.LegacyCloud;

public abstract class Component {
	
	private String fileName = "config.yml";
	
	private PluginManager pm = Bukkit.getPluginManager();
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public abstract void onEnable();
	
	public abstract void onDisable();
	
	private FileConfiguration customConfig = null;
	
	private File customConfigFile = null;
	
	private void reloadCustomConfig() throws UnsupportedEncodingException {
	    if (customConfigFile == null) {
	    customConfigFile = new File(LegacyCloud.getInstance().getDataFolder(), fileName);
	    }
	    customConfig = YamlConfiguration.loadConfiguration(customConfigFile);

	    // Look for defaults in the jar
	    Reader defConfigStream = new InputStreamReader(LegacyCloud.getInstance().getResource(fileName), "UTF8");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        customConfig.setDefaults(defConfig);
	    }
	}
	
	public FileConfiguration getCustomConfig() {
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
	        customConfigFile = new File(LegacyCloud.getInstance().getDataFolder(), fileName);
	    }
	    if (!customConfigFile.exists()) {            
	         LegacyCloud.getInstance().saveResource(fileName, false);
	     }
	}
	
	public void addEvent(Listener listener){
		pm.registerEvents(listener, LegacyCloud.getInstance());
	}

}
