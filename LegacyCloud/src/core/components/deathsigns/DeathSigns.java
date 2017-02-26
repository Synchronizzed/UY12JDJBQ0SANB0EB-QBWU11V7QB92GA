package core.components.deathsigns;

import core.components.Component;
import core.components.deathsigns.events.DeathEvent;

public class DeathSigns extends Component{

	@Override
	public void onEnable() {
		this.enableMessage("DeathSigns");
		this.addEvent(new DeathEvent());
		//this.addEvent(listener);
		
	}

	@Override
	public void onDisable() {
		this.disableMessage("DeathSigns");
		// TODO Auto-generated method stub
		
	}
	
	

}
