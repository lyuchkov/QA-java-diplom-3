import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.LoginPage;
import page_objects.SignUpPage;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignUpTest {
    protected WebDriver driver;
    static {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    @DisplayName("Check correct sign up")
    public void successfulSignUpTest(){
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.waitForNameFieldBeenDisplayed();
        signUpPage.clickNameField();
        signUpPage.setNameField("Имя");

        signUpPage.waitForEmailFieldBeenDisplayed();
        signUpPage.clickEmailField();
        signUpPage.setEmailField("email" + ThreadLocalRandom.current().nextInt(0, 9999999)+"@yandex.ru");

        signUpPage.waitForPasswordFieldBeenDisplayed();
        signUpPage.clickPasswordField();
        signUpPage.setPasswordField("password1234");

        signUpPage.clickSubmitButton();


        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        LoginPage loginPage = new LoginPage(driver);

        assertEquals("Войти",loginPage.getLoginFormTitle());
    }
    @Test
    @DisplayName("Check sign up with short password")
    public void shortPasswordSignUpTest(){
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.waitForNameFieldBeenDisplayed();
        signUpPage.clickNameField();
        signUpPage.setNameField("Имя");
        signUpPage.waitForEmailFieldBeenDisplayed();
        signUpPage.clickEmailField();
        signUpPage.setEmailField("email" + ThreadLocalRandom.current().nextInt(0, 9999999)+"@yandex.ru");
        signUpPage.waitForPasswordFieldBeenDisplayed();
        signUpPage.clickPasswordField();
        signUpPage.setPasswordField("12");
        signUpPage.clickSubmitButton();
        assertEquals(SignUpPage.URL, driver.getCurrentUrl());
    }

    @Before
    public void before(){
        driver = new ChromeDriver();
    }
    @After
    public void after(){
        driver.quit();
    }
}
