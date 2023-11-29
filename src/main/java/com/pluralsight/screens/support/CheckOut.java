package com.pluralsight.screens.support;

import com.pluralsight.combo.Chips;
import com.pluralsight.combo.Drink;
import com.pluralsight.sandwich.Sandwich;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckOut {
    public static void saveOrderEntry(Order<?> order) {
        File receiptsFolder = new File("receipts");
        if (!receiptsFolder.exists()) {
            boolean createNew = receiptsFolder.mkdir();
            if (!createNew) {
                System.out.println("Folder Creation Failed");
                return;
            }
        }

        String fileName = fileNameFormat();
        String orderInformation = getOrderDetails(order);
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName))) {
            if (orderInformation != null) {
                write.write(orderInformation);
            }
            System.out.println("Order successfully saved under " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String fileNameFormat() {
        LocalDateTime present = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return "receipts/" + present.format(formatDate) + ".txt";
    }

    private static String getOrderDetails(Order<?> order) {
        StringBuilder details = new StringBuilder();
        details.append("Order ID: ").append(order.getOrderID()).append("\n");
        details.append("Customer Name: ").append(order.getCustomerName()).append("\n");
        details.append("Items Ordered:\n");
        List<?> items =  order.getItems();

        for (Object item : items) {
            if (item instanceof Sandwich) {
                details.append(getSandwichOrder((Sandwich) item));
            } else if (item instanceof Drink) {
                details.append(getDrinkOrder((Drink) item));
            } else if (item instanceof Chips) {
                details.append(getChipsOrder((Chips) item));
            }
        }
        details.append("Order Total Cost: $").append(order.calculateTotalPrice()).append("\n");

        return details.toString();
    }

    private String getSandwichOrder(Sandwich sandwich) {
        StringBuilder sandwichOrder = new StringBuilder();
        sandwichOrder.append("Bread Type: ").append(sandwich.getBread()) // Will pick-up here Wednesday...
    }
}



//    private ArrayList<String> items;
//    private double totalPrice;
//
//
//    public CheckOut(ArrayList<String> items, double totalPrice) {
//        this.items = items;
//        this.totalPrice = totalPrice;
//    }
//
//    public ArrayList<String> getItems() {
//        return items;
//    }
//
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void receipt() throws IOException {
//        LocalDateTime time = LocalDateTime.now();
//        String file = "receipt_" + time + ".txt";
//
//        try(FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
//            bufferedWriter.write("Order Details:\n");
//            bufferedWriter.write("Items:\n");
//            for (String item : items) {
//                bufferedWriter.write("- " + item + "\n");
//            }
//            bufferedWriter.write("Total Price: $" + totalPrice + "\n");
//
//            System.out.println("Order receipt saved to " + file);
//            items.clear();
//            totalPrice = 0.0;
//        }
//    }