package org.example.Visitors;


public class Premium extends Visitor {
    public Premium(String name, int age, String pho, double bal, String email, String pass) {
        super(name, age, pho, bal, email, pass, "Premium");
    }

}
