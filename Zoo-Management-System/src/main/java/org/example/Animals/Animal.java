package org.example.Animals;

public interface Animal  {
    String getName();
    String getType();
    int getID();
    void feed();
    @Override
    String toString();
    String visit();
}