package core.components.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import core.LegacyCloud;

public class ChatEvent implements Listener{
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		
		if(Chat.locked){
			event.setCancelled(true);
			return;
		}
		
		if(Chat.slow){
			Player player = event.getPlayer();
			String playerName = player.getName();
			
			if(Chat.slowed.contains(playerName)){
				if(player.hasPermission("legacycloud.core.chat")) return;
				event.setCancelled(true);
				return;
			}
			else{
				Chat.slowed.add(playerName);
				Bukkit.getScheduler().scheduleSyncDelayedTask(LegacyCloud.getInstance(), new Runnable(){

					@Override
					public void run() {
						
						Chat.slowed.remove(playerName);
						
					}
					
				}, Chat.slowTime);
			}
		}
		
		
	}

}
