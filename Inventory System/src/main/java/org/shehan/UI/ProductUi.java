package org.shehan.UI;

import org.shehan.dao.ProductDao;
import org.shehan.model.Customer;
import org.shehan.model.Product;
import org.shehan.model.Cart;
import org.shehan.service.CartService;
import org.shehan.service.CustomerService;
import org.shehan.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductUi {

    static Scanner sc= new Scanner(System.in);
    public static void AddProduct() {

        try {
            System.out.println("Enter Product Details:");

            System.out.println("Enter Product id:");
            int ProductId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Product Category:");
            String ProductCategory = sc.nextLine();

            System.out.println("Enter Product Name:");
            String ProductcName = sc.nextLine();

            System.out.println("Enter Product Quantity:");
            int ProductcQuantity = sc.nextInt();

            System.out.println("Enter Product Price:");
            double ProductcPrice = sc.nextDouble();

            System.out.println("Enter Product Offer:");
            double ProductcOffer = sc.nextDouble();

            Product AddProduct = ProductService.AddNewProduct(ProductId, ProductCategory, ProductcName, ProductcQuantity, ProductcPrice, ProductcOffer);

            System.out.println("Product Added Successfully! Product ID = " + AddProduct. getProductId());
            System.out.println(AddProduct);
        }
        catch (Exception e)
        {
            System.out.println("Error while adding new product"+ e.getMessage());
        }



    }

    public static void ViewAllProduct() {
        try {
            List<Product> products = ProductService.getAllProducts();
            if (products.isEmpty()) {
                System.out.println("No products found!");
            } else {
                System.out.println("All Products:");
                for (Product p : products) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }

    }

    public static void UpdateProduct() {
        try {
            System.out.println("Enter Product ID to update:");
            int ProductId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter New Product Category:");
            String ProductCategory = sc.nextLine();

            System.out.println("Enter New Product Name:");
            String ProductcName = sc.nextLine();

            System.out.println("Enter New Product Quantity:");
            int ProductcQuantity = sc.nextInt();

            System.out.println("Enter New Product Price:");
            double ProductcPrice = sc.nextDouble();

            System.out.println("Enter New Product Offer:");
            double ProductcOffer = sc.nextDouble();

            boolean updated = ProductService.updateProduct(ProductId, ProductCategory, ProductcName, ProductcQuantity, ProductcPrice, ProductcOffer);

            if (updated) {
                System.out.println("Product updated successfully!");
            } else {
                System.out.println("Product not found or update failed!");
            }

        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    public static void DeleteProduct() {
        try{
            System.out.println("Enter Product id you want to delete:");
            int ProductId= sc.nextInt();
            boolean deleted= ProductService.DeleteProduct(ProductId);
            if (deleted) {
                System.out.println("Product Delete successfully!");
            } else {
                System.out.println("Product not found or Error Occured!");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error updating product: " + e.getMessage());
        }
        }

    public static void LowStockAlert() {
        try {
            System.out.println("Enter the Lower Limit of Low Stock");
            int lowstock = sc.nextInt();

            List<Product> products = ProductService.LowStockAlert(lowstock);
            if (products.isEmpty()) {
                System.out.println("No products is in Low stock !");
            } else {
                System.out.println("All Low stock Products:");
                for (Product p : products) {
                    System.out.println(p.getProductcName());
                    System.out.println(p.getProductcQuantity());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void SearchProduct() {
        try{

            System.out.println("Enter Product Name:");
            String productname=sc.next();
            if(productname!=null)
            {
                Product product=ProductService.SearchProduct(productname);

                if(product==null) System.out.println("No "+productname+" is in Stock!");
                else
                {
                    System.out.println(product);
                }
            }
            else System.out.println("Please enter product name to find your product!");

        }
        catch (Exception e)
        {
            System.out.println("Error in finding Proudct "+e.getMessage());
        }
    }

    public static void AddCart() throws Exception {

        while (true) {
            System.out.println("Enter Product ID (0 to stop): ");
            int productId = sc.nextInt();
            if (productId == 0) break;

            System.out.println("Enter Quantity: ");
            int quantity = sc.nextInt();

            boolean check= CartService.CheckProduct(productId,quantity);

            if(check)
            {
                CartService.addCart(productId, quantity);
            }
            else System.out.println("Unavailable or Insufficient Product! ");


        }

        System.out.println("Cart Items Added Successfully!");


    }

    public static void ViewCart() {
        for (Cart item : CartService.getCartItems()) {
            System.out.println("Product ID: " + item.getProductId() + ", Quantity: " + item.getQuantity());
        }
    }
}

