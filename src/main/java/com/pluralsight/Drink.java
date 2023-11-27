package com.pluralsight;
public class Drink {
    private String drinkType;
    private Size size;

    public Drink(String drinkType, Size size) {
        this.drinkType = drinkType;
        this.size = size;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice(Size size) {
        return 0;
    }
}
