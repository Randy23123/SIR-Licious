package com.pluralsight.sandwich;

import com.pluralsight.sandwich.toppings.Toppings;

import java.util.List;

public class Sandwich {
    private final Bread bread;
    private final List<Toppings> toppings;
    private final boolean toasted;
    private double sandwichPrice;

    // Constructor
    public Sandwich(Bread bread, List<Toppings> toppings, boolean toasted) {
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    // Method to get the base price of the sandwich based on its size
    public double getSandwichPrice(String sizeType) {
        return switch (sizeType) {
            case "4" -> this.sandwichPrice = 5.50;
            case "8" -> this.sandwichPrice = 7.00;
            case "12" -> this.sandwichPrice = 8.50;
            default -> 0;
        };
    }

    // Method to calculate the total price of the sandwich, including toppings
    public double calculatePrice() {
        double totalPrice = getSandwichPrice(Bread.getSizeType());

        // Add the price of each topping to the total
        for (Toppings t : toppings) {
            totalPrice += t.getPrice();
        }

        return totalPrice;
    }

    // Getter method for accessing the list of toppings
    public List<Toppings> getToppings() {
        return toppings;
    }
}
