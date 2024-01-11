package org.example.CLI;

import org.example.Admin;
import org.example.Attractions;

import java.util.Scanner;

public class exploreTheZoo  {
    public exploreTheZoo(){
        while (true){
            System.out.println("Explore the Zoo: ");
            System.out.println("1. View Attractions");
            System.out.println("2. View Animals");
            System.out.println("3. Exit");
            int min = 1;
            int max= 3;
            System.out.println();
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int inp = scanner.nextInt();
            scanner.nextLine();
            if(inp>=min && inp<=max){
                switch (inp) {
                    case (1) -> {
                        if (Admin.attractionList.isEmpty()) {
                            System.out.println("There are currently no Attractions in the Zoo.\nPlease come later.");
                            break;
                        }
                        for (Attractions i : Admin.attractionList) {
                            int id = i.getID();
                            String name = i.getName();
                            String availability = "Unavailable";
                            if (i.Open()) {
                                availability = "Available";
                            }
                            System.out.println(id + ". " + name + "[" + availability + "]");
                        }
                        int min_ = 1;
                        int max_ = Admin.attractionList.size();
                        System.out.print("Enter a choice: ");
                        int choice1 = scanner.nextInt();
                        scanner.nextLine();
                        if (choice1 >= min && choice1 <= max) {
                            Attractions x = Admin.attractionList.get(choice1 - 1);
                            if (!x.Open()) {
                                System.out.println("Unavailable");
                            } else {
                                System.out.println(x.getBuyPhrase());
                            }
                        } else {
                            System.out.println("Please enter a valid choice!!");
                        }
                    }
                    case (2) -> {
                        if (Admin.animalList.isEmpty()) {
                            System.out.println("There are currently no Animals in the Zoo.\nPlease come later.");
                            break;
                        }
                        Admin.printAnimals();
                    }
                    case (3) -> {
                        return;
                    }
                }
            }else{System.out.println("Please enter valid choice");}
        }
    }
}
