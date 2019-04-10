package asw.efood.restaurantservice.web;

import asw.efood.restaurantservice.domain.*; 

import java.util.*; 

public class EditRestaurantMenuForm {

	private List<MenuItem> menuItems;
	
	public EditRestaurantMenuForm() {
	}

	public EditRestaurantMenuForm(List<MenuItem> menuItems) {
		this.menuItems = menuItems; 
	}

	public List<MenuItem> getMenuItems() {
		return menuItems; 
	}
	
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems; 
	}

}
