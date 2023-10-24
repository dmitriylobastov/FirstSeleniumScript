package ru.ibs.appline.tests.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class BusinessTripPage extends BasePage {

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement titleBusinessTrip;

    public BusinessTripPage checkOpenBusinessTripPagePage() {
        Assertions.assertEquals(
                "Все Командировки", titleBusinessTrip.getText(), "Заголовок не соответствует");
        return this;
    }

    //getBusinessTripPage()
}
