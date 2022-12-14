package com.tangledbytes.libtb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    private static final String TAG = "FileUtils";


    public static boolean write(String destFile, String data) throws IOException {
        return write(new File(destFile), data);
    }

    public static boolean write(File destFile, String data) throws IOException {
        return write(destFile, data, false);
    }

    public static boolean write(String destFile, String data, boolean append) throws IOException {
        return write(new File(destFile), data, append);
    }

    public static boolean write(File destFile, String data, boolean append) throws IOException {
        FileWriter fw = new FileWriter(destFile, append);
        fw.write(data);
        fw.close();
        return true;
    }

    public static String read(String filePath) throws IOException {
        return read(new File(filePath));
    }

    public static String read(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder data = new StringBuilder();
        String line = null;
        while((line = br.readLine()) != null)
            data.append("\n").append(line);
        br.close();
        fr.close();

        // Remove the extra line that was added in first iteration of loop
        if(data.length() > 0)
            data = new StringBuilder(data.substring(1));
        return data.toString();
    }
}
