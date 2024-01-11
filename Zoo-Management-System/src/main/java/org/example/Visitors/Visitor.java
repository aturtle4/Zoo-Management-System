package org.example.Visitors;

import org.example.Attractions;
import java.util.HashMap;

public abstract class Visitor {
    private String Name;
    private int Age;
    private String pho;
    private double bal;
    private String email;
    private String password;
    private String type;
    private HashMap<Attractions,Integer> attTickets = new HashMap<>();
    public Visitor(String name, int age, String pho, double bal, String email, String pass, String type) {
        this.Name = name;
        this.Age = age;
        this.pho = pho;
        this.bal = bal;
        this.email = email;
        this.password = pass;
        this.type = type;
    }


    public String getName() {
        return this.Name;
    }

    public int getAge() {
        return this.Age;
    }

    public String getPho() {
        return this.pho;
    }

    public double getBal() {
        return this.bal;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
    public HashMap<Attractions,Integer> getAttTickets(){return this.attTickets;}
    public void addAttTickets(Attractions attraction, int amt){
        if (attraction != null && amt > 0) {
            if (attTickets.containsKey(attraction)) {
                int currentCount = attTickets.get(attraction);
                attTickets.put(attraction, currentCount + amt);
            } else {
                attTickets.put(attraction, amt);
            }
            //System.out.println(amt + " ticket(s) added to " + attraction.getName());
        } else {
            System.out.println("Invalid input. Please provide a valid attraction and a positive ticket amount.");
        }    }

    public String getType() {
        return this.type;
    }
    public void setBal(double nbal){this.bal = nbal;}
}

