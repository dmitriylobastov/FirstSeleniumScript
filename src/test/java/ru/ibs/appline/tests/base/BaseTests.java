package ru.ibs.appline.tests.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.ibs.appline.tests.framework.managers.DriverManager;
import ru.ibs.appline.tests.framework.managers.InitManager;
import ru.ibs.appline.tests.framework.managers.PageManager;
import ru.ibs.appline.tests.framework.managers.TestPropManager;

import static ru.ibs.appline.tests.framework.utils.PropConst.BASE_URL;

public class BaseTests {

    private static DriverManager driverManager = DriverManager.getDriverManager();

    private static TestPropManager testPropertiesManager = TestPropManager.getTestPropManager();

    protected PageManager pageManager = PageManager.getInstance();

    @BeforeAll
    public static void befofeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void before() {
        driverManager.getDriver().get(testPropertiesManager.getProperty(BASE_URL));
    }

    @AfterAll
    public static void afterClass() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        InitManager.quitFramework();
    }
}
