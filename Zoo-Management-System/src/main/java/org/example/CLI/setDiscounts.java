package org.example.CLI;

import java.util.HashMap;
import java.util.Scanner;

import  org.example.Admin;
import org.example.Deals.Discount;
import org.example.Deals.SpecialDeals;

public class setDiscounts {
    public setDiscounts(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Set Discounts");
            System.out.println("1. Add Discount");
            System.out.println("2. Remove Discount");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice  = scanner.nextInt();
            scanner.nextLine();
            if(choice == 3){
                //Exit
                return;
            }
            else if(choice ==1){
                //Add
                System.out.print("Enter the Discount name: ");
                String dName = scanner.nextLine();
                System.out.print("Enter the Lower Bound for the eligibility of the discount:");
                int lower = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the Upper Bound for the eligibility of the discount:");
                int upper = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                double perc= scanner.nextDouble();
                scanner.nextLine();
                //creating a discount
                Admin.addDiscount(dName,lower,upper,perc);

            } else if (choice == 2) {
                //update
                if (Admin.getDiscountListSize() == 0) {
                    System.out.println("Currently there are no Special Deals");
                } else {
                    HashMap<Integer, Discount> current = new HashMap<>();
                    int count = 1;
                    for(Discount i: Admin.discountList){
                        current.put(count,i);
                        System.out.println(count+". "+i.toString());
                        count++;
                    }
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    if(choice1>=1 && choice1<=count){
                        Discount x =current.get(choice1);
                        //removing the discount
                        Admin.discountList.remove(x);
                        System.out.println("Discount Removed");
                    }
                }

            }else{
                System.out.println("Please enter a valid choice");
            }

        }
    }
}
