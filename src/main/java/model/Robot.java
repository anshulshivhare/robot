package model;

import constant.Color;

import static constant.RobotConstants.MAX_CHARGING_CAPACITY_IN_PERC;
import static constant.RobotConstants.MAX_WEIGHT_CAPCITY;
import static constant.RobotConstants.MAX_WALK_CAPACITY;

public class Robot {

    private int chargingCapacity;
    private Color headLightColor;
    private int weightCapacity;
    private int walkCapacity;

    public Robot() {
        this.chargingCapacity = MAX_CHARGING_CAPACITY_IN_PERC;
        this.walkCapacity = MAX_WALK_CAPACITY;
        this.weightCapacity = MAX_WEIGHT_CAPCITY;
        this.headLightColor = Color.GREEN;
    }

    public int getChargingCapacity() {
        return chargingCapacity;
    }

    public void setChargingCapacity(int chargingCapacity) {
        this.chargingCapacity = chargingCapacity;
    }

    public Color getHeadLightColor() {
        return headLightColor;
    }

    public void setHeadLightColor(Color headLightColor) {
        this.headLightColor = headLightColor;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public int getWalkCapacity() {
        return walkCapacity;
    }

    public void setWalkCapacity(int walkCapacity) {
        this.walkCapacity = walkCapacity;
    }
}
