package org.example.Animals;


public class Reptiles implements Animal {
    private String name;
    private final int id;
    private String noise;
    private String desc;

    public Reptiles(String name, String noise,String desc,int id) {
        this.name = name;
        this.noise = noise;
        this.id = id;
        this.desc=desc;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return "Reptile";
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void feed() {
        System.out.println(this.noise);
    }
    public String visit(){return this.visit();}
    @Override
    public String toString(){
        return this.id+"\t\t"+this.name;
    }
}