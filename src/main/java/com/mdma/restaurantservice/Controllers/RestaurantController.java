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
    public Restaurant FetchRestaurant(@RequestParam  String name){
        return restaurantService.GetRestaurantByName(name);
    }
}
