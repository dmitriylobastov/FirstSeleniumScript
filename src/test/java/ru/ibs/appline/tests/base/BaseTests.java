package ru.ibs.appline.tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.tests.framework.managers.DriverManager;
import ru.ibs.appline.tests.framework.managers.PageManager;

import java.time.Duration;

public class BaseTests {

    private DriverManager driverManager = DriverManager.getInstance();

    protected PageManager pageManager = PageManager.getInstance();

    @BeforeEach
    public void before() {
        driverManager.getDriver().get("http://training.appline.ru/user/login");
    }

    @AfterEach
    public void after() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driverManager.getDriver().quit();
    }
}
