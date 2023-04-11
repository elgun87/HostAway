package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationsReader {
    private static Properties properties = new Properties();
    static FileInputStream file = null;

    static {
        try {
            file = new FileInputStream("configurations.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
