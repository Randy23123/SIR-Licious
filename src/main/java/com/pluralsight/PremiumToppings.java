package com.pluralsight;

public abstract class PremiumToppings extends Size implements Toppings {
    private String name;
    public PremiumToppings(String name, String sizeType) {
        super(sizeType);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCategory() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}