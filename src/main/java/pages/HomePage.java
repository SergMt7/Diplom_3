package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String site = "https://stellarburgers.nomoreparties.site/";  //ссылка на сайт

    public void openSite() {    //открытие сайта
        driver.get(site);
    }
    public By personalOfficeButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a"); //локатор кнопки Личный кабинет
    public By registrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a"); //локатор кнопки Зарегистрироваться внизу формы Вход
    public By nameRegistration = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input"); //локатор поля ввода имени
    public By emailRegistration = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"); //локатор поля ввода почты
    public By passwordRegistration = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input"); //локатор поля ввода пароля
    public By registrationConfirmButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button"); //локатор кнопки Зарегистрироваться в форме регистрации для подтверждения
    public By formEnterToAccount = By.cssSelector(".Auth_login__3hAey > h2"); //локатор заголовка формы Вход
    public By errorForInvalidPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");
    public By textEnterFormTitle = By.xpath("//*[text()='Вход']"); //локатор заголовка формы Вход
    public By enterToAccountButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button"); //локатор кнопки Войти в аккаунт на главной странице
    public By enterButtonDownForm = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a"); //локатор кнопки Войти внизу формы
    public By recoveryPasswordButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a"); //локатор кнопки Восстановить пароль
    public By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p"); //локатор кнопки Конструктор на главной странице
    public By textConstructorTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/h1"); //локатор заголовка конструктора "Соберите бургер"
    public By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a"); //локатор кнопки логотипа на главной странице
    public By emailEnter = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input"); //локатор поля ввода почты в форме Вход
    public By passwordEnter = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"); //локатор поля ввода пароля в форме Ввод
    public By enterButtonFormLogin = By.xpath("//*[@id=\"root\"]/div/main/div/form/button"); //локатор кнопки Войти внизу формы Вход на странице логина
    public By exitButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button"); //локатор кнопки Выход в разделе Личный кабинет
    public By textExitButtonTitle = By.xpath("//*[text()='Выход']"); //локатор кнопки Выход
    private final By sectionBunsButton = By.xpath(".//span[text()='Булки']"); //локатор кнопки раздела Булки
    private final By sectionSaucesButton = By.xpath(".//span[text()='Соусы']"); //локатор кнопки раздела Соусы
    private final By sectionFillingsButton = By.xpath(".//span[text()='Булки']"); //локатор кнопки раздела Начинки
    public By textCreateOrder = By.xpath("//*[text()='Оформить заказ']");
    private By resultSection = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]//span"); //локатор выбранной секции

    public void standBy(By element) { //Ожидание элемента
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public void clickPersonalOfficeButton() {
        driver.findElement(personalOfficeButton).click();
    }
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    public void fillNameRegistration(String name) {
        driver.findElement(nameRegistration).sendKeys(name);
    }
    public void fillEmailRegistration(String email) {
        driver.findElement(emailRegistration).sendKeys(email);
    }
    public void fillPasswordRegistration(String password) {
        driver.findElement(passwordRegistration).sendKeys(password);
    }
    public String getNameFormEnterToAccount() { //метод возврата названия формы Вход
        return driver.findElement(formEnterToAccount).getText();
    }
    public String getNameErrorRegistration() { //метод возврата текста ошибки при некорректном пароле менее
        return driver.findElement(errorForInvalidPassword).getText();
    }
    public void clickRegistrationConfirmButtonWithWait() { //метод клика кнопки Зарегистрироваться с ожиданием перехода и поиском на страницу Вход
        driver.findElement(registrationConfirmButton).click();
        standBy(textEnterFormTitle);
    }
    public void clickRegistrationConfirmButton() { //метод клика кнопки Зарегистрироваться без ожидания
        driver.findElement(registrationConfirmButton).click();
    }
    public void clickEnterToAccountButtonWithWait() { //метод клика Войти с ожидание перехода на страницу формы Вход
        driver.findElement(enterToAccountButton).click();
        standBy(textEnterFormTitle);
    }
    public void clickEnterButtonDownForm() {
        driver.findElement(enterButtonDownForm).click();
        standBy(textEnterFormTitle);
    }
    public void clickRecoveryPasswordButton() {
        driver.findElement(recoveryPasswordButton).click();
    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
        standBy(textConstructorTitle);
    }
    public String getTextConstructorTitle() { //метод возврата заголовка конструктора "Соберите бургер"
        return driver.findElement(textConstructorTitle).getText();
    }
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
        standBy(textConstructorTitle);
    }
    public void fillEmailEnter(String email) { //метод ввода почты в форме Вход
        driver.findElement(emailEnter).sendKeys(email);
    }
    public void fillPasswordEnter(String password) { //метод ввода пароля в форме Вход
        driver.findElement(passwordEnter).sendKeys(password);
    }
    public void clickEnterButtonFormLogin() { //метод клика Войти в форме Ввод на станице логина
        driver.findElement(enterButtonFormLogin).click();
        standBy(textCreateOrder);
    }
    public void clickExitButton() { //метод клика Выход в разделе Личный кабинет с ожидание перехода на страницу формы Вход
        standBy(textExitButtonTitle);
        driver.findElement(exitButton).click();
        standBy(textEnterFormTitle);
    }
    public void clickBunsButton() { //метод клика по кнопке раздела Булки
        driver.findElement(sectionBunsButton);
        new WebDriverWait(driver, Duration.ofSeconds(1));
    }
    public void clickSaucesButton() { //метод клика по кнопке раздела Соусы
        driver.findElement(sectionSaucesButton);
        new WebDriverWait(driver, Duration.ofSeconds(1));
    }
    public void clickFillingsButton() { //метод клика по кнопке раздела Начинки
        driver.findElement(sectionFillingsButton);
        new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public String getTextCreateOrder() { //метод возврата названия кнопки Оформить заказ
        return driver.findElement(textCreateOrder).getText();
    }
    public By getResultSection() { //метод возврата выбранного раздела
        return resultSection;
    }
}