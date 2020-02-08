import constant.Color;
import model.RobotResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.RobotService;
import service.RobotServiceImpl;

import static org.junit.Assert.*;

public class RobertServiceTest {

    private RobotService robotService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRobotWalk() {
        robotService = new RobotServiceImpl();
        RobotResponse robotResponse = robotService.walk(3.5);

        assertTrue(robotResponse.isAbleToWalk());
        assertEquals(30, robotResponse.getAvailableCapaciy());
        assertEquals(Color.GREEN, robotResponse.getRobotColor());
    }

    @Test
    public void testRobotWalkWhenNoEnoughMemory() {
        robotService = new RobotServiceImpl();
        RobotResponse robotResponse = robotService.walk(6);

        assertFalse(robotResponse.isAbleToWalk());
        assertEquals(100, robotResponse.getAvailableCapaciy());
        assertEquals(Color.GREEN, robotResponse.getRobotColor());
    }

    @Test
    public void testRobotWalkWhen15PercMemoryLeft() {
        robotService = new RobotServiceImpl();
        RobotResponse robotResponse = robotService.walk(4.5);

        assertTrue(robotResponse.isAbleToWalk());
        assertEquals(10, robotResponse.getAvailableCapaciy());
        assertEquals(Color.RED, robotResponse.getRobotColor());
    }


    @Test
    public void testRobotCarryWeightIsNotMoreThan10() {
        robotService = new RobotServiceImpl();
        RobotResponse robotResponse = robotService.carry(9);

        assertTrue(robotResponse.isAbleToCarryWeight());
        assertEquals(82, robotResponse.getAvailableCapaciy());
        assertEquals(Color.GREEN, robotResponse.getRobotColor());
    }

    @Test
    public void testRobotCarryWeightIsMoreThan10() {
        robotService = new RobotServiceImpl();
        RobotResponse robotResponse = robotService.carry(12);

        assertFalse(robotResponse.isAbleToCarryWeight());
        assertEquals(100, robotResponse.getAvailableCapaciy());
        assertEquals(Color.GREEN, robotResponse.getRobotColor());
    }

    @Test
    public void testRobotWalkAndCarryPositiveTest() {
        robotService = new RobotServiceImpl();
        RobotResponse robotResponse = robotService.walkAndCarry(2, 3);

        assertTrue(robotResponse.isAbleToWalk());
        assertTrue(robotResponse.isAbleToCarryWeight());
        assertEquals(54, robotResponse.getAvailableCapaciy());
        assertEquals(Color.GREEN, robotResponse.getRobotColor());
    }

    @Test
    public void testRobotWalkAndCarryNegativeTest() {
        robotService = new RobotServiceImpl();
        RobotResponse robotResponse = robotService.walkAndCarry(4.5, 6);

        assertFalse(robotResponse.isAbleToWalk());
        assertFalse(robotResponse.isAbleToCarryWeight());
        assertEquals(100, robotResponse.getAvailableCapaciy());
        assertEquals(Color.GREEN, robotResponse.getRobotColor());
    }

    @Test
    public void testRobotWalkAndCarryButChargeisLessThan15Perc() {
        robotService = new RobotServiceImpl();
        RobotResponse robotResponse = robotService.walkAndCarry(4.5, 3);

        assertTrue(robotResponse.isAbleToWalk());
        assertTrue(robotResponse.isAbleToCarryWeight());
        assertEquals(4, robotResponse.getAvailableCapaciy());
        assertEquals(Color.RED, robotResponse.getRobotColor());
    }
}
