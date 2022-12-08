package com.mdma.restaurantservice.Services;

import com.mdma.restaurantservice.Models.Menu;
import com.mdma.restaurantservice.Models.Product;
import com.mdma.restaurantservice.Models.Restaurant;
import com.mdma.restaurantservice.Repos.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @Mock private RestaurantRepository restaurantRepository;
    private RestaurantService underTest;

    @BeforeEach
    void setup() {
        underTest = new RestaurantService(restaurantRepository);
    }

    @Test
    void getAllProducts() {
        // when the desired action performed
        underTest.GetAllProducts();

        // then verify
        verify(restaurantRepository).findAll();
    }

    @Test
    void getRestaurantById() {
        // for given input
        Restaurant restaurant = new Restaurant(null, null, null );

        when(restaurantRepository.findById("test123")).thenReturn(Optional.of(restaurant));
        ResponseEntity<Restaurant> expectedResult = new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);

        // when the desired action performed
        ResponseEntity<Restaurant> actualResponse = underTest.GetRestaurantById("test123");

        // then verify
        assertThat(actualResponse).isEqualTo(expectedResult);
    }

    @Test
    void getProductById() {

        // for given input
        List<String> allergies = new ArrayList<>();
        Product product = new Product(null, null, null, null, allergies , null, false, false);
        Menu menu = new Menu( List.of(product) );
        Restaurant restaurant = new Restaurant(null, menu, null );

        product.setId("test123");
        restaurant.setId("test123");

        when(restaurantRepository.findById("test123")).thenReturn(Optional.of(restaurant));

        ResponseEntity<Product> expectedResult = new ResponseEntity<>(product, HttpStatus.OK);

        // when the desired action performed
        ResponseEntity<Product> actualResponse = underTest.GetProductByID("test123", "test123");

        // then verify
        assertThat(actualResponse).isEqualTo(expectedResult);
    }

    @Test
    void postRestaurant() {
        // for given input
        Restaurant restaurant = new Restaurant(null, null, null);

        // when the desired action performed
        underTest.postRestaurant(restaurant);

        // then verify
        ArgumentCaptor<Restaurant> restaurantArgumentCaptor =
                ArgumentCaptor.forClass(Restaurant.class);

        verify(restaurantRepository).save(restaurantArgumentCaptor.capture());

        Restaurant capturedRestaurant = restaurantArgumentCaptor.getValue();

        assertThat(capturedRestaurant).isEqualTo(restaurant);
    }

    @Test
    void addProductToRestaurant() {

        // for given input
        List<String> allergies = new ArrayList<>();
        Menu menu = new Menu( new ArrayList<>() );

        Product product = new Product(null, null, null, null, allergies , null, false, false);
        Restaurant restaurant = new Restaurant(null, menu, null );

        restaurant.setId("test123");

        when(restaurantRepository.findById("test123")).thenReturn(Optional.of(restaurant));
        var expectedResponse = new ResponseEntity<>("Done", HttpStatus.OK);

        // when the desired action performed
        var actualResponse = underTest.addProductToRestaurant(restaurant.getId(), product);

        // then verify
        assertThat(actualResponse).isEqualTo(expectedResponse);

    }

    @Test
    void deleteRestaurant() {
        // for given input
        final String id = "123";

        // when the desired action performed
        underTest.deleteRestaurant(id);

        // then verify
        verify(restaurantRepository).deleteById(id);

    }

    @Test
    void updateRestaurant() {
        // for given input
        Restaurant restaurant = new Restaurant(null, null, null);
        Restaurant updatedRestaurant = new Restaurant("test123", null, null);
        restaurant.setId("test");
        updatedRestaurant.setId("test123");

        ResponseEntity<String> expectedResult = new ResponseEntity<String>( "Restaurant has been updated" , HttpStatus.OK);
        when(restaurantRepository.findById("test")).thenReturn(Optional.of(updatedRestaurant));
        when(restaurantRepository.save(updatedRestaurant)).thenReturn(updatedRestaurant);

        // when the desired action performed
        ResponseEntity<String> actualResponse = underTest.updateRestaurant(restaurant.getId(), updatedRestaurant);

        // then verify
        assertThat(actualResponse).isEqualTo(expectedResult);
    }
}