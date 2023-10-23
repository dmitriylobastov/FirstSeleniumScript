package ru.ibs.appline.tests.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthtorizationPage {
    WebDriver driver;

    public void checkOpenAuthtorizationPage() {
        Assertions.assertEquals("Логин", driver.getTitle(), "Заголовок не соответствует");
    }

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement usernameInput;

    public void usernameInput(String username) {
        usernameInput.sendKeys(username);
    }

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordInput;

    public void passwordInput(String password) {
        passwordInput.sendKeys(password);
    }

//            // 1. Авторизация
//            wait.until(visibilityOf(driver.findElement(By.xpath(
//            "//form[@id = 'login-form']"))));
//        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Prohorova Alla");
//        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("testing");


    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonAuthorization;

    public void setClickAuthorization() {
        buttonAuthorization.click();
    }
}
