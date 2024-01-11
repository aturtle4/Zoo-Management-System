package org.example.Animals;

public class Mammals implements Animal {
    private final String name;
    private final int id;
    private final String noise;
    private final String desc;

    public Mammals(String name, String noise,String desc,int id) {
        this.name = name;
        this.noise = noise;
        this.id = id;
        this.desc = desc;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return "Mammal";
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void feed() {
        System.out.println(this.noise);
    }
    public String visit(){return this.desc;}
    @Override
    public String toString(){
        return this.id+"\t\t"+this.name;
    }
}