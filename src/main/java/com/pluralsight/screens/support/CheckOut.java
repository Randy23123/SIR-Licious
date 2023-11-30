package com.pluralsight.screens.support;

import com.pluralsight.combo.*;
import com.pluralsight.sandwich.*;
import com.pluralsight.sandwich.toppings.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CheckOut {
    public static void saveOrderEntry(Order<?> order) {
        File receiptsFolder = new File("src/main/resources/receipts");
        if (!receiptsFolder.exists()) {
            boolean createNew = receiptsFolder.mkdir();
            if (!createNew) {
                System.out.println("Folder Creation Failed");
                return;
            }
        }

        String fileName = fileNameFormat();
        String orderInformation = getOrderDetails(order);
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName,true))) {
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
        return "src/main/resources/receipts/" + present.format(formatDate) + ".txt";
    }

    private static String getOrderDetails(Order<?> order) {
        StringBuilder details = new StringBuilder();
        details.append("Order ID: ").append(order.getOrderID()).append("\n");
        details.append("Customer Name: ").append(order.getCustomerName()).append("\n");
        details.append("Items Ordered:\n");
        List<?> items =  order.getItems();
        double total = 0.00;
        for (Object item : items) {
            if (item instanceof Sandwich) {
                details.append(getSandwichOrder((Sandwich) item));
            } else if (item instanceof Drink) {
                details.append(getDrinkOrder((Drink) item));
            } else if (item instanceof Chips) {
                details.append(getChipsOrder((Chips) item));
            }
        }

        total += order.calculateTotalPrice();

        details.append("Order Total Cost: $").append(total).append("\n");

        return details.toString();
    }

    private static String getSandwichOrder(Sandwich sandwich) {
        String deliOrder = "Bread Type: " + sandwich.getBread().getBreadType() + "\n" +
                "Toppings: \n" + getToppingInformation(sandwich.getToppings()) + "\n" +
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

//    public Order<?> LoadingOrder(String fileName) throws FileNotFoundException {
//        try (BufferedReader read =  new BufferedReader(new FileReader(fileName))) {
//            String line;
//            int orderID = 0;
//            String customerName = "";
//            List<Object> items = new ArrayList<>();
//
//            while ((line = read.readLine()) != null) {
//                String[] parts = line.split(":");
//                String key = parts[0].trim();
//                String value = parts[1].trim();
//
//                switch (key) {
//                    case "OrderID":
//                        orderID = Integer.parseInt(value);
//                        break;
//                    case "CustomerName":
//                        customerName = value;
//                        break;
//                    case "Sandwich":
//                        items.add(parseSandwich(value));
//                        break;
//                    case "Drink":
//                        items.add(parseDrink(value));
//                        break;
//                    case "Chips":
//                        items.add(parseChips(value));
//                        break;
//                }
//            }
//            return new Order<Object>(orderID, customerName, items);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private Sandwich parseSandwich(String value) {
//        String[] parts = value.split(" | ");
//        Bread bread = null;
//        List<Toppings> toppings = new ArrayList<>();
//        boolean toasted =  false;
//
//        for (String part : parts) {
//            String[] pair = part.split(": ");
//            String key = pair[0].trim();
//            String values = pair[1].trim();
//
//            switch (key) {
//                case "Bread":
//                    bread = new Bread(values);
//                    break;
//                case "Toppings":
//                    String[] toppingsList = values.split(" | ");
//                    for (String topping : toppingsList) {
//                        toppings.add(new RegularToppings(topping)); // instance of RegularList?
//                    }
//                    break;
//                case "Cheese":
//                    toppings.add(new Cheese(values, "Regular", 0.0));
//                    break;
//                case "Toasted":
//                    toasted = Boolean.parseBoolean(values);
//                    break;
//            }
//        }
//        return new Sandwich(bread, toppings, toasted);
//    }
//
//    private Drink parseDrink(String value) {
//        String[] parts = value.split(" | ");
//        String type = null;
//        String size = null;
//
//        for (String part : parts) {
//            String[] pair = part.split(": ");
//            String key = pair[0].trim();
//            String values = pair[1].trim();
//
//            switch (key) {
//                case "Type":
//                    type = values;
//                    break;
//                case "Size":
//                    size = values;
//                    break;
//            }
//        }
//        return new Drink(type, size);
//    }
//
//    private Chips parseChips(String value) {
//        String[] parts = value.split(" | ");
//        String type = null;
//        double price = 0.0;
//
//        for (String part : parts) {
//            String[] pair = part.split(": ");
//            String key = pair[0].trim();
//            String values = pair[1].trim();
//
//            switch (key) {
//                case "Type":
//                    type = values;
//                    break;
//                case "Price":
//                    price = Double.parseDouble(values);
//            }
//        }
//        return new Chips(type, price);
//    }
}