import service.RobotService;
import service.RobotServiceImpl;

public class RobertMain {
    public static void main(String[] args) {

        RobotService obj = new RobotServiceImpl();
        obj.walk(0);
        obj.carry(0);
        obj.walkAndCarry(2,2);
        obj.addAndGetUpdateCharging(10);
        obj.walkAndCarry(3,2);
        obj.displayPrice(18);
    }
}
