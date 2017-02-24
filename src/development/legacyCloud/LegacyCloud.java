package development.legacyCloud.randomHashTags.yoyo;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import development.legacyCloud.randomHashTags.yoyo.events.playerDeathEvents;

public class LegacyCloud extends JavaPlugin {
	public Plugin getPlugin;
	private PluginManager pm = getServer().getPluginManager();
	
	public void onEnable() {
		getPlugin = this;
		saveDefaultConfig();
		//
		pm.registerEvents(new playerDeathEvents(), this);
		//
	}
}
