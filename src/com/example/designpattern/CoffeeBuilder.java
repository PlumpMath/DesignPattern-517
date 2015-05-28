package com.example.designpattern;

/**
 * Created by laveen on 8/5/15.
 */
public class CoffeeBuilder implements BeverageBuilder {

    private Beverage beverage;

    public CoffeeBuilder() {
        beverage = new Beverage();
    }

    @Override
    public void addWater() {
        beverage.addWater("Added water to Coffee");
    }

    @Override
    public void addSugar() {
        beverage.addSugar("Added sugar to Coffee");
    }

    @Override
    public void addMilk() {
        beverage.addMilk("Added milk to Coffee");
    }

    @Override
    public void addPowder() {
        beverage.addPowder("Added powder to Coffee");
    }

    @Override
    public Beverage getBeverage() {
        return  beverage;
    }
}
