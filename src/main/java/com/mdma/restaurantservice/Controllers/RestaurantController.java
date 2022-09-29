package com.mdma.restaurantservice.Controllers;

import com.mdma.restaurantservice.Models.Restaurant;
import com.mdma.restaurantservice.Services.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurant")
@AllArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> FetchAllProducts() {
        return restaurantService.GetAllProducts();
    }

    @GetMapping("/get")
    public Restaurant FetchRestaurant(@RequestParam String name) {
        return restaurantService.GetRestaurantByName(name);
    }

    @PostMapping("/create")
    public Restaurant createRestaurant(Restaurant restaurant) {

        return restaurantService.postRestaurant(restaurant);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
    }

    @PutMapping("/update/{id}")
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }
}
