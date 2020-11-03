package base_test.core_classes.string_test;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class LoggingTest {
    @Test
    public void loggingTest() {
        Logger logger=Logger.getGlobal();
        logger.info("Start process...info");
        logger.warning("Memory is running out...warning");
        logger.severe("Shutdown in 5 seconds...severe");
    }
}
