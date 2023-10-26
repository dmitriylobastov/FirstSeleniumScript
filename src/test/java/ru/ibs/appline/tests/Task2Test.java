package ru.ibs.appline.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.tests.base.BaseTests;
import ru.ibs.appline.tests.framework.managers.DriverManager;
import ru.ibs.appline.tests.framework.managers.TestPropManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static ru.ibs.appline.tests.framework.utils.PropConst.LOGIN;
import static ru.ibs.appline.tests.framework.utils.PropConst.PASSWORD;

public class Task2Test extends BaseTests {

    private static TestPropManager testPropertiesManager = TestPropManager.getTestPropManager();

    protected DriverManager driverManager = DriverManager.getDriverManager();

    @Test
    public void taskTwoTest() {
        // 1. Авторизация
        pageManager.getAuthStartPage()
                .checkOpenAuthPage()
                .usernameInput(testPropertiesManager.getProperty(LOGIN))
                .passwordInput(testPropertiesManager.getProperty(PASSWORD))
                .setClickAuthorization()
                .checkOpenPage()
                .selectBaseMenuByText("Расходы")
                .selectSubMenuByText("Командировки")
                .checkOpenBusinessTripPagePage()
                .clickCreatedBusinessTrip();
//                .checkOpenCreatedBusinessTripPage()
////                .clickSeparation()
//                .clickSelectSeparation();

        // 6. Выбор и заполнение полей
        // Подразделение: "Центр разработки и сопровождения"

        //  не работают шаги при выносе в CreatedBusinessTripPage, без выноса всё ок
        // не работает .checkOpenCreatedBusinessTripPage()
        // не работает .clickSelectSeparation();
        driverManager.getDriver().findElement(By.xpath("//select[@data-name='field__business-unit']/option[@value='4']"))
                .click();




        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }








/*
        // 1. Авторизация

        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Prohorova Alla");
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("testing");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // 2. Проверить панель быстрого запуска
        wait.until(visibilityOf(driver.findElement(By.xpath("//h1[text()='Панель быстрого запуска']"))));

        // 3. Расходы -> Командировки
        WebElement costsList = driver.findElement(By.xpath(
                "//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']"));
        costsList.click();
        wait.until(visibilityOf(costsList.findElement(By.xpath(
                "./ancestor::li//ul[@class='dropdown-menu menu_level_1']"))));
        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
        loading();

        // 4. Клик по "Создать командировку"
        WebElement createdBusinessTrip = driver.findElement(By.xpath(
                "//a[@title='Создать командировку']"));
        wait.until(visibilityOf(createdBusinessTrip));
        createdBusinessTrip.click();
        loading();

        // 5. Заголовок "Создать командировку"
        wait.until(visibilityOf(driver.findElement(By.xpath(
                "//h1[@class='user-name']"))));

        // 6. Выбор и заполнение полей
        // Подразделение: "Центр разработки и сопровождения"
        driver.findElement(By.xpath("//select[@data-name='field__business-unit']/option[@value='4']"))
                .click();

        // Выбор организации
        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        driver.findElement(By.xpath("//div[@class='select2-search']/input[@type='text']")).sendKeys(
                "Яндекс", Keys.ENTER);
        wait.until(visibilityOf(driver.findElement(By.xpath("//span[text()='Яндекс']")))).click();
        // Задачи: чекбокс "Заказ билетов"
        WebElement orderTickets = driver.findElement(By.xpath(
                "//label[text()='Заказ билетов']/../input[@type='checkbox']"));
        orderTickets.click();
        boolean yes = orderTickets.getAttribute("checked").equals("true");
        // Город выбытия
        input("//label[text()='Город выбытия']/../..//input", "Уфа, Россия");
        // Город прибытия
        input("//label[text()='Город прибытия']/../..//input", "Москва, Россия");
        // Дата выезда
        input("//label[text()='Планируемая дата выезда']/../..//input[@placeholder='Укажите дату']",
                "16.10.2023");
        // Дата возвращения
        input("//label[text()='Планируемая дата возвращения']/../..//input[@placeholder='Укажите дату']",
                "24.10.2023");
        driver.findElement(By.xpath("//a[contains(@class, 'ui-state-default ui-state-active')]")).click();

        // 7. Проверка что все поля заполнены правильно
        // Введенные данные в коде страницы не сохраняются

        // 8. Нажать "Сохранить и закрыть"
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        // 9. Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
        wait.until(visibilityOf(driver.findElement(By.xpath(
                "//span[text()='Командированные сотрудники']/../..//span[text()='Список командируемых " +
                        "сотрудников не может быть пустым']"))));

 */
    }
}