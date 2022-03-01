package org.recaptcha.utils;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class iLog {
    public static void logInfo(String msg){
        Logger.getAnonymousLogger().log(Level.INFO, msg);
    }

    public static void logWarning(String msg){
        Logger.getAnonymousLogger().log(Level.WARNING, msg);
    }
}
