package com.pluralsight.combo;

import java.util.ArrayList;

public class Chips {
    private final String chipType;
    private final double price;

    // Constructor
    public Chips(String chipType, double price) {
        this.chipType = chipType;
        this.price = price;
    }

    // Getter method for chipType
    public String getChipType() {
        return this.chipType;
    }

    // Getter method for price
    public double getPrice() {
        return price;
    }

    // Static method to create a list of Chips objects
    public static ArrayList<Chips> createChipList() {
        ArrayList<Chips> chipsList = new ArrayList<>();

        // Add some default chip types to the list
        chipsList.add(new Chips("Nacho Cheese", 1.5));
        chipsList.add(new Chips("Sour Cream & Onion", 1.5));
        chipsList.add(new Chips("BBQ", 1.5));
        chipsList.add(new Chips("Salt & Vinegar", 1.5));
        chipsList.add(new Chips("Ranch", 1.5));
        chipsList.add(new Chips("Jalapeño", 1.5));
        chipsList.add(new Chips("Cheddar & Sour Cream", 1.5));
        chipsList.add(new Chips("Cool Ranch", 1.5));
        chipsList.add(new Chips("Honey Mustard", 1.5));
        chipsList.add(new Chips("Sweet Chili Heat", 1.5));

        return chipsList;
    }
}
