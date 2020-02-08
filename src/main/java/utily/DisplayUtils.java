package utily;

import constant.Color;
import model.Robot;

import java.util.Random;

public class DisplayUtils {

    public static void displayHeadLightColor(Robot robot) {
        System.out.println("Robot HeadLight Color " + robot.getHeadLightColor());
    }

    public static void displayInsufficientChargingMessage() {
        System.out.println("Insufficient Charging For Task" );
    }

    public static void displayOverloadedMessage(int weight) {
        System.out.println("Overloaded weight is " + weight + "  Not more than 10 kg" + "  please decrease weight by  " + (weight - 10));
    }

    public static void displayUpdatedChargingCapacity(int updatedCapacity) {
        System.out.println("updated capacity is " + updatedCapacity + "%");
    }

    public static void displayBarcodePrice() {
        System.out.println("Price is " + new Random().nextInt(100));
    }

    public static void failureScan() {
        System.out.println("Scan Failure");
    }
}
