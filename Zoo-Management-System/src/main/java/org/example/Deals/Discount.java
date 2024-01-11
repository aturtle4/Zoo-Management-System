package org.example.Deals;
public class Discount {
    private final double discPerc;
    private final String discName;
    private boolean used;
    private final int upperBound;
    private final int lowerBound;
    public  Discount(String discName, double discPerc,int upperBound,int lowerBound){
        this.discName = discName;
        this.discPerc = discPerc;
        this.used = false;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public double getDiscPerc() {
        return this.discPerc;
    }
    public String getDiscName(){
        return this.discName;
    }

    public boolean isUsed() {
        return this.used;
    }

    public void Use(){
        System.out.println("Using deal "+this.discName+" to remove "+discPerc+"% from the final amount.");
        this.used = true;
    }
    @Override
    public String toString(){
        return this.discName+" ("+this.discPerc+") \nLower Age Limit: "+this.lowerBound+"\nUpper Age Limit: "+this.upperBound;
    }
}
