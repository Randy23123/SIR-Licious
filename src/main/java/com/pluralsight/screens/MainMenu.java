package com.pluralsight.screens;

import java.util.Scanner;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static void homeScreen() {

        String homeScreen;
        do {
            System.out.println("\nWelcome to SIR-Licious");
            System.out.println("Home Screen");
            System.out.println("\t1)New Order");
            System.out.println("\t0)Exit");
            System.out.print("Select a choice: ");
            homeScreen = scanner.next();
            scanner.nextLine();

            switch (homeScreen) {
                case "1":
                    OrderMenu orderMenu = new OrderMenu();

                    orderMenu.displayMenu();
                    break;
                case "0":
                    System.out.println("You have exited application :)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not an option pick (0-1)\n");
            }
        }
        while (homeScreen.equals("0"));
    }
}