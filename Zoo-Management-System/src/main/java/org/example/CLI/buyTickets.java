package org.example.CLI;

import org.example.Admin;
import org.example.Attractions;
import org.example.Deals.*;
import org.example.Visitors.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class buyTickets {
    private static final Scanner scanner = new Scanner(System.in);

    public buyTickets(Visitor visitor) {

        if (visitor instanceof Premium) {
            System.out.println("All Attractions are free");
            return;
        }

        int totalTickets = 0;
        double totalCost = 0.0;
        ArrayList<Attractions> cart = new ArrayList<>();
        while (true) {
            System.out.println();
            System.out.println("Buy Tickets: ");
            System.out.print("Enter number of tickets: ");
            int n = scanner.nextInt();
            totalTickets += n;
            System.out.println("Select an Attraction to buy: ");
            HashMap<Integer,Attractions> available = new HashMap<>();
            for (int k = 0; k < n; k++) {
                int count =1;
                for(Attractions i: Admin.attractionList) {
                    if (i.Open()) {
                        available.put(count,i);
                        System.out.println(count + ". " + i.getName() + " [" + i.getPrice() + "]");
                        count++;
                    }
                }
                System.out.print("Enter your choice: ");
                int min = 1;
                int choice = scanner.nextInt();
                scanner.nextLine();
                int max = count;

                if (choice >= min && choice <= max) {
                    Attractions w = null;
                    if(available.containsKey(choice)){
                        w = available.get(choice);
                    }

                    if (w != null) {
                        totalCost += w.getPrice();
                        cart.add(w);
                        //w.setTickets(w.getTickets() + 1);
                        visitor.addAttTickets(w, 1);
                    }
                }
            }

            System.out.print("Do you want to buy more tickets (Y/N)? ");
            String buyMore = scanner.nextLine();
            if (!buyMore.equalsIgnoreCase("Y")) {
                break;
            }
        }

        System.out.print("Enter discount code: ");
        String disc = scanner.nextLine();
        for (Discount i : Admin.discountList) {
            if (i.getDiscName().equals(disc)) {
                if(!(visitor.getAge()>=i.getLowerBound() && visitor.getAge()<=i.getUpperBound())){System.out.println("Not eligible for the discount");break;}
                Admin.discountList.remove(i);   //removing a discount after it is getting used
                double perc = i.getDiscPerc();
                double discount = (perc / 100) * totalCost;
                totalCost -= discount;
                break;
            }
        }
        System.out.println(totalCost);
        double discount = 0;
        for (SpecialDeals specialDeal : Admin.specialDealsList) {
            if (totalTickets >= specialDeal.getTcount()) {
                //getting best and valid special deal out
                if(specialDeal.getPerc() >= discount){discount = specialDeal.getPerc();}
            }
        }
        discount = (discount/100)*totalCost;
        totalCost -= discount;

        if (visitor.getBal() < totalCost) {
            System.out.println("Please top-up balance");
        } else {
            visitor.setBal(visitor.getBal() - totalCost);
            Admin.totalRevenue += totalCost;
            for (Attractions i: cart){
                i.setTickets(i.getTickets() + 1);
                i.bTickets();
            }
            System.out.println("The tickets were purchased successfully. Your balance is now $" + visitor.getBal());
        }
    }
}
