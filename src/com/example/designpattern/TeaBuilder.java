package com.example.designpattern;

/**
 * Created by laveen on 8/5/15.
 */
public class TeaBuilder implements BeverageBuilder {
    private Beverage beverage;

    public TeaBuilder() {
        beverage = new Beverage();
    }

    @Override
    public void addWater() {
        beverage.addWater("Added water to Tea");
    }

    @Override
    public void addSugar() {
        beverage.addSugar("Added sugar to Tea");
    }

    @Override
    public void addMilk() {
        beverage.addMilk("Added milk to Tea");
    }

    @Override
    public void addPowder() {
        beverage.addPowder("Added powder to Tea");
    }

    @Override
    public Beverage getBeverage() {
        return beverage;
    }
}
