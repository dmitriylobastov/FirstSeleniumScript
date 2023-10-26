package ru.ibs.appline.tests.framework.managers;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestPropManager {

    private final Properties properties = new Properties();


    private static TestPropManager INSTANCE = null;
    private TestPropManager() {
        loadApplicationProperties();
    }
    public static TestPropManager getTestPropManager() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropManager();
        }
        return INSTANCE;
    }

    private void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream(
                    new File("src/main/resources/" +
                            System.getProperty("propFile", "application") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}