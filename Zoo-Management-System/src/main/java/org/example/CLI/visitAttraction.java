package org.example.CLI;
import org.example.Admin;
import org.example.Attractions;
import org.example.Visitors.Visitor;

import java.util.HashMap;
import java.util.Scanner;

public class visitAttraction {
    public visitAttraction(Visitor visitor){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Attractions> idMap = new HashMap<Integer, Attractions>();

        while (true) {
            System.out.println();
            System.out.println("Visit Attractions:");
            System.out.println("Select an Attraction to Visit:");
            int count = 1;
            for(Attractions i :Admin.attractionList){
                if(i.Open()){idMap.put(count,i);System.out.println(count+". "+i.getName());count++;}
            }
            System.out.println(count+ ". Exit");
            count++;
            System.out.print("Enter your choice: ");
            int min = 1;
            int max = count;
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= min && choice < max-1) {
                Attractions w = idMap.get(choice);
                HashMap<Attractions, Integer> d = visitor.getAttTickets();
                if (idMap.containsKey(choice) && (d.containsKey(w) || visitor.getType().equalsIgnoreCase("premium"))) {
                    if (d.isEmpty()) {
                        System.out.println(w.getDescription());
                        continue;
                    }
                    if (d.get(w) == 1) {
                        d.remove(w);
                    } else {
                        d.put(w, d.get(w) - 1);
                    }
                    System.out.println(w.getDescription());
                } else {
                    System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                }
            } else if (choice == max - 1) {
                return;
            } else {
                System.out.println("Please enter a valid choice.");
            }
        }
    }
}