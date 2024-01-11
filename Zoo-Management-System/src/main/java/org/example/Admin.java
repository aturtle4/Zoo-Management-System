package org.example;
import org.example.Animals.*;
import org.example.Visitors.*;
import org.example.Deals.*;
import java.util.*;


public class Admin {
    //here i am assuming that we have only one admin and have thus created only one username and passd based on the sample run
    final  protected String Username = "admin";
    final protected String Password = "admin123";
    final static private Scanner scanner = new Scanner(System.in);

    protected static ArrayList<Visitor> visitorList = new ArrayList<Visitor>();
    public static ArrayList<Attractions> attractionList = new ArrayList<Attractions>();
    public static ArrayList<Animal> animalList = new ArrayList<Animal>();
    protected  static HashMap<String,String> feedbackList = new HashMap<>();
    public static ArrayList<Discount> discountList = new ArrayList<>();
    public static ArrayList<SpecialDeals> specialDealsList = new ArrayList<>();
    public static double totalRevenue;

    public Admin() {
    }


    // for logging in
    public String getUserName(){
        return this.Username;
    }
    public String getPasword(){
        return this.Password;
    }

    //for visitor list
    public static ArrayList<Visitor> getVisitorList(){
        return visitorList;
    }
    private static int getVisitorListSize(){
        return visitorList.size();
    }
    private static void addtoVisitorList(Visitor visitor){
        visitorList.add(visitor);
    }
    public static void addVisitor(String name, int age, String pho, double bal,String email,String pass){
        // i am assuming that whenever a visitor registered he gets registered as a basic
        // and he/she has to buy premium later on after loging in
        Visitor x = new JustCreated(name, age, pho, bal, email, pass);
        addtoVisitorList(x);
        System.out.println("Registration is successful.");
        /*
        ArrayList<Visitor> y = getVisitorList();
        System.out.println(y);
        */
    }


    //for attractions list
    static ArrayList<Attractions> getAttractionList(){
        return attractionList;
    }
    public static int getAttractionListSize(){
        return attractionList.size();
    }
    private static void addtoAttractionList(Attractions attraction){
        attractionList.add(attraction);
    }
    public static void addAttraction(String name,String desc,String buyPhrase){
        Attractions x = new Attractions(name,desc,buyPhrase);
        addtoAttractionList(x);
        System.out.println("Registration is successful.");
    }


    public static void printAttractions(){
        for (Attractions attraction : attractionList) {
            System.out.println(attraction.getID()+". "+attraction.getName());
        }
    }
    //for animals list
    static ArrayList<Animal> getAnimalList(){
        return animalList;
    }
    protected static int getAnimalListSize(){
        return animalList.size();
    }
    private static void addtoAnimalList(Animal animal){
        animalList.add(animal);
    }
    public static void addAnimal(String name,String type,String noise,String desc){

        Animal newAnimal = null;
        if(Objects.equals(type,"Mammal")){newAnimal = new Mammals(name, noise, desc, getAnimalListSize() + 1);}
        if(Objects.equals(type,"Amphibian")){newAnimal = new Amphibians(name, noise, desc, getAnimalListSize() + 1);}
        if(Objects.equals(type,"Reptile")){newAnimal = new Reptiles(name, noise, desc, getAnimalListSize() + 1);}

        if (newAnimal != null) {
            addtoAnimalList(newAnimal);
            System.out.println("Animal added successfully.");

        } else {
            System.out.println("Invalid animal type.");
        }
    }



    public static void printAnimals(){
        System.out.println();
        for (Animal i: animalList){
            System.out.println(i.toString());
        }
    }


    //for scheduling events
    public void schedEvents(int choice){
        Attractions x = attractionList.get(choice-1);
        System.out.print("Enter the state of this attraction(open/closed): ");
        String inp = scanner.nextLine();
        //scanner.nextLine();
        boolean state = inp.equals("open");
        x.setOpen(state);
        System.out.println("State successfully changed");
        if(!state){return;}
        x.setTickets(0);
        System.out.print("Enter the price for this attraction: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        x.setPrice(price);
        System.out.println("Price successfully added");
    }

    //for  discounts
    static ArrayList<Discount> getDiscountList(){return discountList;}
    public static int getDiscountListSize(){return discountList.size();}
    private static void addtoDiscountList(Discount discount){
        discountList.add(discount);
    }
    public static void addDiscount(String name,int lower,int upper,double perc){
        Discount x = new Discount(name,perc,upper,lower);
        addtoDiscountList(x);
        System.out.println("Discount added successfully.");
    }
    protected static void printDiscount(){
        for (Discount discount : discountList) {
            System.out.println(discount.toString());
        }
    }

    //for special deals
    static ArrayList<Discount> getSpecialDealList(){return discountList;}
    public static int getSpecialDealListSize(){return discountList.size();}
    private static void addtoSpecialDealList(SpecialDeals specialDeals){specialDealsList.add(specialDeals);
    }
    public static void addSpecialDeal(String name,int tcount,double perc){
        SpecialDeals x = new SpecialDeals(name,perc,tcount);
        addtoSpecialDealList(x);
        System.out.println("Special Deal added successfully.");
    }
    public static void printSpecialDeals(){
        for (SpecialDeals specialDeals : specialDealsList) {
            System.out.println(specialDeals.toString());
        }
        System.out.println();
    }
}
