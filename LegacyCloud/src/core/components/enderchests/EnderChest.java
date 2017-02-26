package core.components.enderchests;

import org.bukkit.Bukkit;

import core.components.Component;

public class EnderChest extends Component{

	@Override
	public void onEnable() {
		Bukkit.getLogger().info("EnderChest module is enabled!");
		this.addEvent(new OpenEnderEvent());
		
	}

	@Override
	public void onDisable() {
		Bukkit.getLogger().info("EnderChest module is disabled!");
		
	}

}
