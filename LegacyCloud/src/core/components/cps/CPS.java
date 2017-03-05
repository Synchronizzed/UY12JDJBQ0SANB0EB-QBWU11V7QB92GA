package core.components.cps;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.google.common.collect.Maps;

import core.LegacyCloud;
import core.components.Component;

public class CPS extends Component {
	
	    private static CPS cps;
	    
		HashMap<UUID, Integer> cC;
        HashMap<UUID, Double> cR;
        
        Plugin pl;

	    @Override
	    public void onEnable()
	    {

	    	this.enableMessage("CPS");
	    	
	    	cps = this;
	    	
	        pl = LegacyCloud.getInstance();
	    	
	        this.addEvent(new CPSEvent());
	        
	        new CPSRateCmd("cps", 0, 0, "/cps <player>");
	       
	 
	        cC = Maps.newHashMap();
	        cR = Maps.newHashMap();
	        
	        startTimer();
	          
	    }
	    
		@Override
		public void onDisable() {
		
			this.disableMessage("CPS");
			
		}
	 

	    private void startTimer()
	    {
	        
	        Bukkit.getScheduler().runTaskTimer(pl, () -> {
	 
	                for(Player jplayer : Bukkit.getOnlinePlayers())
	                {
	                  
	                    if(cC.containsKey(jplayer.getUniqueId()))
	                    {
	                    	
	                        double c = cC.get(jplayer.getUniqueId());
	 
	                    
	                        double r = c / 20;
	 
	                        cR.put(jplayer.getUniqueId(), r);
	 
	                        cC.put(jplayer.getUniqueId(), 0);
	                    }
	                }
	            
	  
	        }, 0L, 20*20L);   
	    }


		public static CPS getCPS() { return cps; }

		public HashMap<UUID, Integer> getCC() {	return cC; }
		
		public HashMap<UUID, Double> getCR() { return cR; }

}

