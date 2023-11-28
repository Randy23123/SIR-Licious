package com.pluralsight;

import java.util.ArrayList;

public class Meats extends PremiumToppings {
    private double meatPrice;
    private double extraMeatCost;

    public Meats(String name, String sizeType, double meatPrice, double extraMeatCost) {
        super(name, sizeType);
        this.meatPrice = meatPrice;
        this.extraMeatCost = extraMeatCost;
    }

    public double getMeatPrice() {
    switch (getSizeType()) {
        case "4 inch":
            return meatPrice + 1.0;
        case "8 inch":
            return meatPrice + 2.0;
        case "12 inch":
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

    public static ArrayList<Meats> createMeatsList(double meatPrice, double extraMeatCost, String sizeType) {
        ArrayList<Meats> meatsList = new ArrayList<>();

        meatsList.add(new Meats("steak", sizeType, meatPrice, extraMeatCost));
        meatsList.add(new Meats("ham", sizeType, meatPrice, extraMeatCost));
        meatsList.add(new Meats("salami", sizeType, meatPrice, extraMeatCost));
        meatsList.add(new Meats("roast beef", sizeType, meatPrice, extraMeatCost));
        meatsList.add(new Meats("chicken", sizeType, meatPrice, extraMeatCost));
        meatsList.add(new Meats("bacon", sizeType, meatPrice, extraMeatCost));
        return meatsList;
    }
}
