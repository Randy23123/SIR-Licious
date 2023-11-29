package com.pluralsight.sandwich.toppings;

import com.pluralsight.sandwich.Size;

public abstract class PremiumToppings extends Size implements Toppings {
    private final String name;
    public PremiumToppings(String name, String sizeType) {
        super(sizeType);
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