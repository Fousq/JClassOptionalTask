package kz.zhanbolat.jclass;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void testLog4j() {
		Logger logger = Logger.getLogger(AppTest.class);
		logger.info("INFO");
		logger.debug("DEBUG");
		logger.error("ERROR");
		logger.fatal("FATAL");
	}
	
}
