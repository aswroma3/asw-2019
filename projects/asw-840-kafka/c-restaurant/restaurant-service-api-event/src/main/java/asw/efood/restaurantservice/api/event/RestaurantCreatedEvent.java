package asw.efood.restaurantservice.api.event;

import asw.efood.common.api.event.DomainEvent; 

public class RestaurantCreatedEvent implements DomainEvent {

	private Long id; 
	private String name; 
	private String location; 
	
	public RestaurantCreatedEvent() {
	}

	public RestaurantCreatedEvent(Long id, String name, String location) {
		this(); 
		this.id = id; 
		this.name = name; 
		this.location = location; 
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

	public String toString() {
		return "RestaurantCreatedEvent(" + 
			"id=" + id + 
			", name=" + name + 
			", location=" + location + 
			")"; 
	}
	
}
