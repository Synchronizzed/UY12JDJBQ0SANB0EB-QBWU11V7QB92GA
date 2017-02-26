package core.components.foundore;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.Block;

import core.components.Component;

public class FoundOre extends Component {
	
	public static Set<Material> materials = new HashSet<>();
	
	public static Set<Block> blocks = new HashSet<>();

	@Override
	public void onEnable() {
		this.enableMessage("FoundOre");
		FoundOre.materials.add(Material.DIAMOND_ORE);
		this.addEvent(new BlockListener());
	}

	@Override
	public void onDisable() {
		this.disableMessage("FoundOre");

	}

}
