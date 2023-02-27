package pagestest;

import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class ConstructorTest {
    private WebDriver driver;
    private String expectedTextConstructorTitle = "Соберите бургер";
    private String expectedTextBuns = "Булки";
    private String expectedTextSauces = "Соусы";
    private String expectedTextFillings = "Начинки";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        homePage.openSite();
    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику Конструктор из Личного кабинета")
    public void successJumpToConstructorByClickConstructor() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalOfficeButton();
        homePage.clickConstructorButton();
        String actualTextConstructorTitle = homePage.getTextConstructorTitle();
        assertEquals("Не корректный результат", expectedTextConstructorTitle, actualTextConstructorTitle);
    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику логотипа из Личного кабинета")
    public void successJumpToConstructorByClickLogo() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalOfficeButton();
        homePage.clickLogoButton();
        String actualTextConstructorTitle = homePage.getTextConstructorTitle();
        assertEquals("Не корректный результат", expectedTextConstructorTitle, actualTextConstructorTitle);
    }

    @Test
    @DisplayName("Проверка перехода в раздел Булки в конструкторе")
    public void successJumpToBuns() {
        HomePage homePage = new HomePage(driver);
        homePage.clickBunsButton();
        String actualResult = driver.findElement(homePage.getResultSection()).getText();
        assertEquals("Не корректный результат", expectedTextBuns, actualResult);
    }

    @Test
    @DisplayName("Проверка перехода в раздел Соусы в конструкторе")
    public void successJumpToSauces() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSaucesButton();
        String actualResult = driver.findElement(homePage.getResultSection()).getText();
        assertEquals("Не корректный результат", expectedTextSauces, actualResult);
    }

    @Test
    @DisplayName("Проверка перехода в раздел Начинки в конструкторе")
    public void successJumpToFillings() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFillingsButton();
        String actualResult = driver.findElement(homePage.getResultSection()).getText();
        assertEquals("Не корректный результат", expectedTextFillings, actualResult);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
