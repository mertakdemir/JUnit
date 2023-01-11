package tests.day18.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day18_Log4J2 {

    //Create object
    private static Logger logger = LogManager.getLogger(Day18_Log4J2.class.getName());
    @Test
    public void log4jTest(){

        //Use logger object to log/print information
        logger.fatal("Fatal Log !!!!!!");
        logger.error("Error Log !!!!!!");
        logger.warn("Warning Log !!!!!!");
        logger.debug("Debug Log !!!!!!");
        logger.info("Info Log !!!!!!");

    }
}
