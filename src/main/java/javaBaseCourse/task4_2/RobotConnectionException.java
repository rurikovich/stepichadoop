package javaBaseCourse.task4_2;

/**
 * Created by User on 07.01.2017.
 */
public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
