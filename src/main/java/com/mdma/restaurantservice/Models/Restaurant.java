package com.mdma.restaurantservice.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class Restaurant {
    @Id
    private String id;
    private String name;
    @Field("sub")
    private Menu menu;

    private List<String> categories;

    public Restaurant(String name, Menu menu, List<String> categories) {
        this.name = name;
        this.menu = menu;
        this.categories = categories;
    }
}
