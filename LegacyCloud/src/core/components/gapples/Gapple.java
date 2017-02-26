package core.components.gapples;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;

import core.components.Component;

public class Gapple extends Component{
	
	public static long gappleTimer = 0;
	
	public static Set<String> cooldownPlayers = new HashSet<>();

	@Override
	public void onEnable() {
		this.enableMessage("Gapple-Timer");
		this.addEvent(new GappleEat());
		int cooldown = -1;
		try {
			cooldown = this.getCustomConfig().getInt("gapple.cooldown") * 20;
		} catch (Exception e) {
			cooldown = 600 * 20;
		}
		finally{
			if(cooldown == -1){
				cooldown = 600 * 20;
			}
		}
		
		Gapple.gappleTimer = cooldown;
		
		this.getCustomConfig().options().copyDefaults(true);
		this.saveCustomConfig();
		
		Bukkit.getLogger().info("Gapple cooldown is " + cooldown + " ticks");
		
	}

	@Override
	public void onDisable() {
		this.disableMessage("Gapple-Timer");
		
	}

}
