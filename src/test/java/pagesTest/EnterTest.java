package pagesTest;

import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class EnterTest {
    private WebDriver driver;
    private String expectedNameFormEnterToAccount = "Вход";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        homePage.openSite();
    }

    @Test
    @DisplayName("Проверка перехода на страницу входа по кнопке Войти в аккаунт")
    public void successEnterToAccountButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickEnterToAccountButtonWithWait();
        String actualEnterToAccountButton = homePage.getNameFormEnterToAccount();
        assertEquals("Не корректный результат", expectedNameFormEnterToAccount, actualEnterToAccountButton);
    }

    @Test
    @DisplayName("Проверка перехода на страницу входа по кнопке Личный кабинет")
    public void successEnterToPersonalOffice() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalOfficeButton();
        String actualEnterToPersonalOffice = homePage.getNameFormEnterToAccount();
        assertEquals("Не корректный результат", expectedNameFormEnterToAccount, actualEnterToPersonalOffice);
    }

    @Test
    @DisplayName("Проверка перехода на страницу входа по кнопке Войти в форме Регистрация")
    public void successEnterToRegistrationForm() {
        HomePage homePage = new HomePage(driver);
        homePage.clickEnterToAccountButtonWithWait();
        homePage.clickRegistrationButton();
        homePage.clickEnterButtonDownForm();
        String actualEnterToRegistrationForm = homePage.getNameFormEnterToAccount();
        assertEquals("Не корректный результат", expectedNameFormEnterToAccount, actualEnterToRegistrationForm);
    }

    @Test
    @DisplayName("Проверка перехода на страницу входа по кнопке Войти в форме восстановление пароля")
    public void successEnterToPasswordRecoveryForm() {
        HomePage homePage = new HomePage(driver);
        homePage.clickEnterToAccountButtonWithWait();
        homePage.clickRecoveryPasswordButton();
        homePage.clickEnterButtonDownForm();
        String actualEnterToPasswordRecoveryForm = homePage.getNameFormEnterToAccount();
        assertEquals("Не корректный результат", expectedNameFormEnterToAccount, actualEnterToPasswordRecoveryForm);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
