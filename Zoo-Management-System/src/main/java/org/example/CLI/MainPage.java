package org.example.CLI;
import org.example.Admin;

import java.util.Scanner;
public class MainPage {
    private final Scanner scanner = new Scanner(System.in);
    public MainPage(){
        mainPage();
    }

    private void mainPage(){
        while (true) {
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = -1;
            int min = 1;
            int max =4;
            do {
                try {
                    choice = scanner.nextInt();
                    if (choice < min || choice > max) {
                        System.out.println("Please enter a valid choice between " + min + " and " + max + ".");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine(); // Consume invalid input
                }
            } while (choice < min || choice > max);
            scanner.nextLine();

            switch (choice) {
                case 1 ->
                    //Admin login page
                        AdminPages.AdminLoginPage();
                case 2 ->
                    //visitor login page
                        VisitorPage.VisitorPageSignin();
                case 3 ->
                    //viewing special deals
                        Admin.printSpecialDeals();
                case 4 -> {
                    scanner.close();
                    System.out.println("Thanks for Visiting!");
                    System.exit(0); // Exit the program
                }
            }
        }
    }
    private int getUserChoice(int min, int max) {
        int choice = -1;
        do {
            try {
                choice = scanner.nextInt();
                if (choice < min || choice > max) {
                    System.out.println("Please enter a valid choice between " + min + " and " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Consume invalid input
            }
        } while (choice < min || choice > max);
        scanner.nextLine(); // Consume the newline character
        return choice;
    }
}
