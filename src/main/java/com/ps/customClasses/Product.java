package com.ps.customClasses;

public abstract class Product {
    private String name;
    private double price;

    public Product(String name, double fixedPrice) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get the price of the product.
     * @return Price of the product.
     */
    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void setPrice();

    // Optional: Override toString for a simple description of the product
    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price;
    }
}
