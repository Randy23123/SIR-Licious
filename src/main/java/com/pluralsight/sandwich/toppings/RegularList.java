package com.pluralsight.sandwich.toppings;

public class RegularList {
    private String[] vegetables = {"lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"};
    private String[] sauces = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
    private String[] sides = {"au jus", "sauce"};

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
