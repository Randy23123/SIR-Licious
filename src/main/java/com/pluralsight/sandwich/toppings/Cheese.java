package com.pluralsight.sandwich.toppings;

import com.pluralsight.sandwich.Size;

import java.util.ArrayList;

public class Cheese extends PremiumToppings {
    private double cheesePrice;

    public Cheese(String name, String sizeType, double cheesePrice) {
        super(name, sizeType);
        this.cheesePrice = cheesePrice;
    }



    public double getCheesePrice() {
        switch (Size.getSizeType()) {
            case "4":
                for (Cheese cheese : createCheeseList(Size.getSizeType())) {
                    return cheese.cheesePrice = 0.75;
                }
            case "8":
                for (Cheese cheese : createCheeseList(Size.getSizeType())) {
                    return cheese.cheesePrice = 1.50;
                }
            case "12":
                for (Cheese cheese : createCheeseList(Size.getSizeType())) {
                    return cheese.cheesePrice = 2.25;
                }
        }
        return this.cheesePrice;
    }

    public double getCheesePrice(boolean extraCheese) {

        if (extraCheese) {
            switch (Size.getSizeType()) {
                case "4":
                    for (Cheese cheese : createCheeseList(Size.getSizeType())) {
                        return cheese.cheesePrice = 0.30;
                    }
                case "8":
                    for (Cheese cheese : createCheeseList(Size.getSizeType())) {
                        return cheese.cheesePrice = 0.60;
                    }
                case "12":
                    for (Cheese cheese : createCheeseList(Size.getSizeType())) {
                        return cheese.cheesePrice = 0.90;
                    }
            }
        }
        return this.cheesePrice;
    }

    public static ArrayList<Cheese> createCheeseList(String size) {
        ArrayList<Cheese> cheeseList = new ArrayList<>();

        cheeseList.add(new Cheese("cheddar", size, 0));
        cheeseList.add(new Cheese("swiss", size, 0));
        cheeseList.add(new Cheese("pepper jack", size, 0));
        cheeseList.add(new Cheese("provolone", size, 0));
        cheeseList.add(new Cheese("american", size, 0));
        return cheeseList;
    }
}
