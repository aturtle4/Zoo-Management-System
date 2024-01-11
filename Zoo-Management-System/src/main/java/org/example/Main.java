package org.example;
import org.example.CLI.MainPage;
public class Main {
    public static void main(String[] args) {
        // add Animals
        Admin.addAnimal("Lion", "Mammal", "Roar", "The king of the jungle");
        Admin.addAnimal("Tiger", "Mammal", "Growl", "The striped predator");
        Admin.addAnimal("Frog", "Amphibian", "Croak", "The hopping amphibian");
        Admin.addAnimal("Salamander", "Amphibian", "Squeak", "The slimy creature");
        Admin.addAnimal("Snake", "Reptile", "Hiss", "The slithering reptile");
        Admin.addAnimal("Turtle", "Reptile", "Grunt", "The slow-moving reptile");

        //Add special deals
        Admin.addSpecialDeal("B2G15",2,15);
        Admin.addSpecialDeal("B3G20",3,20);

        // Add attractions
        Admin.addAttraction("Safari Ride", "Experience the thrill of a safari", "Get your tickets now!");
        Admin.addAttraction("Aquarium", "Discover the wonders of the underwater world", "Dive into the adventure!");
        Admin.addAttraction("Bird Show", "Witness the beauty of flying creatures", "Fly high with us!");
        Admin.addDiscount("STUDENT10",5,20,10);
        Admin.addDiscount("SENIOR20",65,100,20);
        System.out.println("Welcome to Zootopia!");
        new MainPage();
    }
}