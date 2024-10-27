package org.example.logger;
//logManager
//package designPatterns.labs.lab06;

//import designPatterns.labs.lab06.log4j.Log4J;
//import designPatterns.labs.lab06.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
import org.example.logger.log4j.Log4J;
import org.example.logger.log4j.LogManager;

public class LoggerAdapter implements MyLogger {

    private final Log4J log4j;

    LoggerAdapter(String scope){
        this.log4j = LogManager.getLogger(scope);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        switch (logLevel){
            case DEBUG:
                this.log4j.debug(message);
                break;
            case ERROR:
                this.log4j.error(message);
                break;
            case FATAL:
                this.log4j.fatal(message);
                break;
            case INFO:
                this.log4j.info(message);
                break;
            case TRACE:
                this.log4j.trace(message);
                break;
            case WARNING:
                this.log4j.warning(message);
                break;
            default:
                break;
        }

    }
}
