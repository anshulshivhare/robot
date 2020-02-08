package service;

import model.RobotResponse;

public interface RobotService {

    RobotResponse walk(double distance);

    RobotResponse carry(int weight);

    RobotResponse walkAndCarry(double distance, int weight);

    int addAndGetUpdateCharging(int percentage);

    void displayPrice(int barcode);
}
