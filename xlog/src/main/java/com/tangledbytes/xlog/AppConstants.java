package com.tangledbytes.xlog;

import android.os.Environment;

import java.io.File;

public class AppConstants {
    ///////////////////////////////////////
    // Constants for controlling logging //
    ///////////////////////////////////////
    public static final boolean DEBUG = true;
    public static final boolean EXTREME_LOGGING = false;

    //////////////////////////
    // File names and paths //
    //////////////////////////
    public static final File EXTERNAL_STORAGE_DIR = Environment.getExternalStorageDirectory();
}
