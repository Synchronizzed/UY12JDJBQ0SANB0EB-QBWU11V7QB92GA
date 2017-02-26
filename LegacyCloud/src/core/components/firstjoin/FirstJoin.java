package core.components.firstjoin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import core.components.Component;

public class FirstJoin extends Component {
	
	public static Map<ItemStack, Integer> mapOfItems = new HashMap<>();

	@Override
	public void onEnable() {
		this.enableMessage("FirstJoin");
		this.setFileName("firstjoin.yml");
		this.configureConfigFile();
		this.getCustomConfig().options().copyDefaults(true);
		this.saveCustomConfig();;
		this.addEvent(new LoginEvent());

	}

	@Override
	public void onDisable() {
		this.disableMessage("FirstJoin");
		// TODO Auto-generated method stub

	}
	
	private void configureConfigFile() {
		
		List<String> list = this.getCustomConfig().getStringList("items");
		
		list.forEach(e -> {
			String[] items = e.split(":");
			FirstJoin.mapOfItems.put(new ItemStack(Material.getMaterial(items[0].toUpperCase().replaceAll(" ", "_"))
					,Integer.parseInt(items[1]))
					, Integer.parseInt(items[2]));
		});
		
		
		
	}
	
	

}
