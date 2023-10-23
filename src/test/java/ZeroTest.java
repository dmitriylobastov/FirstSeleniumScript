import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ZeroTest {
    WebDriver driver = new ChromeDriver();

    //явное ожидание
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver.get("http://training.appline.ru/user/login");
        // неявные ожидания 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //развернуть окно браузера на весь экран
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        //Шаг 1: Авторизация
        // проверяем появление формы авторизации, что элемент отображается
        wait.until(visibilityOf(driver.findElement(By.xpath(
                "//form[@id = 'login-form']"))));
        // .sendKeys() - для ввода значения в поле
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Prohorova Alla");
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("testing");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // ожидаем появление "Панель быстрого запуска"
        wait.until(visibilityOf(driver.findElement(By.xpath(
                "//h1[@class='oro-subtitle']"))));

        //Шаг 2: Перейти в командировки
        // клик на "Расходы"
        WebElement costsList = driver.findElement(By.xpath(
                "//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']"));
        costsList.click();
        // найти выпадающий список
        wait.until(visibilityOf(costsList.findElement(By.xpath(
                "./ancestor::li//ul[@class='dropdown-menu menu_level_1']"))));
        // мой xpath - //li[@data-route='crm_business_trip_index']/a
        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
        // проверяем с ожиданием, чтоб лоадера не было
        loading();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
        //        "//h1[@class ='oro-subtitle']"))));

        //Шаг 3: фильтр
        //клик на "Стадия"
        driver.findElement(By.xpath(
                "//div[@class='filter-item oro-drop']/div[contains(text(), 'Стадия')]")).click();
        wait.until(visibilityOf(driver.findElement(By.xpath(
                "//div[contains(@class, 'ui-multiselect-menu ui-corner-all')]"))));
        // заполнить форму поиска
        driver.findElement(By.xpath(
                        "//div[contains(@class, 'ui-multiselect-menu ui-corner-all')]//input[@type='search']"))
                .sendKeys("Согласование с ОСР");
        driver.findElement(By.xpath("//label [contains(@title, 'Согласование с ОСР')]")).click();
        loading();
        //К21-10165
        String id = driver.findElement(By.xpath("//td[text() = 'Россия, Уфа']/../td[contains(@class, 'name')]")).getText();
        driver.findElement(By.xpath(
                "//div[@class='filter-item oro-drop']/div[contains(text(), 'Номер')]")).click();
        wait.until(visibilityOf(driver.findElement(By.xpath(
                "//input[@name='value']")))).sendKeys(id, Keys.ENTER);
        loading();

        //Шаг 4: Переход в
        //driver.findElement(By.xpath("//td[contains(@class, 'grid-body-cell-name')][text()='К21-10165']")).click();
        //driver.findElement(By.xpath("//td[contains(@class, 'grid-body-cell-name')][text()='" + id + "']")).click();
        //оптимизация
        driver.findElement(By.xpath(String.format("//td[contains(@class, 'grid-body-cell-name')][text()='%s']", id))).click();
        WebElement actualId = driver.findElement(By.xpath(
                "//h1[@class='user-name']"));
        wait.until(visibilityOf(actualId));
        // проверка на ОР, вводим
        assertEquals("id", actualId.getText(), "Мы попали на не верную страницу");


        // поместить локатор
        // @FindBy, работает только с
        // передается страничка по ссылке this
        // PageFactory.initElements(driver, this)

    }

    @AfterEach
    public void after() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void loading() {
        wait.until(invisibilityOf(driver.findElement(By.xpath(
                "//div[@class='loader-mask shown']"))));
    }
}
