package org.example.CLI;

import org.example.Admin;
import org.example.Animals.*;
import org.example.Attractions;
import org.example.Deals.Discount;
import org.example.Visitors.*;

import java.util.ArrayList;
import java.util.Scanner;

public class VisitorPage  extends Admin {
    private static final Scanner scanner = new Scanner(System.in);


    public static void VisitorPageSignin(){
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int vinp = getUserChoice(1, 3);

            switch (vinp) {
                case 1 -> {
                    System.out.print("Enter Visitor Name: ");
                    String name = scanner.nextLine();

                    // Validate Visitor Name
                    if (name.isEmpty()) {
                        System.out.println("Visitor Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Visitor Age: ");
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for Visitor Age. Please enter a valid integer.");
                        break;
                    }

                    // Validate Visitor Age
                    if (age < 0 || age > 100) {
                        System.out.println("Visitor Age should be between 0 and 100.");
                        break;
                    }

                    System.out.print("Enter Visitor Phone Number: ");
                    String pho = scanner.nextLine();

                    // Validate Visitor Phone Number
                    if (pho.isEmpty()) {
                        System.out.println("Visitor Phone Number cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Visitor Balance: ");
                    double bal;
                    try {
                        bal = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for Visitor Balance. Please enter a valid number.");
                        break;
                    }

                    // Validate Visitor Balance
                    if (bal < 0) {
                        System.out.println("Visitor Balance cannot be negative.");
                        break;
                    }

                    System.out.print("Enter Visitor Email: ");
                    String email = scanner.nextLine();

                    // Validate Visitor Email
                    if (email.isEmpty()) {
                        System.out.println("Visitor Email cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Visitor Password: ");
                    String pass = scanner.next();

                    // Create a Basic visitor by default
                    Admin.addVisitor(name, age, pho, bal, email, pass);
                }
                case 2 -> {
                    // Login
                    System.out.print("Enter Visitor Email: ");
                    String Email = scanner.next();
                    System.out.print("Enter Visitor Password: ");
                    String passd = scanner.next();
                    System.out.println();
                    int j = 0;
                    for (Visitor i : Admin.getVisitorList()) {
                        if (i.getEmail().equals(Email) && i.getPassword().equals(passd)) {
                            j++;
                            visitorPage(i);
                            return;
                        }
                    }
                    if (j == 0) {
                        System.out.println("Visitor not found (P.S. check input if it is correct)");
                    }
                }
                case 3 -> {
                    return; // Back to the main menu
                }
                default -> System.out.println("Please enter a valid choice.");
            }
        }
    }

    private static void visitorPage(Visitor visitor) {
        while (true) {
            System.out.println("Visitor Menu:");
            System.out.println("1. Explore the zoo");
            System.out.println("2. Buy Membership");
            System.out.println("3. Buy Tickets");
            System.out.println("4. View Discounts");
            System.out.println("5. View Special Deals");
            System.out.println("6. Visit Animals");
            System.out.println("7. Visit Attractions");
            System.out.println("8. Leave Feedback");
            System.out.println("9. Logout");
            System.out.println();
            System.out.print("Enter your choice: ");
            int inp = getUserChoice(1, 9);

            switch (inp) {
                case 1:
                    // Explore the zoo
                    if (!checkAnimalTypes()) {
                        System.out.println("The zoo is closed as it doesn't have at least two of each animal type.");
                        break;
                    }
                    new exploreTheZoo();
                    break;
                case 2:
                    // Buy membership
                    if (visitor instanceof Premium) {
                        System.out.println("You are already a Premium user");
                        break;
                    } else {
                        System.out.println("Buy Membership:");
                        System.out.println("1. Basic Membership (20)");
                        System.out.println("2. Premium Membership (50)");
                        double bal = visitor.getBal();
                        if (bal < 20) {
                            System.out.println("Please top-up balance");
                            break;
                        } else {
                            System.out.print("Enter your choice: ");
                            int a = scanner.nextInt();
                            scanner.nextLine();

                            if (a == 2) {
                                if (visitor instanceof Premium) {
                                    System.out.println("You are already a Premium user");
                                    break;
                                } else {
                                    double bal1 = visitor.getBal();
                                    double amtToReduce = 50;
                                    System.out.print("Enter discount code: ");
                                    String disc = scanner.nextLine();
                                    for (Discount i: discountList){
                                        if(i.getDiscName().equals(disc)){
                                            //discount found
                                            if(!(visitor.getAge()>=i.getLowerBound() && visitor.getAge()<=i.getUpperBound())){System.out.println("Not eligible for the discount");break;}
                                            discountList.remove(i);
                                            double perc = i.getDiscPerc();
                                            amtToReduce = amtToReduce - (perc/100)*amtToReduce;
                                        }
                                    }
                                    if (bal1 < amtToReduce) {
                                        System.out.println("Please top-up balance");
                                        break;
                                    } else {
                                        bal1 = bal1 - amtToReduce;
                                        Admin.totalRevenue += amtToReduce;
                                        visitor = new Premium(visitor.getName(), visitor.getAge(), visitor.getPho(), bal1, visitor.getEmail(), visitor.getPassword());
                                        System.out.println("Your selected subscription is PREMIUM");
                                        System.out.println("Your current balance is "+visitor.getBal());
                                    }
                                }
                            } else if (a == 1) {
                                if (visitor instanceof Basic) {
                                    System.out.println("You are already a basic user");
                                    break;
                                } else {
                                    double bal1 = visitor.getBal();
                                    double amtToReduce = 20;
                                    System.out.print("Enter discount code: ");
                                    String disc = scanner.nextLine();
                                    for (Discount i: discountList){
                                        if(i.getDiscName().equals(disc)){
                                            //discount found
                                            if(!(visitor.getAge()>=i.getLowerBound() && visitor.getAge()<=i.getUpperBound())){System.out.println("Not eligible for the discount");break;}
                                            discountList.remove(i);
                                            double perc = i.getDiscPerc();
                                            amtToReduce = amtToReduce - (perc/100)*amtToReduce;
                                        }
                                    }
                                    if (bal1 < amtToReduce) {
                                        System.out.println("Please top-up balance");
                                        break;
                                    } else {
                                        bal1 = bal1 - amtToReduce;
                                        Admin.totalRevenue += amtToReduce;
                                        visitor = new Basic(visitor.getName(), visitor.getAge(), visitor.getPho(), bal1, visitor.getEmail(), visitor.getPassword());
                                        System.out.println("Your selected subscription is BASIC");
                                        System.out.println("Your current balance is "+visitor.getBal());

                                    }
                                }
                            } else {
                                System.out.println("Please enter a valid choice");
                            }
                            break;
                        }
                    }
                case 3:
                    // Buy tickets
                    if (visitor.getType().equals("default")){System.out.println("First buy a subscription");break;}
                    if(attractionList.isEmpty()){System.out.println("No attraction currently available");}
                    new buyTickets(visitor);
                    break;
                case 4:
                    // View discounts
                    if(discountList.isEmpty()){System.out.println("There are currently no Discounts.");break;}
                    for (Discount discount : discountList) {
                        if(!discount.isUsed()){
                            System.out.println(discount.toString());
                        }
                    }
                    break;
                case 5:
                    // View special discounts
                    printSpecialDeals();
                    break;
                case 6:
                    // Visit animals
                    if (visitor.getType().equals("default")){System.out.println("First buy a subscription");break;}
                    if(animalList.isEmpty()){System.out.println("There are currently no Animals in the Zoo.\nPlease come later.");break;}

                    System.out.println();
                    System.out.println("1. Feed");
                    System.out.println("2.Visit");
                    System.out.print("Please enter a choice");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    if(choice2==1){
                        printAnimals();
                        System.out.print("Enter animal to be fed: ");
                        int choice3 = scanner.nextInt();
                        scanner.nextLine();
                        int min = 1;
                        int max = getAnimalListSize();
                        if(choice3>=min && choice3<=max){
                            for(Animal i: animalList){
                                if (i.getID() == choice3){i.feed();break;}
                            }
                        }else{
                            System.out.println("Please enter a valid choice");
                        }
                    }else if(choice2 == 2){
                        printAnimals();
                        System.out.print("Enter animal to be visited");
                        int choice3 = scanner.nextInt();
                        scanner.nextLine();
                        int min = 1;
                        int max = getAnimalListSize();
                        if(choice3>=min && choice3<=max){
                            for(Animal i: animalList){
                                if (i.getID() == choice3){i.visit();break;}
                            }
                        }else{
                            System.out.println("Please enter a valid choice");
                        }
                    }else{System.out.println("Please enter valid choice.");}
                    break;
                case 7:
                    if (visitor.getType().equals("default")){System.out.println("First buy a subscription");break;}
                    // Visit attractions
                    new visitAttraction(visitor);
                    break;
                case 8:
                    if (visitor.getType().equals("default")){System.out.println("First buy a subscription");break;}

                    // Leave feedback
                    System.out.println("leave Feedback:");
                    System.out.print("Enter your feedback (max 200 characters): ");
                    String feedback = scanner.nextLine();
                    System.out.println("Thank you for your feedback.");
                    feedbackList.put(visitor.getName(),feedback);
                    break;
                case 9:
                    // Logout
                    System.out.println("Logged out.");
                    return; // Back to the main menu
                default:
                    System.out.println("Please enter a valid choice.");
            }
        }
    }

    private static int getUserChoice(int min, int max) {
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
    private static boolean checkAnimalTypes() {
        int mammalCount = 0;
        int amphibianCount = 0;
        int reptileCount = 0;
        for (Animal animal : animalList) {
            if (animal instanceof Mammals) {
                mammalCount++;
            } else if (animal instanceof Amphibians) {
                amphibianCount++;
            } else if (animal instanceof Reptiles) {
                reptileCount++;
            }
        }
        return mammalCount >= 2 && amphibianCount >= 2 && reptileCount >= 2;
    }
}
