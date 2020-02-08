package utily;

import constant.Color;
import model.Robot;

import static constant.RobotConstants.MAX_CHARGING_CAPACITY_IN_PERC;

public class CalculationUtility {

    public static boolean isChargingPercentageNeeded(int currentChargingCapacity,
                                                     int availableChargingCapacity) {

        if (addChargingCapacity(currentChargingCapacity, availableChargingCapacity) > MAX_CHARGING_CAPACITY_IN_PERC) {
            return false;
        }
        return true;
    }

    public static int addChargingCapacity(int currentChargingCapacity,
                                          int availableChargingCapacity) {

        return currentChargingCapacity + availableChargingCapacity;
    }

    public static int calculateRequiredChargingByDistance(double distance) {
        return (int) ((distance * 1000) / 50);
    }

    public static int calculateRequiredChargingByWeight(int weight) {
        return 2 * weight;
    }

    public static boolean isPowerAvailable(int availableChecking, int requiredCharging) {
        if (availableChecking < requiredCharging) {
            return false;
        }
        return true;
    }

    public static boolean isChargingLessThan15Perc(int remainingCharging) {
        if (remainingCharging < 15) {
            return true;
        }
        return false;
    }

    public static int getRemainingCharging(int availableCharging, int requiredCharging) {
        return availableCharging - requiredCharging;
    }

    public static boolean isWeightOverLoaded(int weight) {
        return weight > 10;
    }

    public static int calculateRequiredChargingByDistanceAndWeight(double distance, int weight) {
        return calculateRequiredChargingByDistance(distance) + calculateRequiredChargingByWeight(weight);
    }

    public static void changeHeadLightIfLessThan15Perc(Robot robot, int availableCharging, int requiredCharging) {
        int remainingCharging = getRemainingCharging(availableCharging, requiredCharging);
        robot.setChargingCapacity(remainingCharging);
        if (isChargingLessThan15Perc(remainingCharging)) {
            robot.setHeadLightColor(Color.RED);
        }
    }

}