package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";
    //Кнопка войти
    private By loginFormSubmitButton = By.xpath("//button[text()='Войти']");
    //Поле для ввода почты
    private By emailInput = By.xpath("//div[contains(label, 'Email')]/input");
    //Поле для ввода пароля
    private By passwordInput = By.xpath("//div[contains(label, 'Пароль')]/input");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get login form title")
    public String getLoginFormTitle(){
        return driver.findElement(loginFormSubmitButton).getText();
    }
    @Step("Send email to input field")
    public void setEmailField(String email){
        driver.findElement(emailInput).sendKeys(email);
    }
    @Step("Click on email input field")
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
    @Step("Click on password input field")
    public void clickPasswordField(){
        driver.findElement(passwordInput).click();
    }
    @Step("Wait for email field been displayed")
    public void waitForPasswordFieldBeenDisplayed(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(passwordInput)));
    }
    @Step("Click on submit button")
    public void clickSubmitButton() {
        driver.findElement(loginFormSubmitButton).submit();
    }
}
