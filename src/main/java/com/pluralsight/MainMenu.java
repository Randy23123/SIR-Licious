package com.pluralsight;

import java.util.Scanner;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static void homeScreen() {

        String homeScreen;
        do {
            System.out.println("\nHome Screen");
            System.out.println("1)New Order");
            System.out.println("0)Exit");
            homeScreen = scanner.next();
            scanner.nextLine();

            switch (homeScreen) {
                case "1":

                    break;
                case "0":
                    System.out.println("You have exited application :)");
                    break;
                default:
                    System.out.println("Not an option pick (0-1)\n");
            }
        }
        while (!homeScreen.equals("0"));
    }
}