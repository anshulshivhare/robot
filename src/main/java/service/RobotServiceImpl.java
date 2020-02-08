package service;

import model.Robot;
import model.RobotResponse;
import utily.CalculationUtility;
import utily.DisplayUtils;

import static constant.RobotConstants.MAX_CHARGING_CAPACITY_IN_PERC;

public class RobotServiceImpl implements RobotService {

    private Robot robot;

    private RobotResponse robotResponse;

    public RobotServiceImpl() {
        this.robot = new Robot();
        robotResponse = new RobotResponse();
    }

    public RobotResponse walk(double distance) {
        int availableCharging = robot.getChargingCapacity();
        int requiredCharging = CalculationUtility.calculateRequiredChargingByDistance(distance);
        if (!CalculationUtility.isPowerAvailable(availableCharging, requiredCharging)) {
            DisplayUtils.displayInsufficientChargingMessage();
            robotResponse.setAbleToWalk(false);
        } else {
            CalculationUtility.changeHeadLightIfLessThan15Perc(robot, availableCharging, requiredCharging);
            System.out.println("Walked " + distance + "km | Charging Used " + requiredCharging + "% | Remaining  " + robot.getChargingCapacity() + "%");
            DisplayUtils.displayHeadLightColor(robot);
            robotResponse.setAbleToWalk(true);
        }
        robotResponse.setAvailableCapaciy(robot.getChargingCapacity());
        robotResponse.setRobotColor(robot.getHeadLightColor());
        return robotResponse;
    }

    public RobotResponse carry(int weight) {
        if (!CalculationUtility.isWeightOverLoaded(weight)) {
            int requiredCharging = CalculationUtility.calculateRequiredChargingByWeight(weight);
            int availableCharging = robot.getChargingCapacity();
            if (CalculationUtility.isPowerAvailable(availableCharging, requiredCharging)) {
                CalculationUtility.changeHeadLightIfLessThan15Perc(robot, availableCharging, requiredCharging);
                System.out.println("Carried " + weight + "kg | Charging Used " + requiredCharging + "% | Remaining  " + robot.getChargingCapacity() + "%");
                DisplayUtils.displayHeadLightColor(robot);
                robotResponse.setAbleToWalk(true);
                robotResponse.setAbleToCarryWeight(true);
            } else {
                DisplayUtils.displayInsufficientChargingMessage();
                robotResponse.setAbleToWalk(false);
                robotResponse.setAbleToCarryWeight(false);
            }
        } else {
            robotResponse.setAbleToWalk(false);
            robotResponse.setAbleToCarryWeight(false);
            DisplayUtils.displayOverloadedMessage(weight);
        }
        robotResponse.setAvailableCapaciy(robot.getChargingCapacity());
        robotResponse.setRobotColor(robot.getHeadLightColor());
        return robotResponse;
    }

    public RobotResponse walkAndCarry(double distance, int weight) {
        if (!CalculationUtility.isWeightOverLoaded(weight)) {
            int requiredCharging = CalculationUtility.calculateRequiredChargingByDistanceAndWeight(distance, weight);
            int availableCharging = robot.getChargingCapacity();
            if (CalculationUtility.isPowerAvailable(availableCharging, requiredCharging)) {
                CalculationUtility.changeHeadLightIfLessThan15Perc(robot, availableCharging, requiredCharging);
                System.out.println("Walked " + distance + "km and Carried " + weight + "kg | Charging Used " + requiredCharging + "% | Remaining  " + robot.getChargingCapacity() + "%");
                DisplayUtils.displayHeadLightColor(robot);
                robotResponse.setAbleToWalk(true);
                robotResponse.setAbleToCarryWeight(true);
            } else {
                robotResponse.setAbleToWalk(false);
                robotResponse.setAbleToCarryWeight(false);
                DisplayUtils.displayInsufficientChargingMessage();
            }
        } else {
            robotResponse.setAbleToWalk(false);
            robotResponse.setAbleToCarryWeight(false);
            DisplayUtils.displayOverloadedMessage(weight);
        }
        robotResponse.setAvailableCapaciy(robot.getChargingCapacity());
        robotResponse.setRobotColor(robot.getHeadLightColor());
        return robotResponse;
    }

    public int addAndGetUpdateCharging(int chargingPercentage) {
        int availableChargingCapacity = robot.getChargingCapacity();
        int updatedChargingCapacity;
        if (CalculationUtility.isChargingPercentageNeeded(chargingPercentage, availableChargingCapacity)) {
            updatedChargingCapacity = CalculationUtility.addChargingCapacity(chargingPercentage, availableChargingCapacity);
            robot.setChargingCapacity(updatedChargingCapacity);
        } else {
            robot.setChargingCapacity(MAX_CHARGING_CAPACITY_IN_PERC);
            updatedChargingCapacity = MAX_CHARGING_CAPACITY_IN_PERC;
        }
        DisplayUtils.displayUpdatedChargingCapacity(updatedChargingCapacity);
        return robot.getChargingCapacity();
    }

    public void displayPrice(int barCode) {
        if (barCode % 2 == 0) {
            DisplayUtils.displayBarcodePrice();
        } else {
            DisplayUtils.failureScan();
        }
    }
}
