package com.pluralsight;

import java.util.ArrayList;

public class Cheese extends PremiumToppings {
    private double cheesePrice;
    private double extraCheeseCost;

    public Cheese(String name, String sizeType, double cheesePrice, double extraCheeseCost) {
        super(name, sizeType);
        this.cheesePrice = cheesePrice;
        this.extraCheeseCost = extraCheeseCost;
    }
    public double getCheesePrice() {
        switch (getSizeType()) {
            case "4 inch":
                return cheesePrice + .75;
            case "8 inch":
                return cheesePrice + 1.5;
            case "12 inch":
                return cheesePrice + 2.25;
            default:
                return cheesePrice;
        }
    }
    public double getCheesePrice(boolean extraCheese) {
        double totalCheesePrice = cheesePrice;

        if (extraCheese) {
            switch (getSizeType()) {
                case "4 inch":
                    totalCheesePrice += 0.5;
                    break;
                case "8 inch":
                    totalCheesePrice += 1.0;
                    break;
                case "12 inch":
                    totalCheesePrice += 1.5;
                    break;
            }
        }
        return totalCheesePrice;
    }

    public static ArrayList<Cheese> createCheeseList(double cheesePrice, double extraCheeseCost, String sizeType) {
        ArrayList<Cheese> cheeseList = new ArrayList<>();

        cheeseList.add(new Cheese("cheddar", sizeType, cheesePrice, extraCheeseCost));
        cheeseList.add(new Cheese("swiss", sizeType, cheesePrice, extraCheeseCost));
        cheeseList.add(new Cheese("pepper jack", sizeType, cheesePrice, extraCheeseCost));
        cheeseList.add(new Cheese("provolone", sizeType, cheesePrice, extraCheeseCost));
        cheeseList.add(new Cheese("american", sizeType, cheesePrice, extraCheeseCost));
        return cheeseList;
    }
}
