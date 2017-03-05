package core.components.cps;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CPSEvent implements Listener {

    @EventHandler
    public void clickBlock(PlayerInteractEvent ev)
    {
        if(ev.getAction() == Action.LEFT_CLICK_BLOCK)
        {
        
            int nC = 1;

            if(CPS.getCPS().getCC()
            		.get(ev.getPlayer().getUniqueId()) != null)
            {
              
                nC = nC + CPS.getCPS().getCC()
                		.get(ev.getPlayer().getUniqueId());
            }
        
            CPS.getCPS().getCC()
            .put(ev.getPlayer().getUniqueId(), nC);
        }
    }
 
   
}
