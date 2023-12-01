package com.pluralsight.screens.support;

import com.pluralsight.combo.*;
import com.pluralsight.sandwich.*;
import com.pluralsight.sandwich.toppings.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CheckOut {
private static double total = 0.00;
    public static void saveOrderEntry(Order<?> order) {
        CheckOut checkOut = new CheckOut();
        File receiptsFolder = new File("src/main/resources/receipts");
        if (!receiptsFolder.exists()) {
            boolean createNew = receiptsFolder.mkdir();
            if (!createNew) {
                System.out.println("Folder Creation Failed");
                return;
            }
        }

        String fileName = fileNameFormat();
        String orderInformation = checkOut.getOrderDetails(order);
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName, true))) {
            write.write(getCustomerDetails(order));
            write.write(orderInformation);
            write.write(getTotalOder(order));
            System.out.println("Order successfully saved under " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String fileNameFormat() {
        LocalDateTime present = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return "src/main/resources/receipts/" + present.format(formatDate) + ".txt";
    }

    private static String getSandwichOrderDetails(Sandwich sandwich) {
        return String.format("%-20s %-12d $%-15.2f $%.2f\n", "Sandwich", 1, sandwich.calculatePrice(), sandwich.calculatePrice());
    }

    private static String getDrinkOrderDetails(Drink drink) {
        return String.format("%-20s %-12d $%-15.2f $%.2f\n", "Drink", 1, drink.getPrice(drink.getSize()), drink.getPrice(drink.getSize()));
    }

    private static String getChipsOrderDetails(Chips chips) {
        return String.format("%-20s %-12d $%-15.2f $%.2f\n", "Chips", 1, chips.getPrice(), chips.getPrice());
    }

    private static String getCustomerDetails(Order<?> order) {
        StringBuilder details = new StringBuilder();

        List<?> items = order.getItems();

        for (Object item : items) {
            if (item instanceof Sandwich) {
                // Header
                details.append("========================================\n");
                details.append("              RECEIPT\n");
                details.append("========================================\n\n");
                // Receipt ID and Date
                details.append("Receipt ID: #").append(order.getOrderID()).append("\n");
                details.append("Date: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"))).append("\n\n");

                // Customer Information
                details.append("----------------------------------------\n");
                details.append("Customer Information:\n");
                details.append("Name: ").append(order.getCustomerName()).append("\n");
                details.append("----------------------------------------\n\n");
            }
        }

        return details.toString();
    }

    private String getOrderDetails(Order<?> order) {
        StringBuilder details = new StringBuilder();

        // Header, Receipt ID, Date, and Customer Information - unchanged

        // Order Details
        details.append("Order Details:\n\n");
        details.append(String.format("%-20s %-12s %-16s %s\n", "Item", "Quantity", "Unit Price", "Subtotal"));
        details.append("--------------------------------------------------------\n");

        List<?> items = order.getItems();

        for (Object item : items) {
            if (item instanceof Sandwich sandwich) {
                details.append(getSandwichOrderDetails(sandwich));
                details.append(getToppingInformation(sandwich.getToppings()));
                total += order.calculateTotalPrice();
            } else if (item instanceof Drink drink) {
                details.append(getDrinkOrderDetails(drink));
                total += order.calculateTotalPrice();
            } else if (item instanceof Chips chips) {
                details.append(getChipsOrderDetails(chips));
                total += order.calculateTotalPrice();
            }
        }
        return details.toString();
    }


    private static String getTotalOder(Order<?> order) {
        StringBuilder details = new StringBuilder();

        List<?> items = order.getItems();

        for (Object item : items) {
            if (item instanceof Chips) {

                details.append("--------------------------------------------------------\n");
                details.append(String.format("%46s $%.2f\n", "Subtotal:", total));
                details.append(String.format("%46s $%.2f\n", "Tax (8%):", total * 0.08));
                total +=  (total * 0.08); // adds the taxes to the total
                details.append(String.format("%46s $%.2f\n\n", "Total:", total));

                // Payment Information
                details.append("----------------------------------------\n");
                details.append("Payment Information:\n");
                details.append("\n");

                // Footer
                details.append("========================================\n\n");
                details.append("Thank you for your purchase!\n");
                details.append("Please contact us if you have any questions.\n\n");
                details.append("========================================\n");
            }
        }

        return details.toString();
    }

    private static String getToppingInformation(List<Toppings> toppings) {
        StringBuilder toppingInformation = new StringBuilder();
        for (Toppings topping : toppings) {
            toppingInformation.append("\t- ").append(topping.getName()).append("\n");
        }
        return toppingInformation.toString();
    }
}
