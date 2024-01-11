package org.example.CLI;

import org.example.Admin;
import org.example.Attractions;

import java.util.Scanner;

public class AdminPages extends Admin {
    private static final Scanner scanner  = new Scanner(System.in);
    public static void AdminLoginPage() {

        System.out.print("Enter Admin Username: ");
        String name = scanner.next();
        System.out.print("Enter Admin Password: ");
        String pass = scanner.next();
        System.out.println();
        Admin x = new Admin();
        if (!(x.getUserName().equals(name) && x.getPasword().equals(pass))) {
            x = null;
            System.out.println("Incorrect username or password provided");
        } else {
            System.out.println("Logged in as Admin");
            Adminmenu(x);
        }
    }

    static void Adminmenu(Admin admin) {
        while(true) {
            System.out.println("Admin Menu: ");
            System.out.println("1. Manage Attractions");
            System.out.println("2. Manage Animals");
            System.out.println("3. Schedule Events");
            System.out.println("4. Set Discounts");
            System.out.println("5. Set Special Deals");
            System.out.println("6. View Visitor Stats");
            System.out.println("7. View Feedback");
            System.out.println("8. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int inp = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (inp) {
                case 1:
                    // manage Attractions
                    new manageAttractions(admin);
                    break;
                case 2:
                    //manage Animals
                    new manageAnimals(admin);
                    break;
                case 3:
                    // Schedule Events
                    for(Attractions i: attractionList){
                        System.out.println(i.getID()+". "+i.getName()+"["+i.Open()+","+i.getPrice()+"]"+"( No. of tickets bought "+i.getBoughtTickets()+")");
                    }
                    System.out.print("Enter id which is to be scheduled: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    int min = 1;
                    int max = getAttractionListSize()+1;
                    if (!(choice>=min && choice<max)){
                        System.out.println("Please enter a valid input");
                        break;
                    }
                    admin.schedEvents(choice);
                    break;
                case 4:
                    // Set discounts
                    System.out.println();
                    new setDiscounts();
                    break;
                case 5:
                    // Set special deals
                    System.out.println();
                    new setSpecialDeal();
                    break;
                case 6:
                    // View visitor stats
                    System.out.println("Total zoo revenue: " + Admin.totalRevenue);
                    System.out.println("Total number of visitors: " + Admin.getVisitorList().size());

                    int max_ = 0;
                    Attractions out_ = null;
                    for (Attractions i : attractionList) {
                        if (i.getBoughtTickets() >= max_) {
                            max_ = i.getBoughtTickets();
                            out_ = i;
                        }
                    }
                    if (out_ != null) {
                        System.out.println("Most famous Attraction is: " + out_.getName());
                    }
                    break;
                case 7:
                    // Visitor feedback
                    System.out.println("Feedbacks:");
                    for(String i:feedbackList.keySet()){
                        System.out.println("\n"+i+"->"+feedbackList.get(i)+"\n");
                    }
                    break;
                case 8:
                    // Exit to the main menu
                    return;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }

}
