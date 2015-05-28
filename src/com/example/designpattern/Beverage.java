package com.example.designpattern;

/**
 * Created by laveen on 8/5/15.
 */
public class Beverage {

    private String addWater;
    private String addMilk;
    private String addSugar;
    private String addPowder;

    public void addWater(String water) {
        addWater =water;
    }

    public void addMilk(String milk) {
        addMilk =milk;
    }

    public void addSugar(String sugar) {
        addSugar =sugar;
    }

    public void addPowder(String powder) {
        addPowder =powder;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n",addWater,addMilk,addSugar,addPowder);
    }
}
