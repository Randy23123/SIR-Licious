package com.pluralsight.screens.support;
import com.pluralsight.combo.Chips;
import com.pluralsight.combo.Drink;
import com.pluralsight.sandwich.Sandwich;

import java.util.List;


public class Order<T> {
    private final int orderID;
    private final String customerName;
    private final List<T> items;

    public Order(int orderID, String customerName, List<T> items) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.items = items;
    }

    public double calculateTotalPrice() {
        double total = 0;

        for (T item : items) {
            if (item instanceof Sandwich) {
                total += ((Sandwich) item).calculatePrice();
                System.out.println("Inside of Order "+total);
            } else if (item instanceof Drink) {
                total += calculateDrinkPrice((Drink) item);
            } else if (item instanceof Chips) {
                total += calculateChipPrice((Chips) item);
            }
        }

        return total;
    }

    private double calculateChipPrice(Chips chip) {
        return chip.getPrice();
    }

    private double calculateDrinkPrice(Drink drink) {

        // Adjust the base price based on the size of the drink
        return switch (drink.getSize().toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default ->
                    throw new IllegalStateException("Unexpected value: " + drink.getSize().toLowerCase());
        };
    }

    public List<T> getItems() {
        return items;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getCustomerName() {
        return customerName;
    }
}