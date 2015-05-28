package com.example.designpattern;

/**
 * Created by laveen on 7/5/15.
 */
public class Robot implements RobotType {
    private String robotHead;
    private String robotArms;
    private String robotLegs;
    private String robotName;

    public Robot(String name){
        robotName = name;
    }

    @Override
    public void setRobotHead(String head) {
        robotHead = head;
    }

    public String getRobotHead(){
        return robotHead;
    }

    @Override
    public void setRobotArms(String arms) {
        robotArms = arms;
    }

    public String getRobotArms(){
        return robotArms;
    }

    @Override
    public void setRobotLegs(String legs) {
        robotLegs = legs;
    }

    public String getRobotLegs(){
        return robotLegs;
    }

    @Override
    public String toString() {
        return String.format("Name: %s Detail: %s - %s - %s",robotName,robotHead,robotArms,robotLegs);
    }
}
