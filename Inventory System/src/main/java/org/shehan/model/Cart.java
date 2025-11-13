package org.shehan.model;

public class Cart {
    private int productId;
    private int quantity;
    private String ProductcName;
    private double ProductcPrice;
    private double ProductcOffer;


    public Cart(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;

    }

    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}
