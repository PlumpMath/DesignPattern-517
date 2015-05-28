package com.example.designpattern;

/**
 * Created by laveen on 7/5/15.
 */
public class RobotEngineer {
    private RobotBuilder builder;

    public RobotEngineer(RobotBuilder builder) {
        this.builder = builder;
    }

    public Robot getRobot(){
       return builder.getRobot();
    }

    public void makeRobot(){
        builder.buildRobotHead();
        builder.buildRobotArms();
        builder.buildRobotLegs();
    }
}
