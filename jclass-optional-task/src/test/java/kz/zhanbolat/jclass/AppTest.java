package kz.zhanbolat.jclass;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testLog4j() {
        Logger logger = Logger.getLogger(getClass());
        logger.info("INFO MESSAGE");
        logger.debug("DEGUB MESSAGE");
        logger.warn("WARN MESSAGE");
        logger.error("ERROR MESSAGE");
        logger.fatal("FATAL MESSAGE");
    }

}
