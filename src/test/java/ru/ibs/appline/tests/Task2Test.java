package ru.ibs.appline.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.ibs.appline.tests.base.BaseTests;
import ru.ibs.appline.tests.framework.pages.AuthtorizationPage;
import ru.ibs.appline.tests.framework.pages.QuickLaunchBarPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Task2Test extends BaseTests {
    AuthtorizationPage authtorizationPage = new AuthtorizationPage();
    QuickLaunchBarPage quickLaunchBarPage = new QuickLaunchBarPage();



    @Test
    public void test1() {

        // 1. Авторизация
        //authtorizationPage.checkOpenAuthtorizationPage();
        authtorizationPage.usernameInput("Prohorova Alla");
        authtorizationPage.passwordInput("testing");
        authtorizationPage.setClickAuthorization();


        // 2. Проверить панель быстрого запуска
        quickLaunchBarPage.checkOpenPage();

        // 3. Расходы -> Командировки
        quickLaunchBarPage.selectBaseMenuByText("Расходы");
        quickLaunchBarPage.selectSubMenuByText("Командировки");


        // 4. Клик по "Создать командировку"


        // 5. Заголовок "Создать командировку"


        // 6. Выбор и заполнение полей
        // Подразделение: "Центр разработки и сопровождения"


        // Выбор организации
        // Задачи: чекбокс "Заказ билетов"

        // Город выбытия

        // Город прибытия

        // Дата выезда

        // Дата возвращения

        // 7. Проверка что все поля заполнены правильно
        // Введенные данные в коде страницы не сохраняются

        // 8. Нажать "Сохранить и закрыть"

        // 9. Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"

    }
    public void input(String xpath, String input) {
        WebElement element = driver.findElement(By.xpath(String.format(
                "%s", xpath)));
        element.clear();
        element.sendKeys(String.format(
                "%s", input));
    }

    public void loading() {
        wait.until(invisibilityOf(driver.findElement(By.xpath(
                "//div[@class='loader-mask shown']"))));
    }
}
