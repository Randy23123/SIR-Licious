package com.pluralsight.sandwich.toppings;

public class RegularToppings implements Toppings {
    private final String name;
    private final String category;
    private final double price;

    public RegularToppings(String name, String category, RegularList regularList) {
        this.name = name;
        this.category = category;
        this.price = 0.00;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
