package com.mdma.restaurantservice.Repos;

import com.mdma.restaurantservice.Models.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    Restaurant findRestaurantByName(String name);
}
