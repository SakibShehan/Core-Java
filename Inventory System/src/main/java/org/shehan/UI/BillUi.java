package org.shehan.UI;

import org.shehan.model.Bill;
import org.shehan.model.Cart;
import org.shehan.model.Product;
import org.shehan.service.CartService;
import org.shehan.service.ProductService;
import org.shehan.service.BillService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class BillUi {
    public static void GenerateBill() {
        Scanner sc = new Scanner(System.in);
        try {
            List<Cart> cartitem = CartService.getCartItems();

            if (cartitem == null || cartitem.isEmpty()) {
                System.out.println("Your Cart is Empty. Please add items to cart before generating Bill.");
            } else {
                System.out.println("By generating bill you're confirming your purchase.");
                System.out.println("Enter 1 to confirm, 0 otherwise:");

                int choice = sc.nextInt();
                boolean decision = (choice == 1);

                if (decision) {
                    System.out.println("=========================BILL SUMMARY ===============================");
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Product Name", "Quantity", "Price","Offer", "Subtotal");
                    double total=0;
                    for (Cart item : cartitem) {

                        int id = item.getProductId();
                        Product product = BillService.GetProduct(id);

                        String name=product.getProductcName();
                        String category=product.getProductCategory();
                        int quantity=item.getQuantity();
                        double price= product.getProductcPrice();
                        double offer=product.getProductcOffer();
                        double subtotal= (price -(price*(offer/100)))*quantity;

                        total+=subtotal;

                        System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n", name, quantity, price,offer, subtotal);

                        int finalquantity=product.getProductcQuantity()-quantity;


                        Thread updateThread = new Thread(() -> {
                            try {
                                ProductService.updateProduct(id, category, name, finalquantity, price,offer);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        });
                        updateThread.start();

                        Timestamp time = Timestamp.valueOf(LocalDateTime.now());



                        Thread reportThread = new Thread(() -> {
                            try {
                                BillService.GenerateReport(time, id, name, quantity, subtotal);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        });
                        reportThread.start();



                    }
                    System.out.printf("--------------------------------------Total: %s----------------\n",total);
                    cartitem.clear();

                } else {
                    System.out.println("Explore more products from us!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error generating bill: " + e);
            e.printStackTrace();
        }
    }

    public static void ViewSalesReport() {
        try {
            List<Bill> bill = BillService.getBill();
            if (bill.isEmpty()) {
                System.out.println("Bill is not generated yet!");
            } else {
                System.out.println("Sales Report:");
                for (Bill b : bill) {
                    System.out.println(b);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching Bill: " + e.getMessage());
        }

    }
}
