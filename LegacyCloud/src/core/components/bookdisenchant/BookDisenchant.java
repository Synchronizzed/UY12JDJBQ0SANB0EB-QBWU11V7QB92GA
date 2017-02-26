package core.components.bookdisenchant;

import core.components.Component;

public class BookDisenchant extends Component{

	@Override
	public void onEnable() {
		this.enableMessage("BookDisenchant");
		new BookCommand("bookdisenchant", 0, 0, "/bookdisenchant");
	}

	@Override
	public void onDisable() {
		this.disableMessage("BookDisenchant");
		
	}

}
