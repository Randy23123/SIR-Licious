package com.pluralsight;

import java.util.List;

public abstract class Sandwich {
    private Bread bread;
    private List<Toppings> toppings;
    private boolean toasted;

    public Sandwich(Bread bread, List<Toppings> toppings, boolean toasted) {
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    public abstract void addTopping(Toppings topping);

    public abstract void removeTopping(Toppings topping);

    public abstract void setToasted(boolean toasted);

    public abstract double getPrice();
}