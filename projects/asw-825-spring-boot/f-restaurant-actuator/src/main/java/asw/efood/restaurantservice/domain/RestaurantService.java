package asw.efood.restaurantservice.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 
import java.util.logging.*; 

@Service
@Transactional
public class RestaurantService {

	private Logger logger = Logger.getLogger(RestaurantService.class.toString());

	@Autowired
	private RestaurantRepository restaurantRepository;

 	public Restaurant createRestaurant(String name, String location) {
		Restaurant restaurant = new Restaurant(name, location); 
		return restaurantRepository.save(restaurant);
	}

 	public Restaurant createRestaurantWithMenu(String name, String location, List<MenuItem> menuItems) {
		RestaurantMenu menu = new RestaurantMenu(menuItems);
		Restaurant restaurant = new Restaurant(name, location, menu); 
		return restaurantRepository.save(restaurant);
	}

 	public Restaurant createRestaurantMenu(Long id, List<MenuItem> menuItems) {
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		RestaurantMenu menu = new RestaurantMenu(menuItems);
		restaurant.setMenu(menu); 
		return restaurantRepository.save(restaurant);
	}
	
 	public Restaurant getRestaurant(Long id) {
		return restaurantRepository.findById(id).orElse(null);
	}

 	public RestaurantMenu getRestaurantMenu(Long id) {
		logger.info("getRestaurantMenu " + id);
		Restaurant restaurant = restaurantRepository.findByIdWithMenu(id);
		logger.info("getRestaurantMenu " + id + " " + restaurant.toString());
		return restaurant.getMenu();
	}

 	public Restaurant getRestaurantByName(String name) {
		return restaurantRepository.findByName(name);
	}
	
	public Collection<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll(); 
	}
	
	public Collection<Restaurant> getAllRestaurantsByLocation(String location) {
		return restaurantRepository.findAllByLocation(location);
	}
	

}

