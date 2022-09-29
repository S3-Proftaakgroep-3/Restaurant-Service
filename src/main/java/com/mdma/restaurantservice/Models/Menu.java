package com.mdma.restaurantservice.Models;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private List<Product> products;

    public Menu(List<Product> products) {
        this.products = products;
    }
}
