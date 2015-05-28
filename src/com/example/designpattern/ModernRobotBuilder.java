package com.example.designpattern;

/**
 * Created by laveen on 7/5/15.
 */
public class ModernRobotBuilder implements RobotBuilder {
    private Robot robot;

    public ModernRobotBuilder(){
        robot = new Robot("RT2015");
    }

    @Override
    public void buildRobotHead() {
        robot.setRobotHead("Metal Head");
    }

    @Override
    public void buildRobotArms() {
        robot.setRobotArms("Metal Arms");
    }

    @Override
    public void buildRobotLegs() {
        robot.setRobotLegs("Metal Legs");
    }

    @Override
    public Robot getRobot() {
        return robot;
    }
}
