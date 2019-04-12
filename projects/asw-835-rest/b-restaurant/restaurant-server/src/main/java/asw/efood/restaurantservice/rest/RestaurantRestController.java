package asw.efood.restaurantservice.rest;

import asw.efood.restaurantservice.domain.*; 
import asw.efood.restaurantservice.api.rest.*; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RequestBody; 

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 
import java.util.stream.*; 

@RestController
@RequestMapping(path="/rest")
public class RestaurantRestController {

	@Autowired 
	private RestaurantService restaurantService; 
	
	/* Trova il ristorante con restaurantId. */ 
	@GetMapping("/restaurants/{restaurantId}")
	public GetRestaurantResponse getRestaurant(@PathVariable Long restaurantId) {
		Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
		GetRestaurantResponse response = restaurantToGetRestaurantResponse(restaurant); 
		return response;
	}

	private GetRestaurantResponse restaurantToGetRestaurantResponse(Restaurant restaurant) {
		if (restaurant!=null) {
			return new GetRestaurantResponse(restaurant.getId(), restaurant.getName(), restaurant.getLocation());
		} else {
			return null;
		}
	}
	
	/* Trova tutti i ristoranti. */ 
	@GetMapping("/restaurants")
	public GetRestaurantsResponse getRestaurants() {
		Collection<Restaurant> restaurants = restaurantService.getAllRestaurants();
		Collection<GetRestaurantResponse> restaurantResponses = 
			restaurants
				.stream()
				.map(r -> restaurantToGetRestaurantResponse(r))
				.collect(Collectors.toList());
		return new GetRestaurantsResponse(restaurantResponses);
	}
	
	/* Crea un nuovo ristorante. */ 
	@PostMapping("/restaurants")
	public CreateRestaurantResponse createRestaurant(@RequestBody CreateRestaurantRequest request) {
		Restaurant restaurant = restaurantService.createRestaurant(request.getName(), request.getLocation());
		CreateRestaurantResponse response = new CreateRestaurantResponse(restaurant.getId()); 
		return response; 
	}	

}
