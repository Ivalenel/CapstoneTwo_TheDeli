package com.ps.customClasses;

public class Drink extends Product {
    public static final String FLAVOR_COLA = "Cola";
    public static final String FLAVOR_ORANGE = "Orange";
    public static final String FLAVOR_GRAPE = "Grape";
    public static final String FLAVOR_LEMON_LIME = "Lemon Lime";
    public static final String FLAVOR_ROOT_BEER = "Root Beer";

    private String size;
    private String flavor;

    // Constructor initializes flavor and size
    public Drink(String flavor, String size) {
        super(flavor, 0); // Pass flavor as name and a placeholder price of 0
        validateFlavor(flavor);
        validateSize(size);
        this.flavor = flavor.toLowerCase(); // Normalize flavor to lowercase
        this.size = size.toLowerCase(); // Normalize size to lowercase
    }

    // Validate the flavor (case-insensitive)
    private void validateFlavor(String flavor) {
        if (!flavor.equalsIgnoreCase(FLAVOR_COLA) &&
                !flavor.equalsIgnoreCase(FLAVOR_ORANGE) &&
                !flavor.equalsIgnoreCase(FLAVOR_GRAPE) &&
                !flavor.equalsIgnoreCase(FLAVOR_LEMON_LIME) &&
                !flavor.equalsIgnoreCase(FLAVOR_ROOT_BEER)) {
            throw new IllegalArgumentException("Invalid flavor: " + flavor);
        }
    }

    // Validate the size (case-insensitive)
    private void validateSize(String size) {
        if (!size.equalsIgnoreCase("small") &&
                !size.equalsIgnoreCase("medium") &&
                !size.equalsIgnoreCase("large")) {
            throw new IllegalArgumentException("Invalid size: " + size + ". Valid sizes are 'small', 'medium', or 'large'.");
        }
    }

    // Override getPrice to calculate price based on size
    @Override
    public double getPrice() {
        switch (size) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                throw new IllegalArgumentException("Invalid size: " + size);
        }
    }

    @Override
    public void setPrice() {

    }

    // Getters
    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    // toString method to display drink information
    @Override
    public String toString() {
        return "Drink (Flavor: " + flavor + ", Size: " + size + ", Price: $" + getPrice() + ")";
    }
}
