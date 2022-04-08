package com.pieland.loggings.sl4japi.logbackimpl;

import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Created by cook on 2022/4/6
 */
public class LotsLoggerRun2 {

    public void loggingUsingSlf4j() {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LotsLoggerRun2.class);
        logger.error("2 slf4j logger error");
        logger.warn("2 slf4j logger warn");
        logger.info("2 slf4j logger info");
        logger.debug("2 slf4j logger debug");
        logger.trace("2 slf4j logger trace");
    }

    public void loggingUsingJcl() {
        org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LotsLoggerRun2.class);
        log.error("2 jcl logger error");
        log.warn("2 jcl logger warn");
        log.info("2 jcl logger info");
        log.debug("2 jcl logger debug");
        log.trace("2 jcl logger trace");
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

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LotsLoggerRun2.class.getName());

        // error
        logger.severe("2 jul logger severe as error");
        // warn
        logger.warning("2 jul logger warning as warn");
        // info
        logger.info("2 jul logger info as info");
        // debug
        logger.fine("2 jul logger fine as debug");
        logger.finer("2 jul logger finer as debug");
        // trace
        logger.finest("2 jul logger finest as trace");

    }

    public void loggingUsingLog4j1() {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LotsLoggerRun2.class);
        logger.error("2 log4j 1.x logger error");
        logger.warn("2 log4j 1.x logger warn");
        logger.info("2 log4j 1.x logger info");
        logger.debug("2 log4j 1.x logger debug");
        logger.trace("2 log4j 1.x logger trace");
    }

    public void loggingUsingLog4j2() {
        org.apache.logging.log4j.Logger  logger = org.apache.logging.log4j.LogManager.getLogger(LotsLoggerRun2.class);
        logger.error("2 log4j2 logger error");
        logger.warn("2 log4j2 logger warn");
        logger.info("2 log4j2 logger info");
        logger.debug("2 log4j2 logger debug");
        logger.trace("2 log4j2 logger trace");
    }

    public static void main(String[] args) {
        LotsLoggerRun2 loggingsManager = new LotsLoggerRun2();
        loggingsManager.loggingUsingJcl();
        loggingsManager.loggingUsingJul();
        loggingsManager.loggingUsingLog4j1();

        loggingsManager.loggingUsingLog4j2();
        loggingsManager.loggingUsingSlf4j();
    }

}
