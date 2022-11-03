package com.mdma.restaurantservice.Models;

import com.mdma.restaurantservice.Enums.ProductSize;
import com.mongodb.lang.Nullable;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Product {

    @Id
    private String id;
    private String name;
    private String image;
    private String description;
    private Double price;
    private List<String> sizes;
    private Category category;
    private Boolean active;
    private Boolean isBeverage;

    @Nullable
    private List<String> allergies;

    public Product(String name, String image, String description, Double price, List<String> sizes, Category category, Boolean active, Boolean isBeverage) {

        this.id = new ObjectId().toString();
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.sizes = sizes;
        this.category = category;
        this.active = active;
        this.isBeverage = isBeverage;
    }
}
