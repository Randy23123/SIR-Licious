package com.pluralsight.screens;

import com.pluralsight.combo.Chips;
import com.pluralsight.combo.Drink;
import com.pluralsight.sandwich.Bread;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.toppings.PremiumToppings;
import com.pluralsight.sandwich.toppings.RegularToppings;
import com.pluralsight.sandwich.toppings.Toppings;
import com.pluralsight.screens.support.CheckOut;
import com.pluralsight.screens.support.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OrderMenu {
    // Store orders
    //This syntax is a wildcard that represents an unknown type. It indicates that the Order class can have different types of items.
    private final List<Order<?>> orderEntries = new ArrayList<>();

    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        int orderOption;
        String customerName;
        Random random = new Random();

        System.out.println("Can I have a name for your order?");
        customerName = scan.nextLine();
        do {
            int id = random.nextInt(100000);
            System.out.println("""
                    \nOrder Menu Screen:
                    1. Add Sandwich
                    2. Add Drink
                    3. Add Chips
                    4. Checkout
                    5. Cancel Order
                    6. Go Back Home Screen
                                        
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
                    for (Order<?> order : orderEntries) {
                        CheckOut.saveOrderEntry(order);
                    }
                    break;
                case 5:
                    cancelOrder();
                    break;
                case 6:
                    MainMenu.homeScreen();
                    break;
                default:
                    System.out.println("Invalid Option... Please enter a valid orderOption.");
            }
        } while (orderOption != 5);
    }


    private void addSandwich(Scanner scan, String customerName, int id) {
        // Create a list to store the selected toppings for the sandwich
        List<Toppings> toppingsList = new ArrayList<>();

        // Choose the bread and size for the sandwich
        Bread bread = chooseBreadAndSize(scan);

        // Choose the meat for the sandwich
        chooseMeat(scan, toppingsList, bread);

        // Choose the cheese for the sandwich
        chooseCheese(scan, toppingsList);

        // Choose the vegetables for the sandwich
        chooseVegetables(scan, toppingsList);

        // Choose the sauces for the sandwich
        chooseSauces(scan, toppingsList);

        // Choose the sides for the sandwich
        chooseSides(scan, toppingsList);

        // Check if the customer wants the sandwich toasted
        boolean toasted = isToasted(scan);

        // Create the sandwich with the selected options and add it to the order
        createAndAddToOrder(customerName, id, toppingsList, bread, toasted);
    }

    // Check if the customer wants the sandwich toasted
    private boolean isToasted(Scanner scan) {
        System.out.println("\n****** Toast the sandwich ******");

        System.out.println("Would you like the sandwich toasted? (Yes / No): ");
        String inputToast = scan.next().trim().toLowerCase();
        return inputToast.equals("yes");
    }

    // Create the sandwich with the selected options and add it to the order
    private void createAndAddToOrder(String customerName, int id, List<Toppings> toppingsList, Bread selectedBread, boolean toasted) {
        Sandwich sandwich = new Sandwich(selectedBread, toppingsList, toasted);
        List<Sandwich> sandwichesList = new ArrayList<>();
        sandwichesList.add(sandwich);

        // Create an order with the sandwich and add it to the order entries
        Order<Sandwich> order = new Order<>(id, customerName, sandwichesList);
        orderEntries.add(order);
        System.out.println("Sandwich successfully added to your order!");
    }

    // Choose the sides for the sandwich
    private void chooseSides(Scanner scan, List<Toppings> toppingsList) {
        System.out.println("\n****** Choose your sides ******");

        // Create a list of available sides
        List<RegularToppings> sidesList = RegularToppings.createSidesList();
        List<RegularToppings> selectedSides = new ArrayList<>();

        // Allow the customer to select sides until they choose to finish
        do {
            System.out.println("\nAvailable Sides:");
            int index4 = 1;
            for (RegularToppings sides : sidesList) {
                System.out.println(index4 + " " + sides.getName());
                index4++;
            }

            System.out.println("Select the sides you would like (Enter 0 to finish): ");
            int choiceSides = getIntInput(scan, 0, sidesList.size());
            if (choiceSides == 0) {
                break;
            }
            RegularToppings chosenSides = sidesList.get(choiceSides - 1);
            selectedSides.add(chosenSides);
        } while (true);

        // Add the selected sides to the toppings list
        toppingsList.addAll(selectedSides);
    }

    // Choose the sauces for the sandwich
    private void chooseSauces(Scanner scan, List<Toppings> toppingsList) {
        System.out.println("\n****** Choose your sauces ******");

        // Create a list of available sauces
        List<RegularToppings> sauces = RegularToppings.createSaucesList();
        List<RegularToppings> selectedSauces = new ArrayList<>();

        // Allow the customer to select sauces until they choose to finish
        do {
            System.out.println("\nAvailable Sauces:");
            int index3 = 1;
            for (RegularToppings sauce : sauces) {
                System.out.println(index3 + " " + sauce.getName());
                index3++;
            }

            System.out.println("Select the sauces you would like (Enter 0 to finish): ");
            int choiceSauces = getIntInput(scan, 0, sauces.size());
            if (choiceSauces == 0) {
                break;
            }
            RegularToppings chosenSauce = sauces.get(choiceSauces - 1);
            selectedSauces.add(chosenSauce);
        } while (true);

        // Add the selected sauces to the toppings list
        toppingsList.addAll(selectedSauces);
    }


    // Method to allow the user to choose vegetables for the sandwich
    private void chooseVegetables(Scanner scan, List<Toppings> toppingsList) {
        System.out.println("\n****** Choose your vegetables ******");

        // Create a list of available vegetables
        List<RegularToppings> vegetables = RegularToppings.createVegetablesList();
        List<RegularToppings> selectedVegetables = new ArrayList<>();

        // Allow the user to select vegetables until they choose to finish
        do {
            System.out.println("\nAvailable Vegetables:");
            int index2 = 1;
            for (RegularToppings vegetable : vegetables) {
                System.out.println(index2 + " " + vegetable.getName());
                index2++;
            }

            System.out.println("Select the vegetables you would like (Enter 0 to finish): ");
            int choiceVegetables = getIntInput(scan, 0, vegetables.size());
            if (choiceVegetables == 0) {
                // User chose to finish
                break;
            }
            RegularToppings chosenVegetable = vegetables.get(choiceVegetables - 1);
            selectedVegetables.add(chosenVegetable);

        } while (true);

        // Add the selected vegetables to the toppings list
        toppingsList.addAll(selectedVegetables);
    }

    // Method to allow the user to choose cheese for the sandwich
    private void chooseCheese(Scanner scan, List<Toppings> toppingsList) {
        System.out.println("\n****** Add cheese ******");

        // Create a list of available cheese options
        List<PremiumToppings> cheeseList = PremiumToppings.createCheeseList(Bread.getSizeType());
        int count = 1;
        for (PremiumToppings cheese : cheeseList) {
            System.out.println(count + " " + cheese.getName() + " - Price: $" + cheese.getBasePrice());
            count++;
        }
        System.out.println("Select the cheese you would like (Enter 0 to finish):");

        getIntInput(scan, 0, cheeseList.size());

        // Get the selected cheese from the list
        PremiumToppings selectedCheese = cheeseList.get(cheeseList.size() - 1);

        toppingsList.add(selectedCheese);

        // Ask if the user wants to add extra cheese
        System.out.println("Would you like to add extra cheese (Yes / NO)?");
        String inputCheese = scan.next().trim().toLowerCase();
        if (inputCheese.equals("yes")) {
            // Display options for extra cheese and add to the toppings list
            int counter = 1;
            for (PremiumToppings cheese : cheeseList) {
                System.out.println(counter + " " + cheese.getName() + " - Price: $" + cheese.getExtraPrice());
                counter++;
            }

            System.out.println("Select the extra cheese you would like:");

            getIntInput(scan, 0, cheeseList.size());

            // Get the selected extra cheese from the list
            PremiumToppings selectedExtraCheese = cheeseList.get(cheeseList.size() - 1);

            toppingsList.add(selectedExtraCheese);
        }
    }

    // Method to allow the user to choose meat for the sandwich
    private void chooseMeat(Scanner scan, List<Toppings> toppingsList, Bread bread) {
        System.out.println("\n****** Choose your meat ******");

        // Create a list of available meat options based on bread type and size
        List<PremiumToppings> meatsList = PremiumToppings.createMeatsList(bread.getBreadType(), Bread.getSizeType());
        int index = 1;
        for (PremiumToppings meats : meatsList) {
            System.out.println(index + " " + meats.getName() + " - Price: $" + meats.getBasePrice());
            index++;
        }
        System.out.println("Select the meat you would like (Enter 0 to finish):");
        int choiceMeat = getIntInput(scan, 0, meatsList.size());

        if (choiceMeat == 0) {
            // User chose to finish
            return;
        }

        // Get the selected meat from the list
        Toppings selectedMeats = meatsList.get(choiceMeat - 1);

        toppingsList.add(selectedMeats);

        // Ask if the user wants to add extra meat
        System.out.println("Would you like to add extra meat (Yes / NO)?");
        String input = scan.next().trim().toLowerCase();
        if (input.equals("yes")) {
            // Display options for extra meat and add to the toppings list
            int count1 = 1;
            for (PremiumToppings meats : meatsList) {
                System.out.println(count1 + " " + meats.getName() + " - Price: $" + meats.getExtraPrice());
                count1++;
            }

            System.out.println("Select the extra meat you would like (Enter 0 to finish):");

            int choiceExtraMeat = getIntInput(scan, 0, meatsList.size());

            if (choiceExtraMeat == 0) {
                // User chose to finish
                return;
            }

            // Get the selected extra meat from the list
            PremiumToppings selectedExtraMeats = meatsList.get(choiceExtraMeat - 1);

            toppingsList.add(selectedExtraMeats);
        }
    }

    // Method to allow the user to choose the type of bread and its size
    private Bread chooseBreadAndSize(Scanner scan) {
        // Display the options for customizing the sandwich
        System.out.println("Customize your sandwich:");
        System.out.println("Choose bread type");
        System.out.println("\t1. White");
        System.out.println("\t2. Wheat");
        System.out.println("\t3. Rye");
        System.out.println("\t4. Wrap");

        // Get the chosen bread type
        int breadChoice = getIntInput(scan, 1, 4);
        Bread selectedBread = switch (breadChoice) {
            case 1 -> new Bread("White", "");
            case 2 -> new Bread("Wheat", "");
            case 3 -> new Bread("Rye", "");
            case 4 -> new Bread("Wrap", "");
            default -> throw new IllegalStateException("Error" + breadChoice);
        };

        System.out.println("\n****** Choose sandwich size ******");
        System.out.println("\t1. 4 inches");
        System.out.println("\t2. 8 inches");
        System.out.println("\t3. 12 inches");

        // Get the chosen bread size
        int sizeChoice = getIntInput(scan, 1, 3);
        Bread.setSizeType(switch (sizeChoice) {
            case 1 -> ("4");
            case 2 -> ("8");
            case 3 -> ("12");
            default -> throw new IllegalStateException("Error" + sizeChoice);
        });

        return selectedBread;
    }


    private void addDrinks(Scanner scan, String customerName, int id) {
        ArrayList<Drink> drinkArrayList = Drink.createDrinkList();

        System.out.println("Please select a size: ");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        int input = scan.nextInt();
        scan.nextLine();
        String size = null;
        switch (input) {
            case 1 -> size = "small";
            case 2 -> size = "medium";
            case 3 -> size = "large";
        }
        // Display the list of drinks
        int index = 1;
        for (Drink drink : drinkArrayList) {
            assert size != null;
            System.out.println(index + " " + drink.getDrinkType() + " - Price: $" + drink.getPrice(size));
            index++;
        }

        System.out.println("Select the number of the drink you would like (Enter 0 to finish):");

        int choice = getIntInput(scan, 0, drinkArrayList.size());

        if (choice == 0) {
            return;
        }

        // Get the selected drink from the list
        Drink selectedDrink = drinkArrayList.get(choice - 1);

        // Create a drink object based on the selected chip
        Drink drinkToAdd = new Drink(selectedDrink.getDrinkType(), size);

        // Create a List<Chips> to hold the chip in the order
        List<Drink> drinksList = new ArrayList<>();
        drinksList.add(drinkToAdd);

        // Create an Order<Chips> instance
        Order<Drink> order = new Order<>(id, customerName, drinksList);
        orderEntries.add(order);

        System.out.println("Added " + drinkToAdd.getDrinkType() + " to your order!");
    }

    //---------------------------------------------------------------------------

    private void addChips(Scanner scan, String customerName, int id) {
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
        orderEntries.add(order);

        System.out.println("Added " + chipToAdd.getChipType() + " to your order!");
    }


    private int getIntInput(Scanner scanner, int min, int max) {
        int choice;
        do {
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < min || choice > max);

        return choice;
    }

    private void cancelOrder() {
        orderEntries.clear();
        System.out.println("Canceling order... directing to Main Menu");
    }
}
