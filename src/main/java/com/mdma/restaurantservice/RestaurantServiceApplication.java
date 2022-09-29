package com.mdma.restaurantservice;

import com.mdma.restaurantservice.Enums.ProductSize;
import com.mdma.restaurantservice.Models.Menu;
import com.mdma.restaurantservice.Models.Product;
import com.mdma.restaurantservice.Models.Restaurant;
import com.mdma.restaurantservice.Repos.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class RestaurantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }

    // @Bean
    // CommandLineRunner runner(RestaurantRepository repository) {
    // return args -> {
    // Restaurant restaurant = new Restaurant(
    // "Steijn de pizza",
    // new Menu(
    // new ArrayList<Product>(
    // Arrays.asList(
    // new Product("Kaas soep", "Lekker kaas soepje", 4.50, ProductSize.Small,
    // "soep", true),
    // new Product("Kaas soep", "Lekker kaas soepje", 4.50, ProductSize.Small,
    // "soep",true)
    // )
    // )
    // )
    // );
    //
    // repository.insert(restaurant);

}
