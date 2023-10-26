package ru.ibs.appline.tests.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreatedBusinessTripPage {

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement titleCreatedBusinessTrip;

    @FindBy(xpath = "//h5[@class='user-fieldset']/span[text()='Основная информация']")
    private WebElement titleInfo;
    //h5[@class='user-fieldset']/span[text()='Основная информация']

    @FindBy(xpath = "//select[@data-name='field__business-unit']/option[@value='4']")
    private WebElement selectSeparation;

    @FindBy(xpath = "//select[@data-name='field__business-unit']")
    private Select separation;

    public CreatedBusinessTripPage checkOpenCreatedBusinessTripPage() {
        Assertions.assertEquals(
                "Основная информация", titleInfo.getText(), "Заголовок не соответствует");
        return this;
    }
        public CreatedBusinessTripPage clickSeparation() {
            separation.selectByValue("4");
            return this;
        }
        public CreatedBusinessTripPage clickSelectSeparation() {
            selectSeparation.click();
            return this;
    }


}
