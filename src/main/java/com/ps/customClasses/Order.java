package com.ps.customClasses;

import com.ps.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    // Method to add a sandwich to the order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // Method to add a drink to the order
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // Method to add chips to the order
    public void addChips(Chips chip) {
        chips.add(chip);
    }

    // Calculate the total price of the order
    public double getPrice() {
        double sandwichTotal = sandwiches.stream().mapToDouble(Sandwich::getPrice).sum();
        double drinksTotal = drinks.stream().mapToDouble(Drink::getPrice).sum();
        double chipsTotal = chips.stream().mapToDouble(Chips::getPrice).sum();

        return sandwichTotal + drinksTotal + chipsTotal;
    }

    // Save order details to DeliOrders.csv

    // Save receipt to file
    public void saveReceipt() {
        String orderSummary = this.formatOrderDetails();
        FileManager.saveReceipt(orderSummary);
    }

    // Append order to DeliOrders.csv
    public void saveToCsv() {
        String orderDetails = this.formatOrderDetails();
        FileManager.saveToCsv(orderDetails, getPrice());
    }

    // Format order details in a readable structure
    private String formatOrderDetails() {
        StringBuilder details = new StringBuilder();

        details.append("Sandwiches:\n");
        for (Sandwich sandwich : sandwiches) {
            details.append("  - ").append(sandwich).append("\n");
        }

        details.append("Drinks:\n");
        for (Drink drink : drinks) {
            details.append("  - ").append(drink).append("\n");
        }

        details.append("Chips:\n");
        for (Chips chip : chips) {
            details.append("  - ").append(chip).append("\n");
        }

        details.append("\nTotal Price: $").append(getPrice());
        return details.toString();
    }

    // Override toString for displaying the order in the console
    @Override
    public String toString() {
        return formatOrderDetails();
    }
}

