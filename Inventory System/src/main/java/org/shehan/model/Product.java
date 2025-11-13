package org.shehan.model;

public class Product {
    private int ProductId;
    private String ProductCategory;
    private String ProductcName;
    private int ProductcQuantity;
    private double ProductcPrice;
    private double ProductcOffer;

    public Product() {
    }

    public Product(int ProductId, String ProductCategory, String ProductcName, int ProductcQuantity, double ProductcPrice, double ProductcOffer) {
        this.ProductId = ProductId;
        this.ProductCategory = ProductCategory;
        this.ProductcName = ProductcName;
        this.ProductcQuantity = ProductcQuantity;
        this.ProductcPrice = ProductcPrice;
        this.ProductcOffer = ProductcOffer;
    }

    // Getters and Setters
    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        this.ProductId = productId;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        this.ProductCategory = productCategory;
    }

    public String getProductcName() {
        return ProductcName;
    }

    public void setProductcName(String productcName) {
        this.ProductcName = productcName;
    }

    public int getProductcQuantity() {
        return ProductcQuantity;
    }

    public void setProductcQuantity(int productcQuantity) {
        this.ProductcQuantity = productcQuantity;
    }

    public double getProductcPrice() {
        return ProductcPrice;
    }

    public void setProductcPrice(double productcPrice) {
        this.ProductcPrice = productcPrice;
    }

    public double getProductcOffer() {
        return ProductcOffer;
    }

    public void setProductcOffer(double productcOffer) {
        this.ProductcOffer = productcOffer;
    }

    @Override
    public String toString() {
        return "\n--- Product Details ---" +
                "\nProduct ID: " + ProductId +
                "\nCategory: " + ProductCategory +
                "\nName: " + ProductcName +
                "\nQuantity: " + ProductcQuantity +
                "\nPrice: " + ProductcPrice +
                "\nOffer: " + ProductcOffer + "%";
    }
}
