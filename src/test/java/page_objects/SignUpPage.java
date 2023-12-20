package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SignUpPage {
    private WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    //Поле для ввода имени
    private By nameInput = By.xpath("//div[contains(label, 'Имя')]/input");
    //Поле для ввода email
    private By emailInput = By.xpath("//div[contains(label, 'Email')]/input");
    //Поле для ввода пароля
    private By passwordInput = By.xpath("//div[contains(label, 'Пароль')]/input");
    //Кнопка зарегистрироваться
    private By submitButton = By.xpath("//button[text()='Зарегистрироваться']");
    //Надпись некорректный пароль
    private By incorrectPassword = By.xpath("//p[text()='Некорректный пароль']");
    //Кнопка для перехода в форму логина
    private By signInButton = By.xpath("//a[text()='Войти']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Send name to input field")
    public void setNameField(String name){
        driver.findElement(nameInput).sendKeys(name);
    }
    @Step("Click on name field")
    public void clickNameField(){
        driver.findElement(nameInput).click();
    }
    @Step("Wait for name field been displayed")
    public void waitForNameFieldBeenDisplayed(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(nameInput)));
    }
    @Step("Send email to input field")
    public void setEmailField(String email){
        driver.findElement(emailInput).sendKeys(email);
    }
    @Step("Click on email field")
    public void clickEmailField(){
        driver.findElement(emailInput).click();
    }
    @Step("Wait for email field been displayed")
    public void waitForEmailFieldBeenDisplayed(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(emailInput)));
    }
    @Step("Send password to input field")
    public void setPasswordField(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    @Step("Click on password field")
    public void clickPasswordField(){
        driver.findElement(passwordInput).click();
    }
    @Step("Wait for password field been displayed")
    public void waitForPasswordFieldBeenDisplayed(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(passwordInput)));
    }
    @Step("Click submit button")
    public void clickSubmitButton() {
        driver.findElement(submitButton).submit();
    }
    @Step("Click sign in button")
    public void clickSignInButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        driver.findElement(signInButton).click();
    }
}
