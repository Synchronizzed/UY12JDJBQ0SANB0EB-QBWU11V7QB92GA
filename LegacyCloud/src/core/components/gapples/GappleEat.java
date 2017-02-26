package core.components.gapples;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.material.MaterialData;

import core.LegacyCloud;

public class GappleEat implements Listener{
	
	@EventHandler
	public void onGappleEat(PlayerItemConsumeEvent event){

		Material food = event.getItem().getType();

		if(food!=Material.GOLDEN_APPLE) return;
		
		//Bukkit.broadcastMessage("test<1");

		if(event.getItem().getData().getData() != (byte)1) return;
		
		//Bukkit.broadcastMessage("test<2");

		Player player = event.getPlayer();
		String playerName = player.getName();

		if(Gapple.cooldownPlayers.contains(playerName)){
			event.setCancelled(true);
			player.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "You can't eat a god apple right now!");
			return;
		}

		this.eatApple(player.getName());
		Gapple.cooldownPlayers.add(playerName);
	}

	private void eatApple(String playerName) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(LegacyCloud.getInstance(), new Runnable(){

			@Override
			public void run() {
				
				Gapple.cooldownPlayers.remove(playerName);
				
			}
			
		}, Gapple.gappleTimer);
		
	}

}
