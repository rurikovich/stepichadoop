package javaBaseCourse.task4_2;

/**
 * Created by User on 07.01.2017.
 */
public class Processor {

    public static void main(String[] args) {
        moveRobot(new RobotConnectionManagerImpl(), 2, 4);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean isOk = false;
        int i = 0;
        while (i < 3 && !isOk) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                try {
                    connection.moveRobotTo(toX, toY);
                    isOk = true;
                } catch (RobotConnectionException e) {
                    System.out.println("RobotConnectionException");
                } catch (Throwable e) {
                    System.out.println("Throwable");
                    throw e;
                }
            }catch (RobotConnectionException e){

            }
            i++;
        }

        if (!isOk) {
            throw new RobotConnectionException("");
        }
    }


}
