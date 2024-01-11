package org.example.CLI;
import org.example.Attractions;
import org.example.Admin;
import java.util.Scanner;

public class manageAttractions extends AdminPages{
    private static final Scanner scanner = new Scanner(System.in);
    public   manageAttractions(Admin admin) {
        while (true) {
            System.out.println("Manage Attractions:");
            System.out.println("1. Add Attraction");
            System.out.println("2. View Attractions");
            System.out.println("3. Modify Attraction");
            System.out.println("4. Remove Attraction");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int inp = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (inp) {
                case 1 -> {
                    // Add attraction
                    System.out.print("Enter Attraction Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Attraction Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter Attraction Buy Phrase: ");
                    String buyPhrase = scanner.nextLine();
                    addAttraction(name, desc, buyPhrase);
                    System.out.println("Attraction added successfully.");
                    System.out.println();
                }
                case 2 -> {
                    // View attractions
                    for (Attractions i : attractionList) {
                        System.out.println(i.toString());
                    }
                }
                case 3 -> {
                    // Modify attraction
                    if (getAttractionListSize() == 0) {
                        System.out.println("There are no attractions currently.");
                    } else {
                        for (Attractions i : attractionList) {
                            System.out.println(i.toString());
                        }
                        System.out.println();
                        System.out.print("Enter the attraction ID to modify: ");
                        int upid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        boolean attractionModified = false;

                        for (Attractions i : attractionList) {
                            if (i.getID() == upid) {
                                System.out.print("Enter updated Attraction Name: ");
                                String nname = scanner.nextLine();
                                System.out.print("Enter updated Attraction Description: ");
                                String ndesc = scanner.nextLine();
                                System.out.print("Enter updated Attraction Buy Phrase: ");
                                String nbphrase = scanner.nextLine();
                                i.setName(nname);
                                i.setDescription(ndesc);
                                i.setBuyPhrase(nbphrase);
                                System.out.println("Attraction successfully modified.");
                                attractionModified = true;
                                break;
                            }
                        }

                        if (!attractionModified) {
                            System.out.println("Please enter a correct ID.");
                        }
                    }
                }
                case 4 -> {
                    // Remove attraction
                    if (getAttractionListSize() == 0) {
                        System.out.println("There are no attractions to remove.");
                    } else {
                        for (Attractions i : attractionList) {
                            System.out.println(i.toString());
                        }
                        System.out.println();
                        System.out.print("Enter the attraction ID to remove: ");
                        int delid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        boolean attractionRemoved = false;

                        for (Attractions i : attractionList) {
                            if (i.getID() == delid) {
                                attractionList.remove(i);
                                System.out.println("Attraction successfully removed.");
                                attractionRemoved = true;
                                break;
                            }
                        }

                        if (!attractionRemoved) {
                            System.out.println("Please enter a valid ID to remove the Attraction.");
                        }
                    }
                }
                case 5 -> {
                    // Exit
                    //scanner.close();
                    return;
                }
                default -> System.out.println("Please enter a valid choice.");
            }

        }
        //return;
    }

}
