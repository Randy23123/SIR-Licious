package com.pluralsight;
import java.util.List;

public class Order {
    private int orderID;
    private String customerName;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order(int orderID, String customerName, List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public double calculateTotalPrice() {
        return 0;
    }

    public void displayOrderDetails() {
    }
}