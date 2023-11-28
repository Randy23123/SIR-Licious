package com.pluralsight;
import java.util.List;


public class Order<T> {
    private int orderID;
    private String customerName;
    private List<T> items;

    public Order(int orderID, String customerName, List<T> items) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.items = items;
    }

    public double calculateTotalPrice() {
        return 0;
    }

    public void displayOrderDetails() {
    }
}