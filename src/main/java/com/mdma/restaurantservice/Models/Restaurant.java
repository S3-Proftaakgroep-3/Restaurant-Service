package com.mdma.restaurantservice.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Restaurant {
    @Id
    private String id;
    private String name;
    @Field("sub")
    private Menu menu;

    public Restaurant(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
    }
}
