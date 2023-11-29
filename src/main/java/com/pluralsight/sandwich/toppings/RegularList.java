package com.pluralsight.sandwich.toppings;

public class RegularList {
    private final String[] vegetables = {"lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"};
    private final String[] sauces = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
    private final String[] sides = {"au jus", "sauce"};

    public String[] getVegetables() {
        return vegetables;
    }

    public String[] getSauces() {
        return sauces;
    }

    public String[] getSides() {
        return sides;
    }
}
