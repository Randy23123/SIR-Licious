package com.pluralsight.combo;

import java.util.ArrayList;

public class Drink{
    private String drinkType;
    private String size;

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

    public double getPrice() {
       return switch (size) {
           case "small" -> 2.00;
           case "medium" -> 2.50;
           case "large" -> 3.00;
           default -> throw new IllegalStateException("Unexpected value: " + size);
       };
    }

    public static ArrayList<Drink> createDrinkList() {
        ArrayList<Drink> drinkArrayList = new ArrayList<>();

        drinkArrayList.add(new Drink("Pepsi", "medium"));
        drinkArrayList.add(new Drink("Coca-Cola", "medium"));
        drinkArrayList.add(new Drink("Sprite", "medium"));
        drinkArrayList.add(new Drink("Dr. Pepper", "medium"));
        drinkArrayList.add(new Drink("Mountain Dew", "medium"));
        drinkArrayList.add(new Drink("Iced Tea", "medium"));
        drinkArrayList.add(new Drink("Lemonade", "medium"));

        return drinkArrayList;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkType='" + drinkType + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public double getPrice(String size) {
            return switch (size) {
                case "small" -> 2.00;
                case "medium" -> 2.50;
                case "large" -> 3.00;
                default -> throw new IllegalStateException("Unexpected value: " + size);
            };
    }
}
