package core.components.chat;

import java.util.HashSet;
import java.util.Set;

import core.components.Component;

public class Chat extends Component {
	
	public static boolean locked = false;
	
	public static boolean slow = false;
	
	public static long slowTime = 0;
	
	public static Set<String> slowed = new HashSet<>();

	@Override
	public void onEnable() {
		this.enableMessage("ChatManager");
		
		int useThis = 0;
		
		try{
			useThis = this.getCustomConfig().getInt("chat.slow");
		}
		catch(Exception e){
			useThis = 15;
		}
		
		this.getCustomConfig().options().copyDefaults(true);
		this.saveCustomConfig();
		
		this.addEvent(new ChatEvent());
		new ClearChat("clearchat", 0, 0, "/clearchat");
		new LockChat("lockchat", 0, 0, "/lockchat");
		new SlowChat("slowchat", 0, 0, "/slowchat");
		
		Chat.slowTime = useThis * 20;
		
		
	}

	@Override
	public void onDisable() {
		this.disableMessage("ChatManager");
		
	}

}
