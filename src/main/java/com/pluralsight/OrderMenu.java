package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMenu {
    // Store orders
    private List<String> orderEntries;

    public OrderMenu() {
        orderEntries = new ArrayList<>();
    }

    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        int orderOption;

        do {
            System.out.println("""
                    Order Menu Screen:
                    1. Add Sandwich
                    2. Add Drink
                    3. Add Chips
                    4. Checkout
                    5. Cancel Order
                    
                    Please enter your choice (#):\s""");
            orderOption = scan.nextInt();
            scan.nextLine();

            switch (orderOption) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrinks();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    break;
                case 0:
                    cancelOrder();
                    break;
                default:
                    System.out.println("Invalid Option... Please enter a valid orderOption.");
            }
        } while (orderOption != 0);
    }

    private void addSandwich() {
//        More to be added...
        System.out.println("Sandwich successfully added to order...");
    }

    private void addDrinks() {
//        More to be added...
        System.out.println("Drink successfully added to order...");
    }

    private void addChips() {
//        More to be added...
        System.out.println("Chips successfully added to order...");
    }

    private void checkout() {
//        More to be added...
        System.out.println("Checking out...");
    }

    private void cancelOrder() {
        orderEntries.clear();
        System.out.println("Canceling order... directing to Main Menu");
    }
}

//  For "Main" class
//    private static void main(String[] args) {
//        OrderMenu orderMenu = new OrderMenu();
//        orderMenu.displayMenu();
//    }