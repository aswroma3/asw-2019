package asw.efood.restaurantservice.api.command;

import asw.efood.common.api.command.Command; 

public class CreateRestaurantCommand implements Command {

	private String name; 
	private String location; 
	
	public CreateRestaurantCommand() {
	}

	public CreateRestaurantCommand(String name, String location) {
		this(); 
		this.name = name; 
		this.location = location; 
	}
	
	public String getName() {
		return name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}

	public String getLocation() {
		return location; 
	}
	
	public void setLocation(String location) {
		this.location = location; 
	}

	public String toString() {
		return "CreateRestaurantCommand(" + 
			"name=" + name + 
			", location=" + location + 
			")"; 
	}
	
}
