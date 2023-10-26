package ru.ibs.appline.tests.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static ru.ibs.appline.tests.framework.utils.PropConst.NAME_DRIVER_WINDOWS;
import static ru.ibs.appline.tests.framework.utils.PropConst.PATH_CHROME_DRIVER_WINDOWS;

public class DriverManager {

    private WebDriver driver;
    private static DriverManager INSTANCE = null;
    private DriverManager() {
    }
    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        System.setProperty(NAME_DRIVER_WINDOWS, PATH_CHROME_DRIVER_WINDOWS);
        driver = new ChromeDriver();
        InitManager.initFramework();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
