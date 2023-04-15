package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class LoggerHelper {

    static final Logger logger = LoggerFactory.getLogger(LoggerHelper.class);

    static StringBuilder myCustomLog = new StringBuilder();

    public static void log(String message) {
        logger.info(message);
        myCustomLog.append(message);
    }

    public static String logAndPassMyParameter(String parameter , String defaultValue) {
        String value = System.getProperty(parameter);

        log("System property " + parameter + ": " + value + "\n");

        String result = Objects.isNull(value) ? defaultValue : value;

        log("Set " + parameter + " value: " + result + "\n");

        return result;
    }

    public static String getCustomLogs() {
        return myCustomLog.toString();
    }


}
