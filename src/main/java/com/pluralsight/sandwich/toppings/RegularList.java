package com.pluralsight.sandwich.toppings;

import java.util.ArrayList;
import java.util.List;

public class RegularList extends RegularToppings {

    public RegularList(String name) {
        super(name);
    }

    public static List<RegularList> createVegetablesList() {
        List<RegularList> vegetablesList = new ArrayList<>();
        vegetablesList.add(new RegularList("lettuce"));
        vegetablesList.add(new RegularList("peppers"));
        vegetablesList.add(new RegularList("onions"));
        vegetablesList.add(new RegularList("tomatoes"));
        vegetablesList.add(new RegularList("jalapenos"));
        vegetablesList.add(new RegularList("cucumbers"));
        vegetablesList.add(new RegularList("pickles"));
        vegetablesList.add(new RegularList("guacamole"));
        vegetablesList.add(new RegularList("mushrooms"));
        return vegetablesList;
    }

    public static List<RegularList> createSaucesList() {
        List<RegularList> saucesList = new ArrayList<>();
        saucesList.add(new RegularList("mayo"));
        saucesList.add(new RegularList("mustard"));
        saucesList.add(new RegularList("ketchup"));
        saucesList.add(new RegularList("ranch"));
        saucesList.add(new RegularList("thousand islands"));
        saucesList.add(new RegularList("vinaigrette"));
        return saucesList;
    }

    public static List<RegularList> createSidesList() {
        List<RegularList> sidesList = new ArrayList<>();
        sidesList.add(new RegularList("au jus"));
        sidesList.add(new RegularList("sauce"));
        return sidesList;
    }
}


