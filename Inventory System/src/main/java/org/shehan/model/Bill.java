package org.shehan.model;

import java.sql.Timestamp;

public class Bill {
    private Timestamp time;
    private int productId;
    private String productName;
    private int quantity;
    private double subtotal;

    // Default constructor
    public Bill() {
    }

    // Parameterized constructor
    public Bill(Timestamp time, int productId, String productName, int quantity, double subtotal) {
        this.time = time;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    // Getters and Setters
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    // toString() method
    @Override
    public String toString() {
        return "\n--- Bill Details ---" +
                "\nTime: " + time +
                "\nProduct ID: " + productId +
                "\nProduct Name: " + productName +
                "\nQuantity: " + quantity +
                "\nSubtotal: " + subtotal;
    }
}
