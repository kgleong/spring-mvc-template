package com.orangemako.spring.util;

import org.slf4j.Logger;

/**
 * Log4J Utilities.
 *
 * @author Kevin Leong
 */
public class LoggerUtils {

    /**
     * Logs messages at all logging levels for Log4J debugging/verification.
     *
     * @param logger
     */
    public static void logMessagesAllLevels(Logger logger) {
        String message = " logging on.";

        logger.trace("Trace" + message);
        logger.debug("Debug" + message);
        logger.info("Info" + message);
        logger.warn("Warn" + message);
        logger.error("Error" + message);
    }
}
