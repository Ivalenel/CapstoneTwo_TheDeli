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


    // Save receipt to file
    public void saveReceipt() {
        String orderSummary = this.formatOrderDetails();
        FileManager.saveReceipt(orderSummary);
    }

    // Add order to DeliOrders.csv
    public void saveToCsv() {
        String orderDetails = this.formatOrderDetails();
        FileManager.saveToCsv(orderDetails, getPrice());
    }

    // Make details readable
    private String formatOrderDetails() {
        StringBuilder details = new StringBuilder();

        details.append("\n");
        details.append("✨✨✨ Welcome to Iva's Deli! ✨✨✨\n");
        details.append("-------------------------------------------\n");

        details.append("🍞 Sandwiches:\n");
        for (Sandwich sandwich : sandwiches) {
            details.append("   🥪 ").append(sandwich).append("\n");
        }
        if (sandwiches.isEmpty()) {
            details.append("   (No sandwiches ordered)\n");
        }

        details.append("🥤 Drinks:\n");
        for (Drink drink : drinks) {
            details.append("   🧃 ").append(drink).append("\n");
        }
        if (drinks.isEmpty()) {
            details.append("   (No drinks ordered)\n");
        }

        details.append("🍟 Chips:\n");
        for (Chips chip : chips) {
            details.append("   🍿 ").append(chip).append("\n");
        }
        if (chips.isEmpty()) {
            details.append("   (No chips ordered)\n");
        }

        details.append("\n");
        details.append("💵 Total Price: $").append(String.format("%.2f", getPrice())).append("\n");
        details.append("-------------------------------------------\n");
        details.append("🧾 Thank you for dining with us! 🧾\n");
        details.append("💖 Have a wonderful day! 💖\n");

        return details.toString();
    }

    // Override toString for displaying the order
    @Override
    public String toString() {
        return formatOrderDetails();
    }
}

