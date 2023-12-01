package com.pluralsight.screens.support;
import com.pluralsight.combo.Chips;
import com.pluralsight.combo.Drink;
import com.pluralsight.sandwich.Sandwich;

import java.util.List;

// The generic class Order that represents a customer's order
public class Order<T> {
    private final int orderID;        // Unique identifier for the order
    private final String customerName;// Name of the customer placing the order
    private final List<T> items;      // List of items in the order (generic)

    // Constructor to initialize the Order object
    public Order(int orderID, String customerName, List<T> items) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.items = items;
    }

    // Getter method to retrieve the list of items in the order
    public List<T> getItems() {
        return items;
    }

    // Getter method to retrieve the order ID
    public int getOrderID() {
        return orderID;
    }

    // Getter method to retrieve the customer's name
    public String getCustomerName() {
        return customerName;
    }

    // Method to calculate the total price of the order
    public double calculateTotalPrice() {
        double total = 0;

        // Iterate through each item in the order and calculate its price
        for (T item : items) {
            if (item instanceof Sandwich) {
                total += ((Sandwich) item).calculatePrice();
            } else if (item instanceof Drink) {
                total += calculateDrinkPrice((Drink) item);
            } else if (item instanceof Chips) {
                total += calculateChipPrice((Chips) item);
            }
        }

        return total;
    }

    // Private method to calculate the price of a chip item
    private double calculateChipPrice(Chips chip) {
        return chip.getPrice();
    }

    // Private method to calculate the price of a drink item
    private double calculateDrinkPrice(Drink drink) {

        // Adjust the base price based on the size of the drink
        return switch (drink.getSize().toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> throw new IllegalStateException("Unexpected value: " + drink.getSize().toLowerCase());
        };
    }
}

