package com.ps.customClasses;

public abstract class Product {
    private String name;
    private double price;

    public Product(String name, double fixedPrice) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void setPrice();

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price;
    }
}
