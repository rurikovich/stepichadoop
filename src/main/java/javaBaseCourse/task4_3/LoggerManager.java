package javaBaseCourse.task4_3;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * Created by User on 08.01.2017.
 */
public class LoggerManager {

    private static void configureLogging() {
        Logger classALogger = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger classBLogger = Logger.getLogger("org.stepic.java.logging.ClassB");
        Logger logger = Logger.getLogger("org.stepic.java");


        ConsoleHandler consoleHandler = new ConsoleHandler();
        XMLFormatter xmlFormatter = new XMLFormatter();
        consoleHandler.setFormatter(xmlFormatter);
        consoleHandler.setLevel(Level.ALL);

        classALogger.setLevel(Level.ALL);
        classBLogger.setLevel(Level.WARNING);
//        logger.setLevel(Level.ALL);

        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);

    }
}
