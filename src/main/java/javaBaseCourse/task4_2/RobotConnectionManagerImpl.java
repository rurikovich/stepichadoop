package javaBaseCourse.task4_2;

/**
 * Created by User on 07.01.2017.
 */
public class RobotConnectionManagerImpl implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        return new RobotConnectionImpl();
    }
}
