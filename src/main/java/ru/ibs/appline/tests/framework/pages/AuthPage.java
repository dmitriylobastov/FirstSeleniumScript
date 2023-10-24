package ru.ibs.appline.tests.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AuthPage extends BasePage {

//    public void checkOpenAuthPage() {
//        Assertions.assertEquals("Логин", driver.getTitle(), "Заголовок не соответствует");
//    }


    @FindBy(xpath = "//h2[@class='title']")
    private WebElement title;
    public AuthPage checkOpenAuthPage() {
        Assertions.assertEquals("Логин", title.getText(), "Заголовок не соответствует");
        return 
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

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonAuthorization;

    public void setClickAuthorization() {
        buttonAuthorization.click();
    }
}
