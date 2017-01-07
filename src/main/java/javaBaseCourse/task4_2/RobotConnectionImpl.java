package javaBaseCourse.task4_2;

/**
 * Created by User on 07.01.2017.
 */
public class RobotConnectionImpl implements RobotConnection {
    @Override
    public void moveRobotTo(int x, int y) {
        throw new RobotConnectionException("");
//        throw new NullPointerException("");
//        System.out.println(String.format("RobotConnection move to (%d,%d)", x, y));
    }

    @Override
    public void close() {
//        System.out.println("RobotConnection close");
        System.out.println("RobotConnection close failed");
        throw new RobotConnectionException("");
    }
}
