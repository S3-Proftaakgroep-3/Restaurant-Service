package com.mdma.restaurantservice.Services;

import com.mdma.restaurantservice.Models.Restaurant;
import com.mdma.restaurantservice.Repos.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    public ResponseEntity<List<Restaurant>> GetAllProducts() {
        return new ResponseEntity<List<Restaurant>>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Restaurant> GetRestaurantByName(String name) {
        return new ResponseEntity<Restaurant>(repository.findRestaurantByName(name), HttpStatus.OK);
    }

    public ResponseEntity<String> postRestaurant(Restaurant restaurant) {
        if (repository.save(restaurant) == restaurant)
            return new ResponseEntity<String>( "Restaurant has been saved" , HttpStatus.OK);
        else
            return new ResponseEntity<String>("Restaurant hasn't been saved", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Boolean> deleteRestaurant(String id) {
        repository.deleteById(id);
        return new ResponseEntity<Boolean>( true , HttpStatus.OK);
    }

    public ResponseEntity<String> updateRestaurant(String id, Restaurant restaurant) {
        restaurant.setId(id);
        if (repository.findById(id).isPresent()){
            if (repository.save(restaurant) == restaurant){
                return new ResponseEntity<String>( "Restaurant has been updated" , HttpStatus.OK);
            }
            else
                return new ResponseEntity<String>("Restaurant failed to update", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<String>("Restaurant hasn't been updated: Restaurant not found", HttpStatus.BAD_REQUEST);
        }
    }
}