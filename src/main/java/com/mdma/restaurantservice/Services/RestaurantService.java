package com.mdma.restaurantservice.Services;

import com.mdma.restaurantservice.Models.Restaurant;
import com.mdma.restaurantservice.Repos.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    public List<Restaurant> GetAllProducts() {
        return repository.findAll();
    }

    public Restaurant GetRestaurantByName(String name) {
        return repository.findRestaurantByName(name);
    }

    public Restaurant postRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public void deleteRestaurant(String id) {
        repository.deleteById(id);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);
    }
}
