package org.example.Visitors;


public class Basic extends Visitor {
    public Basic(String name, int age, String pho, double bal, String email, String pass) {
        super(name, age, pho, bal, email, pass, "Basic");
    }

}
