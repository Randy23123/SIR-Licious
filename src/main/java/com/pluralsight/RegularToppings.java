package com.pluralsight;

import java.util.ArrayList;

public class RegularToppings implements Toppings{
    private String name;
    private String category;
    private double price;

    public RegularToppings(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
