package com.pluralsight.sandwich.toppings;


import com.pluralsight.sandwich.Bread;

public abstract class PremiumToppings extends Bread implements Toppings {
    private final String name;

    public PremiumToppings(String breadType, String sizeType, String name) {
        super(breadType, sizeType);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}