package com.pluralsight.sandwich.toppings;

import com.pluralsight.sandwich.Bread;

import java.util.ArrayList;

public class PremiumToppings extends Bread implements Toppings {
    private final String name;
    private final double basePrice;
    private final double extraPrice;

    public PremiumToppings(String name, String breadType, String sizeType, double basePrice, double extraPrice) {
        super(breadType, sizeType);
        this.name = name;
        this.basePrice = basePrice;
        this.extraPrice = extraPrice;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public double getBasePrice() {
        return this.basePrice;
    }


    public double getExtraPrice() {
        return this.extraPrice;
    }

    public double getTotalPrice() {
        return this.basePrice + this.extraPrice;
    }

    @Override
    public double getPrice() {
        return this.getTotalPrice();
    }

    public static ArrayList<PremiumToppings> createMeatsList(String breadType, String sizeType) {
        ArrayList<PremiumToppings> meatsList = new ArrayList<>();

        switch (sizeType) {
            case "4":
                meatsList.add(new PremiumToppings("steak", breadType, sizeType, 1.0, 0.5));
                meatsList.add(new PremiumToppings("ham", breadType, sizeType, 1.0, 0.5));
                meatsList.add(new PremiumToppings("salami", breadType, sizeType, 1.0, 0.5));
                meatsList.add(new PremiumToppings("roast beef", breadType, sizeType, 1.0, 0.5));
                meatsList.add(new PremiumToppings("chicken", breadType, sizeType, 1.0, 0.5));
                meatsList.add(new PremiumToppings("bacon", breadType, sizeType, 1.0, 0.5));
                break;
            case "8":
                meatsList.add(new PremiumToppings("steak", breadType, sizeType, 2.0, 1.0));
                meatsList.add(new PremiumToppings("ham", breadType, sizeType, 2.0, 1.0));
                meatsList.add(new PremiumToppings("salami", breadType, sizeType, 2.0, 1.0));
                meatsList.add(new PremiumToppings("roast beef", breadType, sizeType, 2.0, 1.0));
                meatsList.add(new PremiumToppings("chicken", breadType, sizeType, 2.0, 1.0));
                meatsList.add(new PremiumToppings("bacon", breadType, sizeType, 2.0, 1.0));
                break;
            case "12":
                meatsList.add(new PremiumToppings("steak", breadType, sizeType, 3.0, 1.5));
                meatsList.add(new PremiumToppings("ham", breadType, sizeType, 3.0, 1.5));
                meatsList.add(new PremiumToppings("salami", breadType, sizeType, 3.0, 1.5));
                meatsList.add(new PremiumToppings("roast beef", breadType, sizeType, 3.0, 1.5));
                meatsList.add(new PremiumToppings("chicken", breadType, sizeType, 3.0, 1.5));
                meatsList.add(new PremiumToppings("bacon", breadType, sizeType, 3.0, 1.5));
                break;
            default:
                System.out.println("Error");
                break;
        }
        return meatsList;
    }

    public static ArrayList<PremiumToppings> createCheeseList(String breadType) {
        ArrayList<PremiumToppings> cheeseList = new ArrayList<>();

        switch (sizeType) {
            case "4":
                cheeseList.add(new PremiumToppings("cheddar", breadType, sizeType, 0.75, 0.30));
                cheeseList.add(new PremiumToppings("swiss", breadType, sizeType, 0.75, 0.30));
                cheeseList.add(new PremiumToppings("pepper jack", breadType, sizeType, 0.75, 0.30));
                cheeseList.add(new PremiumToppings("provolone", breadType, sizeType, 0.75, 0.30));
                cheeseList.add(new PremiumToppings("american", breadType, sizeType, 0.75, 0.30));
                break;
            case "8":
                cheeseList.add(new PremiumToppings("cheddar", breadType, sizeType, 1.50, 0.60));
                cheeseList.add(new PremiumToppings("swiss", breadType, sizeType, 1.50, 0.60));
                cheeseList.add(new PremiumToppings("pepper jack", breadType, sizeType, 1.50, 0.60));
                cheeseList.add(new PremiumToppings("provolone", breadType, sizeType, 1.50, 0.60));
                cheeseList.add(new PremiumToppings("american", breadType, sizeType, 1.50, 0.60));
                break;
            case "12":
                cheeseList.add(new PremiumToppings("cheddar", breadType, sizeType, 2.25,0.90));
                cheeseList.add(new PremiumToppings("swiss", breadType, sizeType, 2.25,0.90));
                cheeseList.add(new PremiumToppings("pepper jack", breadType, sizeType, 2.25,0.90));
                cheeseList.add(new PremiumToppings("provolone", breadType, sizeType, 2.25,0.90));
                cheeseList.add(new PremiumToppings("american", breadType, sizeType, 2.25,0.90));
                break;
            default:
                System.out.println("Error");
                break;
        }
        return cheeseList;
    }
}