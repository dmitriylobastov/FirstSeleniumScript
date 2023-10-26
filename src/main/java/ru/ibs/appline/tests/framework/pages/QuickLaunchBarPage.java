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
    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li/a/span[@class='title']")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li/ul/li/a")
    private List<WebElement> listSubMenu;

    public QuickLaunchBarPage checkOpenPage() {
        Assertions.assertEquals(
                "Панель инструментов", driverManager.getDriver().getTitle(), "Заголовок не соответствует");
        return this;
    }

    public QuickLaunchBarPage selectBaseMenuByText(String nameMenu) {
        for (WebElement itemMenu : listBaseMenu) {
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return this;
            }
        }
        Assertions.fail("Меню с текстом " + nameMenu + "не найдено в панеле инструментов");
        return this;
    }

    public BusinessTripPage selectSubMenuByText(String nameSubMenu) {
        for (WebElement itemMenu : listSubMenu) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                waitUtilElementToBeClickable(itemMenu).click();
                loading();
                return pageManager.getBusinessTripPage();
            }
        }
        Assertions.fail("Подменю с текстом " + nameSubMenu + "не найдено в панеле инструментов");
        return pageManager.getBusinessTripPage();
    }
}






