package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordRecoveryPage {
    private WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Кнопка войти
    private By signInButton = By.xpath("//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on sign in button")
    public void clickSignInButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        driver.findElement(signInButton).click();
    }
}
