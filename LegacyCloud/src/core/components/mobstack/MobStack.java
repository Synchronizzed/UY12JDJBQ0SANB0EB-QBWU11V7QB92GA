package core.components.mobstack;

import core.components.Component;

public class MobStack extends Component {

	@Override
	public void onEnable() {
		this.enableMessage("MobStack");
		
		
	}

	@Override
	public void onDisable() {
		this.disableMessage("MobStack");
		
	}

}
