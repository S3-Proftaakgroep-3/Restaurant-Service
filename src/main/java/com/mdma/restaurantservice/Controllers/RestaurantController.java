package com.mdma.restaurantservice.Controllers;

import com.mdma.restaurantservice.Models.Product;
import com.mdma.restaurantservice.Models.Restaurant;
import com.mdma.restaurantservice.Services.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/restaurant")
@AllArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> FetchAllProducts() {
        return restaurantService.GetAllProducts();
    }

    @GetMapping("/get")
    public ResponseEntity<Restaurant> FetchRestaurant(@RequestParam String id) {
        return restaurantService.GetRestaurantById(id);
    }

    @GetMapping("/get/product")
    public ResponseEntity<Product> FetchProduct(@RequestParam String restaurantId, @RequestParam String id){
        return restaurantService.GetProductByID(restaurantId, id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.postRestaurant(restaurant);
    }

    @PostMapping("/add/product")
    public ResponseEntity<String> addProductTorestaurant(@RequestParam String id, @RequestBody Product product){
        return restaurantService.addProductToRestaurant(id, product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteRestaurant(@RequestParam String id) {
        return restaurantService.deleteRestaurant(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateRestaurant(@RequestParam String id, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }
}
