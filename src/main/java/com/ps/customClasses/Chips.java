package com.ps.customClasses;

public class Chips extends Product {
    public static final String FLAVOR_ORIGINAL = "Original";
    public static final String FLAVOR_SOUR_CREAM = "Sour Cream & Onion";
    public static final String FLAVOR_BBQ = "Barbecue";
    public static final String FLAVOR_CHEESE = "Cheddar Cheese";

    private String flavor;
    private static final double FIXED_PRICE = 1.50;

    // Constructor initializes flavor and sets a fixed price
    public Chips(String flavor) {
        super(flavor, FIXED_PRICE); // Pass flavor as name and fixed price to Product
        validateFlavor(flavor);
        this.flavor = flavor.toLowerCase(); // Normalize flavor to lowercase
    }

    // Validate the flavor (case-insensitive)
    private void validateFlavor(String flavor) {
        if (!flavor.equalsIgnoreCase(FLAVOR_ORIGINAL) &&
                !flavor.equalsIgnoreCase(FLAVOR_SOUR_CREAM) &&
                !flavor.equalsIgnoreCase(FLAVOR_BBQ) &&
                !flavor.equalsIgnoreCase(FLAVOR_CHEESE)) {
            throw new IllegalArgumentException("Invalid flavor: " + flavor);
        }
    }

    // Override getPrice to return the fixed price for chips
    @Override
    public double getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public void setPrice() {

    }

    // toString method to display information about the chips
    @Override
    public String toString() {
        return "Chips (Flavor: " + flavor + ", Price: $" + getPrice() + ")";
    }
}
