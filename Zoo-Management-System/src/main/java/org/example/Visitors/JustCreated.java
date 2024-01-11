package org.example.Visitors;

public class JustCreated extends Visitor{
    public JustCreated(String name, int age, String pho, double bal, String email, String pass) {
        super(name, age, pho, bal, email, pass, "default");
    }

}
