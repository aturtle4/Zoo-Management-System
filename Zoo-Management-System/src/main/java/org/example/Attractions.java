package org.example;

public class Attractions {
    private String Name;
    private int id;
    private String description;
    private double  price;
    private String buyPhrase;
    private boolean open;
    private int tickets;
    private int bought_tickets;

    public Attractions(String name,String desc,String buyPhrase){
        this.Name = name;
        this.description = desc;
        this.buyPhrase = buyPhrase;
        this.id = Admin.getAttractionListSize() + 1;
        this.bought_tickets = 0;
        this.open = false;
    }
    public int getID(){return this.id;}
    public String getName(){return this.Name;}
    public String getDescription(){return this.description;}
    public double getPrice(){return this.price;}
    public String getBuyPhrase(){return this.buyPhrase;}
    public void setName(String name){this.Name = name;}
    public void setDescription(String desc){this.description = desc;}
    public void setPrice(double nprice){this.price=nprice;}
    public void setOpen(boolean nopen){this.open=nopen;}
    public void setTickets(int amt){this.tickets = amt;}
    public int getTickets(){return this.tickets;}
    public boolean Open(){return this.open;}
    public void bTickets(){this.bought_tickets++;}
    public int getBoughtTickets(){return this.bought_tickets;}
    @Override
    public String toString(){
        String state;
        if(this.open){state="Open";}else{state="Closed";}
        return this.id+"\t\t"+this.Name + "\t\t" + this.description + "\t\t" +this.buyPhrase+ "\t\t" + this.price+"\t\t"+state+"\t\t"+this.tickets;
    }

    public void setBuyPhrase(String buyPhrase) {
        this.buyPhrase = buyPhrase;
    }
}
