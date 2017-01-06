package javaBaseCourse.task3_3;

/**
 * Created by User on 06.01.2017.
 */
public class JavaBaseCourse2_1 {

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getY() > toY) {
            turnTo(robot, Direction.DOWN);
        } else {
            turnTo(robot, Direction.UP);
        }
        int stepsY = Math.abs( toY - robot.getY());
        stepForward(robot, stepsY);




        if (robot.getX() > toX) {
            turnTo(robot, Direction.LEFT);
        } else {
            turnTo(robot, Direction.RIGHT);
        }
        int stepsX =  Math.abs( toX - robot.getX());;
        stepForward(robot, stepsX);
    }

    private static void stepForward(Robot robot, int steps) {
        for (int i = 0; i < steps; i++) {
            robot.stepForward();
        }
    }

    private static void turnTo(Robot robot, Direction direction) {
        while (!robot.getDirection().equals(direction)) {
            robot.turnLeft();
        }
    }

}
