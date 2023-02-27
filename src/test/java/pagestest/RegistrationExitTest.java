package pagestest;

import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.assertEquals;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.Login;
import pages.UserClient;

import java.util.Random;

public class RegistrationExitTest {
    private WebDriver driver;

    private String name = "Вася";
    Random random = new Random();
    private String email = random.nextInt(100000) + "@yandex.ru";
    private String password = "123123";
    private String expectedNameFormEnterToAccount = "Вход";
    private String expectedErrorRegistration = "Некорректный пароль";
    private String accessToken;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        homePage.openSite();
        homePage.clickPersonalOfficeButton();
        homePage.clickRegistrationButton();
        homePage.fillNameRegistration(name);
        homePage.fillEmailRegistration(email);
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void createSuccessRegistrationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.fillPasswordRegistration(password);
        homePage.clickRegistrationConfirmButtonWithWait();

        UserClient userClient = new UserClient();
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);
        ValidatableResponse responseLogin = userClient.login(login);
        if (responseLogin.extract().statusCode() == 200) {
            accessToken = responseLogin.extract().path("accessToken").toString();
        }

        String actualNameFormEnterToAccount = homePage.getNameFormEnterToAccount();
        assertEquals("Не удалось зарегистрироваться", expectedNameFormEnterToAccount, actualNameFormEnterToAccount);
    }

    @Test
    @DisplayName("Проверка на ошибку для некорректного пароля")
    public void checkErrorForInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.fillPasswordRegistration("12345");
        homePage.clickRegistrationConfirmButton();
        String actualErrorRegistration = homePage.getNameErrorRegistration();
        assertEquals("Не корректный результат", expectedErrorRegistration, actualErrorRegistration);
    }

    @Test
    @DisplayName("Проверка успешного выхода по кнопке Выйти в личном кабинете")
    public void successExitTest() {
        HomePage homePage = new HomePage(driver);
        homePage.fillPasswordRegistration(password);
        homePage.clickRegistrationConfirmButtonWithWait();
        homePage.fillEmailEnter(email);
        homePage.fillPasswordEnter(password);
        homePage.clickEnterButtonFormLogin();
        homePage.clickPersonalOfficeButton();
        homePage.clickExitButton();
        String actualNameFormEnterToAccount = homePage.getNameFormEnterToAccount();
        assertEquals("Не корректный результат", expectedNameFormEnterToAccount, actualNameFormEnterToAccount);
    }

    @After
    public void teardown() {
        UserClient userClient = new UserClient();
        driver.quit();
        if (accessToken != null) {
            userClient.delete(accessToken);
        }
    }
}