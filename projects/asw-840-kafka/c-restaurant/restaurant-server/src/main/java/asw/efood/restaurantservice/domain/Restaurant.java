package asw.efood.restaurantservice.domain;

import javax.persistence.*; 

import java.util.*; 

@Entity 
public class Restaurant {

	@Id 
	@GeneratedValue
	private Long id; 
	private String name; 
	private String location; 
	
	@Embedded
	private RestaurantMenu menu;

	public Restaurant() {
	}

	public Restaurant(String name, String location) {
		this(); 
		this.name = name; 
		this.location = location; 
		this.menu = new RestaurantMenu(new ArrayList<MenuItem>());
	}
	
	public Restaurant(String name, String location, RestaurantMenu menu) {
		this(); 
		this.name = name; 
		this.location = location; 
		this.menu = menu;
	}
	
	public Long getId() {
		return id; 
	}
	
	public void setId(Long id) {
		this.id = id; 
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

	public RestaurantMenu getMenu() {
		return menu; 
	}
	
	public void setMenu(RestaurantMenu menu) {
		this.menu = menu; 
	}
	
	public String toString() {
		return "Restaurant(" + 
			"id=" + id + 
			", name=" + name + 
			", location=" + location + 
			", menu=" + menu + 
			")"; 
	}
	
}
