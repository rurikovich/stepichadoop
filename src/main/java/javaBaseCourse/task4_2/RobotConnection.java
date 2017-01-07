package javaBaseCourse.task4_2;

/**
 * Created by User on 07.01.2017.
 */
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
