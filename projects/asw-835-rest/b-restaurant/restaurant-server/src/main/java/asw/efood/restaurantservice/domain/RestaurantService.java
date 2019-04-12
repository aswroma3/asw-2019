package asw.efood.restaurantservice.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 

@Service
@Transactional
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

 	public Restaurant createRestaurant(String name, String location) {
		Restaurant restaurant = new Restaurant(name, location); 
		return restaurantRepository.save(restaurant);
	}

 	public Restaurant getRestaurant(Long id) {
		return restaurantRepository.findById(id).orElse(null);
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

