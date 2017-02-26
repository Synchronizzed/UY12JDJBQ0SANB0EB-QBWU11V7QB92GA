package core.components.xp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPListener implements Listener {
	
	@EventHandler
	public void onXPBottle(ExpBottleEvent event){
		
		Player player = (Player) event.getEntity().getShooter();
		if(!XP.mapOfEnchants.containsKey(player.getName())) return;
		
		String playerName = player.getName();
		
		event.setExperience(XP.mapOfEnchants.get(playerName));
		
		XP.mapOfEnchants.remove(playerName);
		
	}

}
