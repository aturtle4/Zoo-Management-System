package org.example.Deals;

public class SpecialDeals {
    private final String Name;
    private final double perc;
    private final int tcount;
    public SpecialDeals(String name, double perc, int tcount) {
        this.Name = name;
        this.perc = perc;
        this.tcount = tcount;
    }
    public String getName(){return this.Name;}
    public double getPerc(){return this.perc;}
    public  int getTcount(){return this.tcount;}
    @Override
    public String toString(){
        return this.Name+" ("+this.perc+"%)\t[CONDITION:"+this.tcount+"ticket(S)]";
    }
}
