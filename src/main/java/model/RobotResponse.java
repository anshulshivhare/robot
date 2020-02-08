package model;

import constant.Color;

public class RobotResponse {

    int availableCapaciy;
    boolean isAbleToWalk;
    boolean isAbleToCarryWeight;
    Color robotColor;

    public int getAvailableCapaciy() {
        return availableCapaciy;
    }

    public void setAvailableCapaciy(int availableCapaciy) {
        this.availableCapaciy = availableCapaciy;
    }

    public boolean isAbleToWalk() {
        return isAbleToWalk;
    }

    public void setAbleToWalk(boolean ableToWalk) {
        isAbleToWalk = ableToWalk;
    }

    public boolean isAbleToCarryWeight() {
        return isAbleToCarryWeight;
    }

    public void setAbleToCarryWeight(boolean ableToCarryWeight) {
        isAbleToCarryWeight = ableToCarryWeight;
    }

    public Color getRobotColor() {
        return robotColor;
    }

    public void setRobotColor(Color robotColor) {
        this.robotColor = robotColor;
    }
}
