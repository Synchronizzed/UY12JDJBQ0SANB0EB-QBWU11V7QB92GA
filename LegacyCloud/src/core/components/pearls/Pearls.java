package core.components.pearls;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;

import core.LegacyCloud;
import core.components.Component;

public class Pearls extends Component {
	
	private static Pearls instance = null;
	
	private long cooldown = -1;
	
	public static Pearls getInstance(){
		return instance;
	}
	
	private Set<String> cooldowns = new HashSet<>();
	
	public boolean contains(String playerName){
		return cooldowns.contains(playerName);
	}
	
	public void add(String playerName){
		this.cooldowns.add(playerName);
		//TODO: Trigger scoreboard
		Bukkit.getScheduler().scheduleSyncDelayedTask(LegacyCloud.getInstance(), new Runnable(){

			@Override
			public void run() {
				
				remove(playerName);
				
			}
			
		}, cooldown);
	}
	
	public void remove(String playerName){
		
		if(cooldowns.contains(playerName)){
			cooldowns.remove(playerName);
			
			//TODO: Trigger scoreboard
		}
		
	}

	@Override
	public void onEnable() {
		this.enableMessage("Pearls");
		this.addEvent(new ThrowPearl());
		Pearls.instance = this;
		
		try{
			this.cooldown = this.getCustomConfig().getInt("pearls.cooldown")*20;
		}
		catch(Exception e){
			this.cooldown = 10*20;
		}
		finally{
			if(this.cooldown==-1){
				this.cooldown = 10*20;
			}
		}
		
		Bukkit.getLogger().info("Pearl cooldown is: " + this.cooldown + " ticks");

	}

	@Override
	public void onDisable() {
		this.disableMessage("Pearls");
		this.cooldowns.clear();

	}
	

}
