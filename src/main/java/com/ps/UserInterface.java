package com.ps;

import com.ps.customClasses.Chips;
import com.ps.customClasses.Drink;
import com.ps.customClasses.Order;
import com.ps.customClasses.Sandwich;
import com.ps.customClasses.Topping;

import java.util.Scanner;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);
    private static Order order = new Order();

    public static void display() {
        int mainCommand;

        do {
            System.out.println("\nWelcome to Iva's Deli!");
            System.out.println("Please choose an option:");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Command: ");
            mainCommand = scanner.nextInt();
            scanner.nextLine();  // Consume newline left by nextInt()

            switch (mainCommand) {
                case 1:
                    handleNewOrder();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found, please try again...");
            }

        } while (mainCommand != 0);
    }

    private static void handleNewOrder() {
        int orderCommand;

        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1) Add Sandwich \uD83E\uDD6A");
            System.out.println("2) Add Drink \uD83E\uDD64");
            System.out.println("3) Add Chips \uD83C\uDF5F");
            System.out.println("4) Checkout \uD83D\uDED2");
            System.out.println("5) Cancel Order \uD83D\uDEAB");

            System.out.print("Selection: ");
            orderCommand = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (orderCommand) {
                case 1:
                    handleAddSandwich();
                    break;
                case 2:
                    handleAddDrink();
                    break;
                case 3:
                    handleAddChips();
                    break;
                case 4:
                    handleCheckout();
                    return; // Return to main menu after checkout
                case 5:
                    System.out.println("Order canceled. Returning to main menu.");
                    order = new Order(); // Reset order
                    return;
                default:
                    System.out.println("Command not found, please try again...");
            }
        } while (orderCommand != 0);
    }

    private static void handleAddSandwich() {
        String bread = getValidBread();
        System.out.print("Select sandwich size (Small: 4 inch, Medium: 4 inch, Large: 12 inch): ");
        String size = scanner.nextLine().toLowerCase();

        Sandwich sandwich = new Sandwich(size, bread);

        // Select meat toppings
        System.out.println("Choose meats \uD83C\uDF56 \uD83E\uDD69 \uD83C\uDF57 \uD83E\uDD53- Steak, Ham , Salami, Roast Beef, Chicken, Bacon (type 'done' when finished): ");
        selectToppings(sandwich, "meat");

        // Select cheese toppings
        System.out.println("Choose cheeses \uD83E\uDDC0- American Cheese, Provolone Cheese, Cheddar Cheese, Swiss Cheese, (type 'done' when finished): ");
        selectToppings(sandwich, "cheese");

        // Select regular toppings
        System.out.println("Choose regular toppings \uD83E\uDD6C \uD83E\uDDC5 \uD83C\uDF45 \uD83E\uDD51- Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms (type 'done' when finished): ");
        selectToppings(sandwich, "regular");

        // Select sauces
        System.out.println("Choose sauces \uD83E\uDDF4 \uD83C\uDF72- Mayo, Mustard, Ketchup, Ranch, Thousand Islands, Vinaigrette, Au Jus (type 'done' when finished): ");
        selectToppings(sandwich, "sauce");

        // Confirm and add sandwich to order
        order.addSandwich(sandwich);
        System.out.println("Sandwich added to your order!");
    }

    private static String getValidBread() {
        String bread;
        while (true) {
            System.out.print("Select your bread \uD83C\uDF5E \uD83E\uDD56 (White, Wheat, Rye, Wrap): ");
            bread = scanner.nextLine().toLowerCase();
            if (bread.equals("white") || bread.equals("wheat") || bread.equals("rye") || bread.equals("wrap")) {
                break;
            } else {
                System.out.println("Invalid bread choice. Please select from White, Wheat, Rye, or Wrap.");
            }
        }
        return bread;
    }

    private static void selectToppings(Sandwich sandwich, String category) {
        while (true) {
            System.out.print("Enter topping name (type 'extra' before the name for extra portion, or 'done' to finish): ");
            String toppingInput = scanner.nextLine().toLowerCase();

            if (toppingInput.equals("done")) break;

            boolean isExtra = toppingInput.startsWith("extra ");
            String toppingName = isExtra ? toppingInput.substring(6) : toppingInput;

            Topping topping = getToppingByName(toppingName, category);
            if (topping != null) {
                if (isExtra) {
                    sandwich.addExtraTopping(topping);
                    System.out.println(topping.getName() + " added as an extra topping.");
                } else {
                    sandwich.addTopping(topping);
                    System.out.println(topping.getName() + " added as a regular topping.");
                }
            } else {
                System.out.println("Invalid topping name for category " + category + ". Please try again.");
            }
        }
    }

    private static Topping getToppingByName(String name, String category) {
        switch (category.toLowerCase()) {
            case "meat":
                switch (name) {
                    case "steak":
                        return Topping.STEAK;
                    case "ham":
                        return Topping.HAM;
                    case "salami":
                        return Topping.SALAMI;
                    case "roast beef":
                        return Topping.ROAST_BEEF;
                    case "chicken":
                        return Topping.CHICKEN;
                    case "bacon":
                        return Topping.BACON;
                }
                break;
            case "cheese":
                switch (name) {
                    case "american cheese":
                        return Topping.AMERICAN_CHEESE;
                    case "provolone cheese":
                        return Topping.PROVOLONE_CHEESE;
                    case "cheddar cheese":
                        return Topping.CHEDDAR_CHEESE;
                    case "swiss cheese":
                        return Topping.SWISS_CHEESE;
                    case "extra cheese":
                        return Topping.EXTRA_CHEESE;
                }
                break;
            case "regular":
                switch (name) {
                    case "lettuce":
                        return Topping.LETTUCE;
                    case "peppers":
                        return Topping.PEPPERS;
                    case "onions":
                        return Topping.ONIONS;
                    case "tomatoes":
                        return Topping.TOMATOES;
                    case "jalapenos":
                        return Topping.JALAPENOS;
                    case "cucumbers":
                        return Topping.CUCUMBERS;
                    case "pickles":
                        return Topping.PICKLES;
                    case "guacamole":
                        return Topping.GUACAMOLE;
                    case "mushrooms":
                        return Topping.MUSHROOMS;
                }
                break;
            case "sauce":
                switch (name) {
                    case "mayo":
                        return Topping.MAYO;
                    case "mustard":
                        return Topping.MUSTARD;
                    case "ketchup":
                        return Topping.KETCHUP;
                    case "ranch":
                        return Topping.RANCH;
                    case "thousand islands":
                        return Topping.THOUSAND_ISLANDS;
                    case "vinaigrette":
                        return Topping.VINAIGRETTE;
                    case "au jus":
                        return Topping.AU_JUS;
                }
                break;
            default:
                break;
        }
        return null;
    }

    private static void handleAddDrink() {
        System.out.print("Select drink size (Small, Medium, Large): ");
        String size = scanner.nextLine().toLowerCase();

        System.out.print("Select flavor \uD83C\uDF4A \uD83C\uDF47 \uD83C\uDF4B \uD83C\uDF7A (Cola, Orange, Grape, Lemon Lime, Root Beer): ");
        String flavor = scanner.nextLine().toLowerCase();

        // Create a new Drink instance
        Drink drink = new Drink(flavor, size);
        order.addDrink(drink);

        System.out.println("Drink added to your order!");
    }

    private static void handleAddChips() {
        System.out.print("Select chip flavor \uD83C\uDF5F, \uD83E\uDDC5, \uD83D\uDD25, \uD83E\uDDC0 (Original, Sour Cream & Onion, Barbecue, Cheddar Cheese): ");
        String flavor = scanner.nextLine();

        // Create a new Chips instance
        Chips chips = new Chips(flavor);
        order.addChips(chips);

        // Display the chip details with price
        System.out.println("Chips added to your order!");
    }

    private static void handleCheckout() {
        System.out.println("\nCheckout");
        System.out.println("Order details:");
        System.out.println(order); // Calls toString on Order for a summary

        System.out.print("Confirm order? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            order.saveReceipt(); // Save receipt to a timestamped file
            order.saveToCsv(); // Append order to DeliOrders.csv in a formatted way
            System.out.println("Order confirmed. \uD83E\uDDFE");
            order = new Order(); // Clear the current order after checkout
            return; // Exit the method to prevent calling handleNewOrder
        } else {
            System.out.println("Order canceled. Returning to order menu.");
            handleNewOrder(); // Revert to the previous menu
        }
    }
}

