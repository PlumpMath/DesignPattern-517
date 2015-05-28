package com.example.designpattern;

/**
 * Created by laveen on 8/5/15.
 */
public interface BeverageBuilder {
    public void addWater();
    public void addSugar();
    public void addMilk();
    public void addPowder();
    public Beverage getBeverage();
}
