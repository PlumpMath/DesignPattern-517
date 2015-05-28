package com.example.designpattern;

/**
 * Created by laveen on 8/5/15.
 */
public class BeverageMaker {
    private BeverageBuilder builder;

    public BeverageMaker(BeverageBuilder builder){
        this.builder = builder;
    }

    public Beverage makeBeverage(){
        builder.addWater();
        builder.addMilk();
        builder.addSugar();
        builder.addPowder();
        return builder.getBeverage();
    }
}
