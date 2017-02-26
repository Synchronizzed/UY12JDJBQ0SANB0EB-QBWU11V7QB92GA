package core.components.coords;

import java.util.LinkedList;
import java.util.List;

import core.components.Component;

public class Coords extends Component{
	
	private static Coords instance = null;
	
	public static Coords getInstance(){
		return instance;
	}
	
	public List<String> listOfCoords = new LinkedList<>();
	
	@Override
	public void onEnable() {
		this.enableMessage("Coordinate");
		Coords.instance = this;
		
		this.setFileName("coords.yml");
		
		this.listOfCoords.clear();
		
		this.parseConfig();
		
		this.getCustomConfig().options().copyDefaults(true);
		
		this.saveCustomConfig();
		
		new CoordsCommand("coords", 0, Integer.MAX_VALUE, "/coords");

	}

	@Override
	public void onDisable() {
		this.disableMessage("Coordinate");
		
	}
	
	private void parseConfig() {
		
		this.listOfCoords = this.getCustomConfig().getStringList("coords");
		
	}
	
	

}
