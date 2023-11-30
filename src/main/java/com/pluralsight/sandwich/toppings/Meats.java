package com.pluralsight.sandwich.toppings;

import com.pluralsight.sandwich.Size;

import java.util.ArrayList;

public class Meats extends PremiumToppings {
    private double meatPrice;

    public Meats(String name, String sizeType, double meatPrice) {
        super(name, sizeType);
        this.meatPrice = meatPrice;
    }

    @Override
    public double getPrice() {
        return getMeatPrice();
    }

    public double getMeatPrice() {
    switch (Size.getSizeType()) {
        case "4":
            for (Meats meats: createMeatsList(Size.getSizeType())) {
               return meats.meatPrice = 1.0;
            }
        case "8":
            for (Meats meats: createMeatsList(Size.getSizeType())) {
                return meats.meatPrice = 2.0;
            }
        case "12":
            for (Meats meats: createMeatsList(Size.getSizeType())) {
                return meats.meatPrice = 3.0;
            }
        default:
            return this.meatPrice;
    }
}
    public double getMeatPrice(boolean extraMeat) {
        if (extraMeat) {
            switch (Size.getSizeType()) {
                case "4":
                    for (Meats meats: createMeatsList(Size.getSizeType())) {
                        return meats.meatPrice += 0.5;
                    }
                    break;
                case "8":
                    for (Meats meats: createMeatsList(Size.getSizeType())) {
                        return meats.meatPrice += 1.0;
                    }
                    break;
                case "12":
                    for (Meats meats: createMeatsList(Size.getSizeType())) {
                        return meats.meatPrice += 1.5;
                    }
                    break;
            }
        }
        return meatPrice;
    }

    public static ArrayList<Meats> createMeatsList(String size) {
        ArrayList<Meats> meatsList = new ArrayList<>();

        meatsList.add(new Meats("steak",size, 0));
        meatsList.add(new Meats("ham", size, 0));
        meatsList.add(new Meats("salami", size, 0));
        meatsList.add(new Meats("roast beef", size, 0));
        meatsList.add(new Meats("chicken", size, 0));
        meatsList.add(new Meats("bacon", size, 0));
        return meatsList;
    }
}
