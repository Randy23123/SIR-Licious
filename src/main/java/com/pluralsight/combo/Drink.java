package com.pluralsight.combo;

import java.util.ArrayList;

public class Drink {
    private final String drinkType;
    private String size;

    public Drink(String drinkType) {
        this.drinkType = drinkType;
    }

    public Drink( String drinkType,  String size) {
        this.drinkType = drinkType;
        this.size = size;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public String getSize() {
        return size;
    }

    public double getPrice(String size) {
       return switch (size) {
           case "small" -> 2.00;
           case "medium" -> 2.50;
           case "large" -> 3.00;
           default -> throw new IllegalStateException("Unexpected value: " + size);
       };
    }

    public static ArrayList<Drink> createDrinkList() {
        ArrayList<Drink> drinkArrayList = new ArrayList<>();

        drinkArrayList.add(new Drink("Pepsi"));
        drinkArrayList.add(new Drink("Coca-Cola"));
        drinkArrayList.add(new Drink("Sprite"));
        drinkArrayList.add(new Drink("Dr. Pepper"));
        drinkArrayList.add(new Drink("Mountain Dew"));
        drinkArrayList.add(new Drink("Iced Tea"));
        drinkArrayList.add(new Drink("Lemonade"));

        return drinkArrayList;
    }
}
