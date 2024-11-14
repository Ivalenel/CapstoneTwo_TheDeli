package com.ps.customClasses;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size;
    private String bread;
    private List<Topping> toppings;
    private List<Topping> extraToppings;

    // Valid bread options
    private static final List<String> VALID_BREADS = List.of("white", "wheat", "rye", "wrap");

    // Base prices for sandwich sizes
    private static final double SMALL_PRICE = 5.50;
    private static final double MEDIUM_PRICE = 7.00;
    private static final double LARGE_PRICE = 8.50;

    public Sandwich(String size, String bread) {
        this.size = size.toLowerCase();
        setBread(bread);  // Use the setter to validate bread choice
        this.toppings = new ArrayList<>();
        this.extraToppings = new ArrayList<>();
    }

    // Method to set and validate the bread choice
    public void setBread(String bread) {
        if (VALID_BREADS.contains(bread.toLowerCase())) {
            this.bread = bread.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid bread type. Choose from: " + VALID_BREADS);
        }
    }

    // Method to add a regular topping
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Method to add an extra topping (double portion or additional topping)
    public void addExtraTopping(Topping topping) {
        extraToppings.add(topping);
    }

    // Calculate total price of the sandwich, including regular and extra toppings
    private double calculatePrice() {
        double price = getSizePrice();

        // Add price of each regular topping based on sandwich size
        for (Topping topping : toppings) {
            price += topping.getPrice(size);
        }

        // Add price of each extra topping with a multiplier for "extra" portion
        for (Topping extraTopping : extraToppings) {
            price += extraTopping.getPrice(size) * 1.5; // Extra toppings have a 1.5x price multiplier
        }

        return price;
    }

    // Public method to retrieve the total price of the sandwich
    public double getPrice() {
        return calculatePrice();
    }

    // Helper method for size-based base price
    private double getSizePrice() {
        switch (size) {
            case "small":
                return SMALL_PRICE;
            case "medium":
                return MEDIUM_PRICE;
            case "large":
                return LARGE_PRICE;
            default:
                throw new IllegalArgumentException("Invalid sandwich size");
        }
    }

    // Override toString to display sandwich details
    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("Sandwich (Size: " + size + ", Bread: " + bread + ", Toppings: ");

        for (Topping topping : toppings) {
            details.append(topping.getName()).append(" ($").append(topping.getPrice(size)).append("), ");
        }

        details.append("Extra Toppings: ");
        for (Topping extraTopping : extraToppings) {
            details.append(extraTopping.getName()).append(" ($").append(extraTopping.getPrice(size) * 1.5).append("), ");
        }

        details.append("Total Price: $").append(getPrice()).append(")");
        return details.toString();
    }

    // Getters for size and bread, if needed
    public String getSize() {
        return size;
    }

    public String getBread() {
        return bread;
    }
}
