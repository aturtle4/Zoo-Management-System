# Zootopia

## File Structure

- `org.example.CLI`
    - `MainPage.java`: Represents the main menu of the zoo management system, allowing users to enter as an admin, visitor, view special deals, or exit.
    - `AdminPages.java`: Provides functionality for admin interactions, including managing animals and attractions, setting discounts, and special deals.
    - `exploreTheZoo.java`: Allows visitors to explore the zoo, view attractions, and animals.
    - `manageAnimals.java`: Handles animal management by admins, including adding, updating, and removing animals.
    - `manageAttractions.java`: Manages zoo attractions, enabling admins to add, view, modify, or remove attractions.
    - `setDiscounts.java`: Offers admin functionality to set discounts for visitors.
    - `setSpecialDeal.java`: Allows admins to set special deals for visitors.
    - `VisitorPage.java`: Implements the visitor interface, enabling visitors to register, log in, explore the zoo, buy memberships, purchase tickets, view discounts, special deals, visit animals, attractions, leave feedback, and log out.
    - `buyTickets.java`: Manages ticket purchase for visitors.
    - `visitAttraction.java`: Handles visitor interactions with attractions in the zoo.

- `org.example.Animals`
    - Contains animal-related classes such as `Animal`, `Mammals`, `Amphibians`, and `Reptiles`.
    - Animal class is an interface
- `org.example.Attractions`
    - Contains classes related to zoo attractions, such as `Attractions`.
- `org.example.Deals`
    - Contains classes for managing discounts and special deals, including `Discount` and `SpecialDeals`.

- `org.example.Visitors`
    - Includes classes representing different types of visitors, like `Visitor`, `Basic`, and `Premium`.
    - Visitor is an abstract class
    - JustCreated is a burner class
- `Admin.java`: Serves as the central class for administrative operations, managing lists of animals, attractions, visitors, discounts, and special deals. It keeps track of the zoo's financial data.

## Assumptions
```
-Please enter input precisely without unintentional whitespaces.
-Do not hit the enter/return key unnecessarily while giving input.
-Follow the prompts displayed on the console carefully.
-All the “Enter your choice” prompts expect an integer input.
-The program expects you to enter a proper phone number when prompted.
-The program expects the user to enter discount codes applicable to them. 
-The initial elements of the zoo are hard-coded. Changes can be made dynamically on running. 
-The most popular attraction is the attraction that sells the most tickets.
-The revenue is the sum of the money collected on the purchase of membership and tickets.
-Modifying attraction changes the description of the attraction. The price and open/close can be changed through schedueEvents functionality. Mistakes such as typing errors can be dealt with by deleting the attraction and creating a new one. A similar assumption is made for animals, deals, discounts, etc. 
-Default deals, discounts, attractions, etc. are hard-coded in and can be changed dynamically on running.
-Deals and discounts can only be applied to ticket purchases.
-While adding/updating animal the type should be either from "Mammal","Reptile","Amphibian"
-If the discount code is not defined before , it will directly pay the original amount before discount.
-Membership costs:
    -Premium:50
    -Basic:20
-The default state of each attraction after adding is closed
    so it has to be scheduled to make it available
-Discounts can be used for both Memberships and Tickets
-Deals can be used for only Tickets
-Pre-defined discounts
    -STUDENT10 :- eligible for ages between 5 and 20
    -SENIOR20 :- eligible for ages between 65 and 100
-Pre-defined Deals
    -B2G15 :- eligible for 2 or more tickets
    -B3G20 :- eligible for 3 or more tickets
-There is only one admin
-Admin login credentials:
    -Username: admin
    -Password: admin123
```
####  HOME_FOLDER   = **src**
```
All the commands should be run on the terminal in the HOME_FOLDER unless otherwise specified.

0) Download the src code folder from Classroom and unzip.
1) mvn clean 
2) mvn compile
3) mvn package
4)  java -jar .\A2_2022096-1.0-SNAPSHOT.jar
```