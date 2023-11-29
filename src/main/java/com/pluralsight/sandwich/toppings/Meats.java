package com.pluralsight.sandwich.toppings;

import com.pluralsight.sandwich.Size;

import java.util.ArrayList;

public class Meats extends PremiumToppings {
    private static double meatPrice;
    private double extraMeatCost;

    public Meats(String name, String sizeType, double meatPrice, double extraMeatCost) {
        super(name, sizeType);
        this.meatPrice = meatPrice;
        this.extraMeatCost = extraMeatCost;
    }

    public Meats(String name, String sizeType, double meatPrice){
        super(name, sizeType);
        Meats.meatPrice = meatPrice;
    }

    public static double getMeatPrice() {
    switch (Size.getSizeType()) {
        case "4":
            return meatPrice + 1.0;
        case "8":
            return meatPrice + 2.0;
        case "12":
            return meatPrice + 3.0;
        default:
            return meatPrice;
    }
}
    public double getMeatPrice(boolean extraMeat) {
        double totalMeatPrice = meatPrice;

        if (extraMeat) {
            switch (getSizeType()) {
                case "4 inch":
                    totalMeatPrice += 0.5;
                    break;
                case "8 inch":
                    totalMeatPrice += 1.0;
                    break;
                case "12 inch":
                    totalMeatPrice += 1.5;
                    break;
            }
        }
        return totalMeatPrice;
    }

    public static ArrayList<Meats> createMeatsList() {
        ArrayList<Meats> meatsList = new ArrayList<>();

        meatsList.add(new Meats("steak",getSizeType(), getMeatPrice()));
        meatsList.add(new Meats("ham", getSizeType(), getMeatPrice()));
        meatsList.add(new Meats("salami", getSizeType(), getMeatPrice()));
        meatsList.add(new Meats("roast beef", getSizeType(), getMeatPrice()));
        meatsList.add(new Meats("chicken", getSizeType(), getMeatPrice()));
        meatsList.add(new Meats("bacon", getSizeType(), getMeatPrice()));
        return meatsList;
    }
}
