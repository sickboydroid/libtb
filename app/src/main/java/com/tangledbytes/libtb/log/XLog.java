package com.tangledbytes.libtb.log;

import android.util.Log;

import com.tangledbytes.libtb.Constants;
import com.tangledbytes.libtb.log.LogWriter;

import java.io.File;

/**
 * Custom logcat implementation
 */
public class XLog {
    public static final int VERBOSE = Log.VERBOSE;
    public static final int DEBUG = Log.DEBUG;
    public static final int INFO = Log.INFO;
    public static final int WARN = Log.WARN;
    public static final int ERROR = Log.ERROR;
    private static LogWriter mLogWriter;

    public static void initialize(File dir) {
        mLogWriter = new LogWriter(dir);
    }

    public static void v(String tag, String msg) {
        printLog(VERBOSE, tag, msg, null);
    }

    public static void v(String tag, String msg, Throwable tr) {
        printLog(VERBOSE, tag, msg, tr);
    }

    public static void d(String tag, String msg) {
        printLog(DEBUG, tag, msg, null);
    }

    public static void d(String tag, String msg, Throwable tr) {
        printLog(DEBUG, tag, msg, tr);
    }

    public static void i(String tag, String msg) {
        printLog(INFO, tag, msg, null);
    }

    public static void i(String tag, String msg, Throwable tr) {
        printLog(INFO, tag, msg, tr);
    }

    public static void w(String tag, String msg) {
        printLog(WARN, tag, msg, null);
    }

    public static void w(String tag, String msg, Throwable tr) {
        printLog(WARN, tag, msg, tr);
    }

    public static void e(String tag, String msg) {
        printLog(ERROR, tag, msg, null);
    }

    public static void e(String tag, String msg, Throwable tr) {
        printLog(ERROR, tag, msg, tr);
    }

    private static void printLog(int priority, String tag, String msg, Throwable tr) {
        if (mLogWriter == null)
            throw new RuntimeException(new IllegalStateException("No directory passed to store log file. Have you called XLog.initialize(File)?"));

        if (!Constants.DEBUG)
            if (priority == VERBOSE || priority == DEBUG)
                return;

        // Log message to the internal log-system of android
        if (tr != null) {
            switch (priority) {
                case VERBOSE:
                    Log.v(tag, msg, tr);
                    break;
                case DEBUG:
                    Log.d(tag, msg, tr);
                    break;
                case INFO:
                    Log.i(tag, msg, tr);
                    break;
                case WARN:
                    Log.w(tag, msg, tr);
                    break;
                case ERROR:
                    Log.e(tag, msg, tr);
                    break;
            }
        } else Log.println(priority, tag, msg);

        if (tag == null) tag = "null";
        if (msg == null) msg = "null";
        if (tr != null)
            mLogWriter.addLog(priority, tag, msg, tr);
        else
            mLogWriter.addLog(priority, tag, msg);
    }
}