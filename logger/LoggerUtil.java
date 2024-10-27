package org.example.logger;

public class LoggerUtil {
    private static final MyLogger logger = new LoggerAdapter(LoggerUtil.class.getSimpleName());

    public void method() {
        logger.log(LogLevel.ERROR,"Logging...");
    }

    public static void main(String[] args) {
        new LoggerUtil().method();
    }

}
