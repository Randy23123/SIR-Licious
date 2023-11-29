package com.pluralsight.screens;

import com.pluralsight.screens.support.CheckOut;
import com.pluralsight.screens.support.Order;
import com.pluralsight.combo.Chips;
import com.pluralsight.combo.Drink;
import com.pluralsight.sandwich.Bread;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.Size;
import com.pluralsight.sandwich.toppings.Cheese;
import com.pluralsight.sandwich.toppings.Meats;
import com.pluralsight.sandwich.toppings.Toppings;

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
        String customerName;
        int id = 12514;

        System.out.println("Can I have a name for your order?");
        customerName = scan.nextLine();
        do {

            System.out.println("""
                    \nOrder Menu Screen:
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
                    addSandwich(scan, customerName, id);
                    break;
                case 2:
                    addDrinks(scan, customerName, id);
                    break;
                case 3:
                    addChips(scan, customerName, id);
                    break;
                case 4:
                    new CheckOut();
                    break;
                case 5:
                    cancelOrder();
                    break;
                default:
                    System.out.println("Invalid Option... Please enter a valid orderOption.");
            }
        } while (orderOption != 5);
    }

    private void addSandwich(Scanner scan, String customerName, int id) {
        List<Toppings> toppingsList = new ArrayList<>();
        // Display the options for customizing the sandwich
        System.out.println("Customize your sandwich:");
        System.out.println("1. Choose bread type");
        System.out.println("\t1. White");
        System.out.println("\t2. Wheat");
        System.out.println("\t3. Rye");
        System.out.println("\t4. Wrap");

        int choice = getIntInput(scan, 1, 3);
        Bread selectedBread = null;

        /* pass the chosen options */
        switch (choice) {
            case 1 -> selectedBread = new Bread("White");
            case 2 -> selectedBread = new Bread("Wheat");
            case 3 -> selectedBread = new Bread("Rye");
            case 4 -> selectedBread = new Bread("Wrap");
        };
        System.out.println("2. Choose sandwich size");
        System.out.println("\t1. 4 inches");
        System.out.println("\t2. 8 inches");
        System.out.println("\t3. 12 inches");
        int sizeChoice = getIntInput(scan, 1, 3);

        /* pass the chosen options */
        switch (sizeChoice) {
            case 1 -> new Size("4");
            case 2 -> new Size("8");
            case 3 -> new Size("12");
        };
        System.out.println("\n****** Choose your meat ******");

        List<Meats> meatsList = Meats.createMeatsList(Size.getSizeType());
        int index = 1;
        for (Meats meats : meatsList) {
            System.out.println(index + " " + meats.getName() + " - Price: $" + meats.getMeatPrice());
            index++;
        }
        System.out.println("Select the meat you would like (Enter 0 to finish):");

        int choiceMeat =  getIntInput(scan, 0, meatsList.size());

        if (choiceMeat == 0) {
            // User chose to finish
            return;
        }

        // Get the selected meat from the list
        Meats selectedMeats = meatsList.get(choiceMeat - 1);

        toppingsList.add(selectedMeats);

        System.out.println("Would you like to add extra meat (Yes / NO)?");
        String input = scan.next().trim().toLowerCase();
       if (input.equals("yes")) {
           int count1 = 1;
           for (Meats meats : meatsList) {
               System.out.println(count1 + " " + meats.getName() + " - Price: $" + meats.getMeatPrice(true));
               count1++;
           }

           System.out.println("Select the extra meat you would like (Enter 0 to finish):");

           int choiceExtraMeat =  getIntInput(scan, 0, meatsList.size());

           if (choiceExtraMeat == 0) {
               // User chose to finish
               return;
           }
               // Get the selected meat from the list
               Meats selectedExtraMeats = meatsList.get(meatsList.size()  - 1);

               toppingsList.add(selectedExtraMeats);
       }




        System.out.println("\n****** Add cheese ******");

        List<Cheese> cheeseList = Cheese.createCheeseList(Size.getSizeType());
        int count = 1;
        for (Cheese cheese : cheeseList) {
            System.out.println(count + " " + cheese.getName() + " - Price: $" + cheese.getCheesePrice());
            count++;
        }
        System.out.println("Select the cheese you would like (Enter 0 to finish):");

         getIntInput(scan, 0, cheeseList.size());

        // Get the selected meat from the list
        Cheese selectedCheese = cheeseList.get(cheeseList.size() - 1);

        toppingsList.add(selectedCheese);

        System.out.println("Would you like to add extra cheese (Yes / NO)?");
        String inputCheese = scan.next().trim().toLowerCase();
        if (inputCheese.equals("yes")) {
            int counter = 1;
            for (Cheese cheese : cheeseList) {
                System.out.println(counter + " " + cheese.getName() + " - Price: $" + cheese.getCheesePrice(true));
                counter++;
            }

            System.out.println("Select the extra cheese you would like (Enter 0 to finish):");

            getIntInput(scan, 0, cheeseList.size());

                // Get the selected meat from the list
            Cheese selectedExtraCheese = cheeseList.get(cheeseList.size() - 1);

            toppingsList.add(selectedExtraCheese);
        }



        System.out.println("\n****** Toast the sandwich ******");

        System.out.println("Would you like your sandwich toasted? (Yes / No): ");
        String inputToast = scan.next().trim().toLowerCase();
        boolean toast = inputToast.equals("yes");


        // Once the sandwich is customized, create a Sandwich object
        Sandwich sandwich = new Sandwich(selectedBread,toppingsList, toast );

        // Create a List<Sandwich> to hold the sandwich in the order
        List<Sandwich> sandwichesList = new ArrayList<>();
        sandwichesList.add(sandwich);

        // Create an Order<Sandwich> instance
        Order<Sandwich> order = new Order<>(id, customerName, sandwichesList);

        System.out.println("Sandwich successfully added to your order!");
    }



    private void addDrinks(Scanner scan, String customerName, int id) {
        ArrayList<Drink> drinkArrayList = Drink.createDrinkList();

        System.out.println("Please select a size: ");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        int input = scan.nextInt();
        scan.nextLine();
        String size;
        switch (input) {
            case 1 -> size = "small";
            case 2 -> size = "medium";
            case 3 -> size = "large";
        }
            // Display the list of drinks
            int index = 1;
            for (Drink drink : drinkArrayList) {
                System.out.println(index + " " + drink.getDrinkType() + " - Price: $" + drink.getPrice("Medium"));
                index++;
            }

            System.out.println("Select the number of the drink you would like (Enter 0 to finish):");

            int choice = getIntInput(scan, 0, drinkArrayList.size());

            if (choice == 0) {
                // User chose to finish
                return;
            }

            // Get the selected drink from the list
            Drink selectedDrink = drinkArrayList.get(choice - 1);

            // Create a drink object based on the selected chip
            Drink drinkToAdd = new Drink(selectedDrink.getDrinkType(), selectedDrink.getDrinkType());

            // Create a List<Chips> to hold the chip in the order
            List<Drink> drinksList = new ArrayList<>();
            drinksList.add(drinkToAdd);

            // Create an Order<Chips> instance
            Order<Drink> order = new Order<>(id, customerName, drinksList);

            System.out.println("Added " + drinkToAdd.getDrinkType() + " to your order!");
        }

        private void addChips (Scanner scan, String customerName,int id){
            ArrayList<Chips> chipArrayList = Chips.createChipList();

            // Display the list of chips
            int index = 1;
            for (Chips chip : chipArrayList) {
                System.out.println(index + " " + chip.getChipType() + " - Price: $" + chip.getPrice());
                index++;
            }

            System.out.println("Select the number of the chip you would like (Enter 0 to finish):");

            int choice = getIntInput(scan, 0, chipArrayList.size());

            if (choice == 0) {
                // User chose to finish
                return;
            }

            // Get the selected chip from the list
            Chips selectedChip = chipArrayList.get(choice - 1);

            // Create a Chip object based on the selected chip
            Chips chipToAdd = new Chips(selectedChip.getChipType(), selectedChip.getPrice());

            // Create a List<Chips> to hold the chip in the order
            List<Chips> chipsList = new ArrayList<>();
            chipsList.add(chipToAdd);

            // Create an Order<Chips> instance
            Order<Chips> order = new Order<>(id, customerName, chipsList);

            System.out.println("Added " + chipToAdd.getChipType() + " to your order!");
        }


        private int getIntInput (Scanner scanner,int min, int max){
            int choice;
            do {
                System.out.print("Enter your choice: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // consume non-integer input
                }
                choice = scanner.nextInt();
            } while (choice < min || choice > max);

            return choice;
        }

        private void cancelOrder () {
            orderEntries.clear();
            System.out.println("Canceling order... directing to Main Menu");
        }
    }
