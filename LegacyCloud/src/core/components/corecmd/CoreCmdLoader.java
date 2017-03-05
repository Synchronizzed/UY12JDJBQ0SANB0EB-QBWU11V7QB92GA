package core.components.corecmd;

import java.util.ArrayList;

import com.google.common.collect.Lists;

import core.components.Component;
import net.md_5.bungee.api.ChatColor;

public class CoreCmdLoader extends Component{

    ArrayList<String> list;
	static CoreCmdLoader cmd;
	
	@Override
	public void onEnable() {

		cmd = this;
		list = Lists.newArrayList();
		assembleList();
		new CoreCmd("legacycore", 0, 1, "Get information about the LegacyCore core.");
		
	}

	private void assembleList() {
		
		list.add(ChatColor.GREEN + "LegacyCore - V.1");
		list.add(ChatColor.GREEN +"Authors...");
		list.add(ChatColor.GREEN + "Yoyo");
		list.add(ChatColor.GREEN + "JohnKZ");
		
	}

	@Override
	public void onDisable() {
		
	    cmd = null;
		
	}
	
	public  ArrayList<String> getList() { return list; }

	public static CoreCmdLoader getCmd() {return cmd; }
	

}
