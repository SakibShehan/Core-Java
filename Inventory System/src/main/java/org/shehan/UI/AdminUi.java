package org.shehan.UI;

import org.shehan.Mainmenu;
import org.shehan.service.ProductService;

import java.util.Scanner;

public class AdminUi {

    Scanner sc= new Scanner(System.in);
    public static void  Adminlogin()
    {

        System.out.println("Enter Admin Password:");
        Scanner sc= new Scanner(System.in);
        String input=sc.nextLine();
        String adminpass="admin123";
         if(input.equals(adminpass)) {
             System.out.println("Login Successfull");
             System.out.println("Hi Admin! What you want to do?");


             while (true) {
                 System.out.println("===========Press Button to choose your action=============");
                 System.out.println("||   1. Add Product                                     ||");
                 System.out.println("||   2. Update Product                                  ||");
                 System.out.println("||   3. Delete Product                                  ||");
                 System.out.println("||   4. View all Product                                ||");
                 System.out.println("||   5. View Sales Report                               ||");
                 System.out.println("||   6. Low stock Alert                                 ||");
                 System.out.println("||   7. LogOut                                          ||");
                 System.out.println("=========================================================");
                 System.out.println("Enter choice:");
                 int adminchoice = sc.nextInt();

                 switch (adminchoice) {
                     case 1 -> {
                         ProductUi.AddProduct();
                     }
                     case 2 -> {
                         ProductUi.UpdateProduct();
                     }
                     case 3 -> {
                         ProductUi.DeleteProduct();
                     }
                     case 4 -> {
                         ProductUi.ViewAllProduct();
                     }
                     case 5 -> {
                         BillUi.ViewSalesReport();
                     }
                     case 6 -> {
                         ProductUi.LowStockAlert();
                     }
                     case 7 -> {
                         System.out.println("Logging Out....");
                         Mainmenu.show();

                     }

                     default ->
                     {
                         System.out.println("Invalid Choice");
                     }
                 }

             }
         }
         else
         {
             System.out.println("Enter Valid Password");
             Mainmenu.show();
         }



    }
}
