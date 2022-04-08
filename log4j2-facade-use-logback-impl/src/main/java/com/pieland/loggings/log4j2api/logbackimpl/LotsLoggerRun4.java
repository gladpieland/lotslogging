package com.pieland.loggings.log4j2api.logbackimpl;

import org.apache.logging.log4j.jul.Log4jBridgeHandler;

import java.util.logging.Handler;

/**
 * Created by cook on 2022/4/6
 */
public class LotsLoggerRun4 {

    public void loggingUsingSlf4j() {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LotsLoggerRun4.class);
        logger.error("4 slf4j logger error");
        logger.warn("4 slf4j logger warn");
        logger.info("4 slf4j logger info");
        logger.debug("4 slf4j logger debug");
        logger.trace("4 slf4j logger trace");
    }

    public void loggingUsingJcl() {
        org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LotsLoggerRun4.class);
        log.error("4 jcl logger error");
        log.warn("4 jcl logger warn");
        log.info("4 jcl logger info");
        log.debug("4 jcl logger debug");
        log.trace("4 jcl logger trace");
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
            Log4jBridgeHandler.install(true, ".", false);
            // logback do not support propagateLevels
            // propagateLevels use log4j-core as dependency, so it can not be set to true
            // it's important, default the logger level is INFO
            java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.FINEST);
        }

        /*
        when shutdown jvm, will report an exception:
        Exception in thread "Thread-0" java.lang.NoClassDefFoundError: org/apache/logging/log4j/core/LoggerContext
            at org.apache.logging.log4j.jul.Log4jBridgeHandler.close(Log4jBridgeHandler.java:174)
            at java.util.logging.LogManager.resetLogger(LogManager.java:1346)
            at java.util.logging.LogManager.reset(LogManager.java:1332)
            at java.util.logging.LogManager$Cleaner.run(LogManager.java:239)
         */

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LotsLoggerRun4.class.getName());

        // error
        logger.severe("4 jul logger severe as error");
        // warn
        logger.warning("4 jul logger warning as warn");
        // info
        logger.info("4 jul logger info as info");
        // debug
        logger.fine("4 jul logger fine as debug");
        logger.finer("4 jul logger finer as debug");
        // trace
        logger.finest("4 jul logger finest as trace");
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
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LotsLoggerRun4.class);
        logger.error("4 log4j 1.x logger error");
        logger.warn("4 log4j 1.x logger warn");
        logger.info("4 log4j 1.x logger info");
        logger.debug("4 log4j 1.x logger debug");
        logger.trace("4 log4j 1.x logger trace");
    }

    public void loggingUsingLog4j2() {
        org.apache.logging.log4j.Logger  logger = org.apache.logging.log4j.LogManager.getLogger(LotsLoggerRun4.class);
        logger.error("4 log4j2 logger error");
        logger.warn("4 log4j2 logger warn");
        logger.info("4 log4j2 logger info");
        logger.debug("4 log4j2 logger debug");
        logger.trace("4 log4j2 logger trace");
    }

    public static void main(String[] args) {
        LotsLoggerRun4 loggingsManager = new LotsLoggerRun4();
        loggingsManager.loggingUsingJcl();
        loggingsManager.loggingUsingJul();
        loggingsManager.loggingUsingLog4j1();

        loggingsManager.loggingUsingLog4j2();
        loggingsManager.loggingUsingSlf4j();
    }

}
