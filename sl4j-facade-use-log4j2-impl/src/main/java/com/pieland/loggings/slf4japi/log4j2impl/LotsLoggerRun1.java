package com.pieland.loggings.slf4japi.log4j2impl;

import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Created by cook on 2022/4/6
 */
public class LotsLoggerRun1 {

    public void loggingUsingSlf4j() {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LotsLoggerRun1.class);
        logger.error("1 slf4j logger error");
        logger.warn("1 slf4j logger warn");
        logger.info("1 slf4j logger info");
        logger.debug("1 slf4j logger debug");
        logger.trace("1 slf4j logger trace");
    }

    public void loggingUsingJcl() {
        org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LotsLoggerRun1.class);
        log.error("1 jcl logger error");
        log.warn("1 jcl logger warn");
        log.info("1 jcl logger info");
        log.debug("1 jcl logger debug");
        log.trace("1 jcl logger trace");
    }

    public void loggingUsingJul() {
        /*
           FINEST  -> TRACE
           FINER   -> DEBUG
           FINE    -> DEBUG
           INFO    -> INFO
           WARNING -> WARN
           SEVERE  -> ERROR
         */
        if (!SLF4JBridgeHandler.isInstalled()) {
            SLF4JBridgeHandler.removeHandlersForRootLogger();
            SLF4JBridgeHandler.install();
            // it's important, default the logger level is INFO
            java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.FINEST);
        }

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LotsLoggerRun1.class.getName());

        // error
        logger.severe("1 jul logger severe as error");
        // warn
        logger.warning("1 jul logger warning as warn");
        // info
        logger.info("1 jul logger info as info");
        // debug
        logger.fine("1 jul logger fine as debug");
        logger.finer("1 jul logger finer as debug");
        // trace
        logger.finest("1 jul logger finest as trace");

    }

    public void loggingUsingLog4j1() {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LotsLoggerRun1.class);
        logger.error("1 log4j 1.x logger error");
        logger.warn("1 log4j 1.x logger warn");
        logger.info("1 log4j 1.x logger info");
        logger.debug("1 log4j 1.x logger debug");
        logger.trace("1 log4j 1.x logger trace");
    }

    public void loggingUsingLog4j2() {
        org.apache.logging.log4j.Logger  logger = org.apache.logging.log4j.LogManager.getLogger(LotsLoggerRun1.class);
        logger.error("1 log4j2 logger error");
        logger.warn("1 log4j2 logger warn");
        logger.info("1 log4j2 logger info");
        logger.debug("1 log4j2 logger debug");
        logger.trace("1 log4j2 logger trace");
    }

    public static void main(String[] args) {
        LotsLoggerRun1 loggingsManager = new LotsLoggerRun1();
        loggingsManager.loggingUsingJcl();
        loggingsManager.loggingUsingJul();
        loggingsManager.loggingUsingLog4j1();

        loggingsManager.loggingUsingLog4j2();
        loggingsManager.loggingUsingSlf4j();
    }

}
