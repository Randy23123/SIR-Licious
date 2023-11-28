package com.pluralsight;

import java.util.ArrayList;

public class Chips {
    private String chipType;
    private double price;

    public Chips(String chipType, double price) {
        this.chipType = chipType;
        this.price = price;
    }
    public String getChipType() {
        return this.chipType;
    }
    public double getPrice() {
        return price;
    }
    public static ArrayList<Chips> createChipList() {
        ArrayList<Chips> chipsList = new ArrayList<>();

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

    public static void main(String[] args) {
        ArrayList<Chips> chipArrayList = Chips.createChipList();
        for (Chips chip : chipArrayList) {
            System.out.println(chip.getChipType() + " - Price: $" + chip.getPrice());
        }
    }
}