package com.pluralsight.sandwich.toppings;

import java.util.ArrayList;
import java.util.List;

public class RegularToppings implements Toppings {
    private final String name;
    private final double price;

    public RegularToppings(String name) {
        this.name = name;
        this.price = 0.00;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public static List<RegularToppings> createVegetablesList() {
        List<RegularToppings> vegetablesList = new ArrayList<>();
        vegetablesList.add(new RegularToppings("lettuce"));
        vegetablesList.add(new RegularToppings("peppers"));
        vegetablesList.add(new RegularToppings("onions"));
        vegetablesList.add(new RegularToppings("tomatoes"));
        vegetablesList.add(new RegularToppings("jalapenos"));
        vegetablesList.add(new RegularToppings("cucumbers"));
        vegetablesList.add(new RegularToppings("pickles"));
        vegetablesList.add(new RegularToppings("guacamole"));
        vegetablesList.add(new RegularToppings("mushrooms"));
        return vegetablesList;
    }

    public static List<RegularToppings> createSaucesList() {
        List<RegularToppings> saucesList = new ArrayList<>();
        saucesList.add(new RegularToppings("mayo"));
        saucesList.add(new RegularToppings("mustard"));
        saucesList.add(new RegularToppings("ketchup"));
        saucesList.add(new RegularToppings("ranch"));
        saucesList.add(new RegularToppings("thousand islands"));
        saucesList.add(new RegularToppings("vinaigrette"));
        return saucesList;
    }

    public static List<RegularToppings> createSidesList() {
        List<RegularToppings> sidesList = new ArrayList<>();
        sidesList.add(new RegularToppings("au jus"));
        sidesList.add(new RegularToppings("sauce"));
        return sidesList;
    }
}
