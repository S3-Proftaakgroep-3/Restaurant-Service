package com.mdma.restaurantservice.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class Menu {
    private List<Product> products;

    public Menu(@JsonProperty("products")List<Product> products) {
        this.products = products;
    }
}
