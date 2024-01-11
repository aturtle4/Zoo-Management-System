package org.example.CLI;

import java.util.HashMap;
import java.util.Scanner;

import  org.example.Admin;
import org.example.Deals.SpecialDeals;

public class setSpecialDeal {
    public setSpecialDeal(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Set Special Deals");
            System.out.println("1. Add Special Deals");
            System.out.println("2. Remove Special Deals");
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
                System.out.println();
                System.out.print("Enter the Special Deal name: ");
                String Name = scanner.nextLine();
                System.out.print("Enter the number of tickets: ");
                int tcount = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Special Deal Percentage (e.g., 20 for 20%): ");
                double perc= scanner.nextDouble();
                scanner.nextLine();
                //creating a discount
                Admin.addSpecialDeal(Name,tcount,perc);

            } else if (choice == 2) {
                //update
                if (Admin.getSpecialDealListSize() == 0) {
                    System.out.println("Currently there are no Special Deals");
                } else {
                    HashMap<Integer, SpecialDeals> current = new HashMap<>();
                    int count = 1;
                    for(SpecialDeals i: Admin.specialDealsList){
                        current.put(count,i);
                        System.out.println(count+". "+i.toString());
                        count++;
                    }
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    if(choice1>=1 && choice1<=count){
                        SpecialDeals x =current.get(choice1);
                        //removing the special deal
                        Admin.specialDealsList.remove(x);
                        System.out.println("Special Deal Removed");
                    }
                }

            }else{
                System.out.println("Please enter a valid choice");
            }

        }
    }
}
