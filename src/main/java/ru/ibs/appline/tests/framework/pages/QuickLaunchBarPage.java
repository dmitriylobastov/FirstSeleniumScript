package ru.ibs.appline.tests.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.tests.framework.managers.PageManager;

import java.time.Duration;
import java.util.List;

public class QuickLaunchBarPage extends BasePage {

    public void checkOpenPage() {
        Assertions.assertEquals("Панель инструментов", driverManager.getDriver().getTitle(), "Заголовок не соответствует");
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li/a/span[@class='title']")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li/ul/li/a")
    private List<WebElement> listSubMenu;

    /**
     * Клик по базовому меню на странице "Панель инструментов"
     * Меню выбирается по тексту переданному на вход функции
     *
     * @param nameMenu - текст который будет передан пользователям(наименование меню)
     */

    public void selectBaseMenuByText(String nameMenu) {
        for (WebElement itemMenu : listBaseMenu) {
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return;
            }
        }
        Assertions.fail("Меню с текстом " + nameMenu + "не найдено в панеле инструментов");
    }

    public void selectSubMenuByText(String nameSubMenu) {
        for (WebElement itemMenu : listSubMenu) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                waitUtilElementToBeClickable(itemMenu).click();
                return;
            }
        }
        Assertions.fail("Подменю с текстом " + nameSubMenu + "не найдено в панеле инструментов");
    }
}






