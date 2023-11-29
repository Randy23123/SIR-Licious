package com.pluralsight.screens.support;

import com.pluralsight.combo.Chips;
import com.pluralsight.combo.Drink;
import com.pluralsight.sandwich.Bread;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.toppings.Cheese;
import com.pluralsight.sandwich.toppings.RegularToppings;
import com.pluralsight.sandwich.toppings.Toppings;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    private static String getSandwichOrder(Sandwich sandwich) {
        String deliOrder = "Bread Type: " + sandwich.getBread().getBreadType() + "\n" +
                "Toppings: " + getToppingInformation(sandwich.getToppings()) + "\n" +
                "Toasted: " + sandwich.isToasted() + "\n";
        return "Sandwich Details:\n" + deliOrder;

    }

    private static String getToppingInformation(List<Toppings> toppings) {
        StringBuilder toppingInformation = new StringBuilder();
        for (Toppings topping : toppings) {
            toppingInformation.append("\t- ").append(topping.getName()).append("\n");
        }
        return toppingInformation.toString();
    }

    private static String getDrinkOrder(Drink drink) {
        return "Drink: " + drink.getDrinkType() + " | Size: " + drink.getSize() + "\n";
    }

    private static String getChipsOrder(Chips chips) {
        return "Chips: " + chips.getChipType() + " | Price: $" + chips.getPrice() + "\n";
    }

    public Order<?> LoadingOrder(String fileName) throws FileNotFoundException {
        try (BufferedReader read =  new BufferedReader(new FileReader(fileName))) {
            String line;
            int orderID = 0;
            String customerName = "";
            List<Object> items = new ArrayList<>(); //Subject to change

            while ((line = read.readLine()) != null) {
                String[] parts = line.split(":");
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "OrderID":
                        orderID = Integer.parseInt(value);
                        break;
                    case "CustomerName":
                        customerName = value;
                        break;
                    case "Sandwich":
                        items.add(parseSandwich(value));
                        break;
                    case "Drink":
                        items.add(parseDrink(value));
                        break;
                    case "Chips":
                        items.add(parseChips(value));
                        break;
                }
            }
            return new Order<Object>(orderID, customerName, items);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Sandwich parseSandwich(String value) {
        String[] parts = value.split(" | ");
        Bread bread = null;
        List<Toppings> toppings = new ArrayList<>();
        boolean toasted =  false;

        for (String part : parts) {
            String[] pair = part.split(": ");
            String key = pair[0].trim();
            String values = pair[1].trim();

            switch (key) {
                case "Bread":
                    bread = new Bread(values);
                    break;
                case "Toppings":
                    String[] toppingsList = values.split(" | ");
                    for (String topping : toppingsList) {
                        toppings.add(new RegularToppings(topping, "Regular", null)); // instance of RegularList?
                    }
                    break;
                case "Cheese":
                    toppings.add(new Cheese(values, "Regular", 0.0));
                    break;
                case "Toasted":
                    toasted = Boolean.parseBoolean(values);
                    break;
            }
        }
        return new Sandwich(bread, toppings, toasted);
    }

    private Drink parseDrink(String value) {
        String[] parts = value.split(" | ");
        String type = null;
        String size = null;

        for (String part : parts) {
            String[] pair = part.split(": ");
            String key = pair[0].trim();
            String values = pair[1].trim();

            switch (key) {
                case "Type":
                    type = values;
                    break;
                case "Size":
                    size = values;
                    break;
            }
        }
        return new Drink(type, size);
    }

    private Chips parseChips(String value) {
        String[] parts = value.split(" | ");
        String type = null;
        double price = 0.0;

        for (String part : parts) {
            String[] pair = part.split(": ");
            String key = pair[0].trim();
            String values = pair[1].trim();

            switch (key) {
                case "Type":
                    type = values;
                    break;
                case "Price":
                    price = Double.parseDouble(values);
            }
        }
        return new Chips(type, price);
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