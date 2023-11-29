package com.pluralsight.sandwich;

import com.pluralsight.sandwich.toppings.Toppings;

import java.util.List;

public class Sandwich {
    private final Bread bread;
    private final List<Toppings> toppings;
    private final boolean toasted;

    public Sandwich(Bread bread, List<Toppings> toppings, boolean toasted) {
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    public void addTopping(Toppings topping) {

        this.toppings.add(topping);
    }

    public void removeTopping(Toppings topping) {
        toppings.removeIf(t -> t.equals(topping));
    }


    public double calculatePrice() {
        return 0;
    }

    public Bread getBread() {
        return bread;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return toasted;
    }
}