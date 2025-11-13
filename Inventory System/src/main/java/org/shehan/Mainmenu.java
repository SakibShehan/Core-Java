package org.shehan;

import org.shehan.UI.AdminUi;
import org.shehan.UI.CustomerUi;
import org.shehan.model.Admin;
import org.shehan.model.Customer;

import java.util.Scanner;

public class Mainmenu {

    static Scanner sc=new Scanner(System.in);

   public static void show(){

           System.out.println("===========WELCOME TO SMART INVENTORY SYSTEM=============");
           System.out.println("||   1. Admin Login                                    ||");
           System.out.println("||   2. Customer Login                                 ||");
           System.out.println("||   3. Register New Customer                          ||");
           System.out.println("||   4. Exit Application                               ||");
           System.out.println("=========================================================");
           System.out.println("Enter choice:");

           int choice= sc.nextInt();

           switch (choice)
           {
               case 1 -> {
                    AdminUi.Adminlogin();
               }
               case 2 -> {
                   CustomerUi.login();
               }
               case 3 -> {
                   CustomerUi.register();
               }
               case 4 -> {
                   System.out.println("Exiting....Bye");
                   System.exit(0);
               }

               default -> System.out.println("Invalid Choice");

           }
       }
   }



