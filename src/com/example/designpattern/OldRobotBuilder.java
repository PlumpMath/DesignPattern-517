package com.example.designpattern;

/**
 * Created by laveen on 7/5/15.
 */
public class OldRobotBuilder implements RobotBuilder {

    private Robot robot;

    public OldRobotBuilder(){
        robot = new Robot("RT1969");
    }

    @Override
    public void buildRobotHead() {
        robot.setRobotHead("Wodden Head");
    }

    @Override
    public void buildRobotArms() {
        robot.setRobotArms("Wodden Arms");
    }

    @Override
    public void buildRobotLegs() {
        robot.setRobotLegs("Wodden Legs");
    }

    @Override
    public Robot getRobot() {
        return robot;
    }
}
