package tests.log4Jtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day18_LogTests {

    private static Logger logger = LogManager.getLogger(Day18_LogTests.class.getName());

    @Test
    public void test1(){

        logger.fatal("FATAL");
        logger.error("ERROR");
        logger.warn("WARNING");
        logger.debug("DEBUG");
        logger.info("INFO");

    }
}
