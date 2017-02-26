package core.components.xp;

import java.util.HashMap;
import java.util.Map;

import core.components.Component;

public class XP extends Component {
	
	public static Map<String, Integer> mapOfEnchants = new HashMap<>();

	@Override
	public void onEnable() {
		this.enableMessage("XP-Command");
		this.addEvent(new XPListener());
		this.addEvent(new ThrowXPEvent());
		new DonorXP("xp", 0, Integer.MAX_VALUE, "/xp");

	}

	@Override
	public void onDisable() {
		this.disableMessage("XP-Command");
		

	}

}
