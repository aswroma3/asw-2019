package asw.efood.restaurantservice.domain;

import javax.persistence.*; 

import java.util.*;

@Embeddable
public class RestaurantMenu {

	@ElementCollection
	private List<MenuItem> menuItems;

	public RestaurantMenu() {
	}

	public RestaurantMenu(List<MenuItem> menuItems) {
		this(); 
		this.menuItems = menuItems; 
	}
	
	public List<MenuItem> getMenuItems() {
		return menuItems; 
	}
	
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems; 
	}

	public String toString() {
		return "RestaurantMenu(" + 
			"menuItems=" + menuItems + 
			")"; 
	}

}
