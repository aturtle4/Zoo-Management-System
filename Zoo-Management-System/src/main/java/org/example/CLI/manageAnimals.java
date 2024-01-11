package org.example.CLI;

import org.example.Admin;
import org.example.Animals.Amphibians;
import org.example.Animals.Animal;
import org.example.Animals.Mammals;
import org.example.Animals.Reptiles;

import java.util.Scanner;

public class manageAnimals extends Admin {
    private final static Scanner scanner = new Scanner(System.in);
    public  manageAnimals(Admin admin) {
        while (true) {
            System.out.println("Manage Animals: ");
            System.out.println("1. Add Animal");
            System.out.println("2. Update Animal Details");
            System.out.println("3. Remove Animal");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int inp = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (inp) {
                case 1:
                    // Add animal
                    System.out.print("Enter Animal name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter animal type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter the noise that the animal makes: ");
                    String noise = scanner.nextLine();
                    System.out.print("Enter the description of the animal : ");
                    String desc = scanner.nextLine();

                    if (isValidAnimalType(type)) {
                        addAnimal(name,type,noise,desc);
                    } else {
                        System.out.println("Please enter a proper animal type (Mammals, Amphibians, or Reptiles).");
                    }
                    break;
                case 2:
                    // Update animal details
                    if (getAnimalListSize() == 0) {
                        System.out.println("No animals in the zoo currently.");
                    } else {
                        printAnimals();
                        System.out.print("Enter the animal id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        boolean animalUpdated = false;

                        for (Animal i : animalList) {
                            if (i.getID() == id) {
                                System.out.println("Please enter the updated data:");
                                System.out.print("Enter Animal's updated name: ");
                                String nname = scanner.nextLine();
                                System.out.print("Enter animal's updated type: ");
                                String ntype = scanner.nextLine();
                                System.out.print("Enter the updated noise that the animal makes: ");
                                String nnoise = scanner.nextLine();
                                System.out.print("Enter the updated description of the animal: ");
                                String ndesc = scanner.nextLine();

                                if (isValidAnimalType(ntype)) {
                                    switch(ntype) {
                                        case ("Mammal"):
                                            animalList.set(id - 1, new Mammals(nname, nnoise,ndesc, id));
                                        case ("Reptile"):
                                            animalList.set(id - 1, new Reptiles(nname, nnoise,ndesc, id));
                                        case ("Amphibian"):
                                            animalList.set(id - 1, new Amphibians(nname, nnoise,ndesc, id));
                                    }
                                    System.out.println("Animal successfully updated.");
                                    animalUpdated = true;
                                } else {
                                    System.out.println("Please enter a proper animal type (Mammals, Amphibians, or Reptiles).");
                                }
                                break;
                            }
                        }

                        if (!animalUpdated) {
                            System.out.println("Please enter a valid animal ID.");
                        }
                    }
                    break;
                case 3:
                    // Remove animal
                    if (getAnimalListSize() == 0) {
                        System.out.println("No animals to remove.");
                    } else {
                        printAnimals();
                        System.out.println();
                        System.out.print("Enter the animal id to remove: ");
                        int delid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        boolean animalRemoved = false;

                        // Check if removing this animal will violate the minimum requirement
                        Animal animalToRemove = null;
                        for (Animal i : animalList) {
                            if (i.getID() == delid) {
                                animalToRemove = i;
                                break;
                            }
                        }
                        if (animalToRemove != null) {
                            String animalType = animalToRemove.getType();
                            int animalCount = 0;
                            for (Animal animal : animalList) {
                                if (animal.getType().equals(animalType)) {
                                    animalCount++;
                                }
                            }
                            if (animalCount < 3) {
                                System.out.println("Cannot remove the animal. There must be at least two animals of each type in the zoo.");
                                System.out.println("The zoo will be closed for visitors.");
                                return;
                            }

                            animalList.remove(animalToRemove);
                            System.out.println("Animal successfully removed.");
                            animalRemoved = true;
                        }

                        if (!animalRemoved) {
                            System.out.println("Please enter a valid ID to remove the animal.");
                        }
                    }
                    break;
                case 4:
                    // Exit
                    return;
                default:
                    System.out.println("Please enter a valid choice.");
            }
        }
    }

    private boolean isValidAnimalType(String type) {
        return type.equalsIgnoreCase("Mammal") || type.equalsIgnoreCase("Amphibian") || type.equalsIgnoreCase("Reptile");
    }


}
