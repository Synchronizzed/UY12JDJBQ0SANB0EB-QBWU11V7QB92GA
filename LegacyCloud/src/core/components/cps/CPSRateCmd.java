package core.components.cps;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import core.commandManager.CommandModule;
import net.md_5.bungee.api.ChatColor;

public class CPSRateCmd extends CommandModule {
	
	public CPSRateCmd(String label, int minArgs, int maxArgs, String usage) {
	super(label, minArgs, maxArgs, usage);
	}
	
    @Override
    public void run(CommandSender sender, String[] args)
    {
                if(Bukkit.getPlayer(args[0]) != null)
                {
  
                    UUID target = Bukkit.getPlayer(args[0]).getUniqueId();
 
                    double rate = 0;

                    if(CPS.getCPS().getCR().get(target) != null)
                    {
                     
                        rate = CPS.getCPS().getCR().get(target);
                    }
                    
                    sender.sendMessage(ChatColor.GREEN + "Player " + args[0] + " has a click rate of " + rate + " clicks/second");
                    
                }
                
                sender.sendMessage(ChatColor.RED + args[0] + " is not a valid player");
    }

	
 
}
