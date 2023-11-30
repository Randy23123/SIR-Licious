package com.pluralsight.sandwich;

import com.pluralsight.sandwich.toppings.Toppings;

import java.util.List;

public class Sandwich {
    private final Bread bread;
    private final List<Toppings> toppings;
    private final boolean toasted;

    public Sandwich(Bread bread, List<Toppings> toppings, boolean toasted) {
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    public void addTopping(Toppings topping) {

        this.toppings.add(topping);
    }

    public void removeTopping(Toppings topping) {
        toppings.removeIf(t -> t.equals(topping));
    }


    public double getSandwichPricePrice(String sizeType) {
        double sandwichPrice = 0;
         switch (sizeType) {
            case "4" -> sandwichPrice = 5.50;
            case "8" -> sandwichPrice = 7.00;
            case "12" -> sandwichPrice = 8.50;
        };
         return sandwichPrice;
    }


    public double calculatePrice() {
        double totalPrice = getSandwichPricePrice(Size.getSizeType());
        for (Toppings t: toppings) {
            totalPrice += t.getPrice();
        }
        return totalPrice;
    }

    public Bread getBread() {
        return bread;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread=" + bread +
                ", toppings=" + toppings +
                ", toasted=" + toasted +
                '}';
    }

}