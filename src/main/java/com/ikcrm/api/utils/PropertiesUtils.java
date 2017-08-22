package com.ikcrm.api.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/6/30.
 */
public class PropertiesUtils {
    private static Properties prop = new Properties();
    static {
        try {
            prop.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(
                    "/resource/route.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String filePath,String key) {
        try {
            prop.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(
                    filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public static String getString(String key) {
        return prop.getProperty(key);
    }
}
