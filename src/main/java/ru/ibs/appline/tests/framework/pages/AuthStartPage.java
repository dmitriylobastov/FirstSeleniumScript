package ru.ibs.appline.tests.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthStartPage extends BasePage {

    //    public void checkOpenAuthPage() {
//        Assertions.assertEquals("Логин", driver.getTitle(), "Заголовок не соответствует");
//    }
    /*
    wait.until(visibilityOf(driver.findElement(By.xpath(
            "//form[@id = 'login-form']"))));
    */
    @FindBy(xpath = "//h2[@class='title']")
    private WebElement title;
    @FindBy(xpath = "//input[@name='_username']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonAuthorization;

    public AuthStartPage checkOpenAuthPage() {
        Assertions.assertEquals("Логин", title.getText(), "Заголовок не соответствует");
        return this;
    }

    public AuthStartPage usernameInput(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public AuthStartPage passwordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public QuickLaunchBarPage setClickAuthorization() {
        buttonAuthorization.click();
        return pageManager.getQuickLaunchBarPage();
    }
}
