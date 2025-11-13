package org.shehan.UI;

import org.shehan.Mainmenu;
import org.shehan.model.Customer;
import org.shehan.service.CustomerService;

import java.util.Scanner;

public class CustomerUi {

    static Scanner scanner= new Scanner(System.in);

    public static void login()
    {
        System.out.println("Enter Email and password to LogIn");

        System.out.print("Email:");
        String email=scanner.nextLine();

        System.out.print("Password:");
        String password = scanner.nextLine();
        try{
            Customer islogin = CustomerService.login(email,password);

            if(islogin==null)
            {
                System.out.println("Enter Valid Email and Passoword");
                Mainmenu.show();
            }
            else {
                System.out.println("Registration successful! Welcome " + islogin.getName());

                while(true)
                {
                    System.out.println("===========Enter your choice=============");
                    System.out.println("||   1. View Products                  ||");
                    System.out.println("||   2. Search Products                ||");
                    System.out.println("||   3. Add to Cart                    ||");
                    System.out.println("||   4. view Cart                      ||");
                    System.out.println("||   5. Genertae Bill                  ||");
                    System.out.println("||   6. Logout                         ||");
                    System.out.println("=========================================");

                    int cusotmerchoice=scanner.nextInt();

                    switch (cusotmerchoice)
                    {
                        case 1 ->
                        {
                            ProductUi.ViewAllProduct();
                        }
                        case 2 ->
                        {
                             ProductUi.SearchProduct();
                        }
                        case 3 ->
                        {
                              ProductUi.AddCart();
                        }
                        case 4 ->
                        {
                            ProductUi.ViewCart();
                        }
                        case 5 ->
                        {
                                 BillUi.GenerateBill();
                        }
                        case 6 ->
                        {
                            System.out.println("Logging out...");
                            System.out.println("See You again");
                            Mainmenu.show();
                        }
                        default -> System.out.println("Invalid Choice");
                    }

                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error while Login customer: " + e.getMessage());
        }


    }


    public static void register()
    {
        try {
            System.out.println("\n=== Customer Registration ===");
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Email: ");
            String email = scanner.nextLine().trim();

            System.out.print("Phone : ");
            String phone = scanner.nextLine().trim();

            System.out.print("Password : ");
            String password = scanner.nextLine().trim();

            Customer saved = CustomerService.registerCustomer(name, email, phone,password);

            System.out.println("Registration successful! Customer ID = " + saved.getId());
            System.out.println(saved);
        } catch (IllegalArgumentException iae) {
            System.out.println("Validation error: " + iae.getMessage());
        } catch (Exception e) {
            System.out.println("Error while registering customer: " + e.getMessage());
            // e.printStackTrace(); // development-time only
        }
    }
}
