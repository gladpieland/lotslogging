package com.pieland.loggings.log4j2api.log4j2impl;

import org.apache.logging.log4j.jul.Log4jBridgeHandler;

import java.util.logging.Handler;

/**
 * Created by cook on 2022/4/6
 */
public class LotsLoggerRun3 {

    public void loggingUsingSlf4j() {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LotsLoggerRun3.class);
        logger.error("3 slf4j logger error");
        logger.warn("3 slf4j logger warn");
        logger.info("3 slf4j logger info");
        logger.debug("3 slf4j logger debug");
        logger.trace("3 slf4j logger trace");
    }

    public void loggingUsingJcl() {
        org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LotsLoggerRun3.class);
        log.error("3 jcl logger error");
        log.warn("3 jcl logger warn");
        log.info("3 jcl logger info");
        log.debug("3 jcl logger debug");
        log.trace("3 jcl logger trace");
    }

    public void loggingUsingJul() {
        /*
        ALL      -->  ALL
        FINEST   -->  FINEST
        FINER    -->  TRACE
        FINE     -->  DEBUG
        CONFIG   -->  CONFIG
        INFO     -->  INFO
        WARNING  -->  WARN
        SEVERE   -->  ERROR
        OFF      -->  OFF
         */
        if (!isInstalled()) {
            Log4jBridgeHandler.install(true, ".", true);
            // because set propagateLevels = true, will propagate log4j2's level setting to jul
        }

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LotsLoggerRun3.class.getName());

        // error
        logger.severe("3 jul logger severe as error");
        // warn
        logger.warning("3 jul logger warning as warn");
        // info
        logger.info("3 jul logger info as info");
        // debug
        logger.fine("3 jul logger fine as debug");
        logger.finer("3 jul logger finer as debug");
        // trace
        logger.finest("3 jul logger finest as trace");
    }

    public static boolean isInstalled() throws SecurityException {
        java.util.logging.Logger rootLogger = java.util.logging.LogManager.getLogManager().getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (int i = 0; i < handlers.length; i++) {
            if (handlers[i] instanceof Log4jBridgeHandler) {
                return true;
            }
        }
        return false;
    }

    public void loggingUsingLog4j1() {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LotsLoggerRun3.class);
        logger.error("3 log4j 1.x logger error");
        logger.warn("3 log4j 1.x logger warn");
        logger.info("3 log4j 1.x logger info");
        logger.debug("3 log4j 1.x logger debug");
        logger.trace("3 log4j 1.x logger trace");
    }

    public void loggingUsingLog4j2() {
        org.apache.logging.log4j.Logger  logger = org.apache.logging.log4j.LogManager.getLogger(LotsLoggerRun3.class);
        logger.error("3 log4j2 logger error");
        logger.warn("3 log4j2 logger warn");
        logger.info("3 log4j2 logger info");
        logger.debug("3 log4j2 logger debug");
        logger.trace("3 log4j2 logger trace");
    }

    public static void main(String[] args) {
        LotsLoggerRun3 loggingsManager = new LotsLoggerRun3();
        loggingsManager.loggingUsingJcl();
        loggingsManager.loggingUsingJul();
        loggingsManager.loggingUsingLog4j1();

        loggingsManager.loggingUsingLog4j2();
        loggingsManager.loggingUsingSlf4j();
    }

}
