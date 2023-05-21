package com.uah.trabajofinal.utils.logger;

import android.util.Log;

public class Logger {

    private static final String DEFAULT_TAG = "[MovAffinityUAH]";
    private static boolean isLoggingEnabled = true;

    private final String tag;

    public Logger(Class<?> clazz) {
        this(clazz.getSimpleName());
    }

    public Logger(String tag) {
        this.tag = tag;
    }

    public static void setLoggingEnabled(boolean enabled) {
        isLoggingEnabled = enabled;
    }

    public void d(String message) {
        if (isLoggingEnabled) {
            Log.d(DEFAULT_TAG + " " + tag, message);
        }
    }

    public void i(String message) {
        if (isLoggingEnabled) {
            Log.i(DEFAULT_TAG + " " + tag, message);
        }
    }

    public void w(String message) {
        if (isLoggingEnabled) {
            Log.w(DEFAULT_TAG + " " + tag, message);
        }
    }

    public void e(String message) {
        if (isLoggingEnabled) {
            Log.e(DEFAULT_TAG + " " + tag, message);
        }
    }
}
