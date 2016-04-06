package com.amcs31.jsonfragmenttest.util;


import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {
    public static String readFromAssets(String fileName, Context context) {
        StringBuilder buf = new StringBuilder();
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String str;
            while ((str=in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }
}
