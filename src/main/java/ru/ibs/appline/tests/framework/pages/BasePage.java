package ru.ibs.appline.tests.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.tests.framework.managers.DriverManager;
import ru.ibs.appline.tests.framework.managers.PageManager;
import ru.ibs.appline.tests.framework.managers.TestPropManager;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(10));
    private final TestPropManager props = TestPropManager.getTestPropManager();

    protected PageManager pageManager = PageManager.getInstance();
    //конструктор, который принимает вебэлемент
    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }
    /**
     * Явное ожидание состояния clickable элемента
     *
     * @param element - веб-элемент который требует проверки clickable
     * @return WebElement - возвращаем тот же веб элемент что был передан в функцию
     * @see WebDriverWait
     * @see org.openqa.selenium.support.ui.FluentWait
     * @see org.openqa.selenium.support.ui.Wait
     * @see ExpectedConditions
     */
    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Явное ожидание того что элемент станет видемым
     *
     * @param element - веб элемент который мы ожидаем что будет  виден на странице
     */
    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}