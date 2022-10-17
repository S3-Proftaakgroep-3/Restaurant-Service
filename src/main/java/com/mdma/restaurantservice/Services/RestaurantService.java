package com.mdma.restaurantservice.Services;

import com.mdma.restaurantservice.Models.Menu;
import com.mdma.restaurantservice.Models.Product;
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
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Restaurant> GetRestaurantById(String id) {
        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<Product> GetProductByID(String restaurantId, String id) {
        if (repository.findById(restaurantId).isPresent()){
            Menu menu = repository.findById(restaurantId).get().getMenu();
            List<Product> products = menu.getProducts();
            for (Product product : products){
                if (product.getId().equals(id)){
                    return new ResponseEntity<>(product, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> postRestaurant(Restaurant restaurant) {
        if (repository.save(restaurant) == restaurant)
            return new ResponseEntity<>( "Restaurant has been saved" , HttpStatus.OK);
        else
            return new ResponseEntity<>("Restaurant hasn't been saved", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addProductToRestaurant(String id, Product product) {
        if (repository.findById(id).isPresent()) {
            Restaurant restaurant = repository.findById(id).get();
            restaurant.getMenu().getProducts().add(product);
            repository.save(restaurant);
            return new ResponseEntity<>("Done", HttpStatus.OK);
        }
        return new ResponseEntity<>("Couldnt find restaurant", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Boolean> deleteRestaurant(String id) {
        repository.deleteById(id);
        return new ResponseEntity<>( true , HttpStatus.OK);
    }

    public ResponseEntity<String> updateRestaurant(String id, Restaurant restaurant) {
        restaurant.setId(id);
        if (repository.findById(id).isPresent()){
            if (repository.save(restaurant) == restaurant){
                return new ResponseEntity<>( "Restaurant has been updated" , HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("Restaurant failed to update", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Restaurant hasn't been updated: Restaurant not found", HttpStatus.BAD_REQUEST);
        }
    }
}
