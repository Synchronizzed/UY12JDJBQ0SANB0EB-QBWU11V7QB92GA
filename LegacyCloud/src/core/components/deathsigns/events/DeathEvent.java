package core.components.deathsigns.events;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public final class DeathEvent implements Listener{

	@EventHandler(priority = EventPriority.NORMAL)
	public void onDeathEvent(PlayerDeathEvent event){
		Player killer = event.getEntity().getKiller();
		if(event.getEntity().getKiller()==null){
			this.placeSign(event.getEntity().getName(),"Natrual Causes", event.getEntity().getLocation());
			return;
		}
		this.placeSign(event.getEntity().getName(), killer.getName(), event.getEntity().getLocation());
	}
	
	private void placeSign(String playerName, String killerName, Location location){
		
		if(!this.getRealLocation(location)) return;
		
		Block block = location.getBlock();
		block.setType(Material.SIGN_POST);
		Sign sign = (Sign) block.getState();
		
		Date date = new Date();
		
		sign.setLine(0, date.toString());
		sign.setLine(1, playerName);
		sign.setLine(2, "Killed by:");
		sign.setLine(3, killerName);
		sign.update();
	}
	
	private boolean getRealLocation(Location location){
		Block block = location.getBlock();
		if(block.getRelative(BlockFace.DOWN).getType()!=Material.AIR&&block.getType()==Material.AIR){
			return true;
		}
		if(location.getBlockY()<=1) return false;
		return this.getRealLocation(location.add(0, -1, 0));
	}
}
