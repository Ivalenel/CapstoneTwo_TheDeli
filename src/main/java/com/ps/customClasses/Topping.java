package com.ps.customClasses;

public class Topping {
    private String name;
    private String type; // "meat", "cheese", "sauce"
    private double smallPrice;
    private double mediumPrice;
    private double largePrice;

    // Constructor for toppings with specific prices
    public Topping(String name, String type, double smallPrice, double mediumPrice, double largePrice) {
        this.name = name;
        this.type = type;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    // Constructor for included toppings (price is zero for all sizes)
    public Topping(String name, String type) {
        this(name, type, 0.0, 0.0, 0.0);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return smallPrice;
            case "medium":
                return mediumPrice;
            case "large":
                return largePrice;
            default:
                throw new IllegalArgumentException("Invalid sandwich size");
        }
    }
    // Predefined instances of Topping
    public static final Topping STEAK = new Topping("Steak", "meat", 1.00, 2.00, 3.00);
    public static final Topping HAM = new Topping("Ham", "meat", 1.00, 2.00, 3.00);
    public static final Topping SALAMI = new Topping("Salami", "meat", 1.00, 2.00, 3.00);
    public static final Topping ROAST_BEEF = new Topping("Roast Beef", "meat", 1.00, 2.00, 3.00);
    public static final Topping CHICKEN = new Topping("Chicken", "meat", 1.00, 2.00, 3.00);
    public static final Topping BACON = new Topping("Bacon", "meat", 1.00, 2.00, 3.00);

    public static final Topping AMERICAN_CHEESE = new Topping("American Cheese", "cheese", 0.75, 1.50, 2.25);
    public static final Topping PROVOLONE_CHEESE = new Topping("Provolone Cheese", "cheese", 0.75, 1.50, 2.25);
    public static final Topping CHEDDAR_CHEESE = new Topping("Cheddar Cheese", "cheese", 0.75, 1.50, 2.25);
    public static final Topping SWISS_CHEESE = new Topping("Swiss Cheese", "cheese", 0.75, 1.50, 2.25);

    public static final Topping EXTRA_MEAT = new Topping("Extra Meat", "meat", 0.50, 1.00, 1.50);
    public static final Topping EXTRA_CHEESE = new Topping("Extra Cheese", "cheese", 0.30, 0.60, 0.90);

    public static final Topping LETTUCE = new Topping("Lettuce", "regular");
    public static final Topping PEPPERS = new Topping("Peppers", "regular");
    public static final Topping ONIONS = new Topping("Onions", "regular");
    public static final Topping TOMATOES = new Topping("Tomatoes", "regular");
    public static final Topping JALAPENOS = new Topping("Jalapenos", "regular");
    public static final Topping CUCUMBERS = new Topping("Cucumbers", "regular");
    public static final Topping PICKLES = new Topping("Pickles", "regular");
    public static final Topping GUACAMOLE = new Topping("Guacamole", "regular");
    public static final Topping MUSHROOMS = new Topping("Mushrooms", "regular");

    public static final Topping MAYO = new Topping("Mayo", "sauce");
    public static final Topping MUSTARD = new Topping("Mustard", "sauce");
    public static final Topping KETCHUP = new Topping("Ketchup", "sauce");
    public static final Topping RANCH = new Topping("Ranch", "sauce");
    public static final Topping THOUSAND_ISLANDS = new Topping("Thousand Islands", "sauce");
    public static final Topping VINAIGRETTE = new Topping("Vinaigrette", "sauce");

    // Sides included at no extra cost
    public static final Topping AU_JUS = new Topping("Au Jus", "sauce");
}
