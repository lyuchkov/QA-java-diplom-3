import client.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.LoginPage;
import page_objects.SignUpPage;
import pojos.User;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static utils.BrowserFactory.getWebDriver;

public class SignUpTest {
    protected WebDriver driver;

    @Before
    public void before() {
        driver = getWebDriver();

        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Check correct sign up")
    public void successfulSignUpTest() {
        User user = getNewBasicUserObject();

        sendUserDataAndClickSubmit(user);

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        LoginPage loginPage = new LoginPage(driver);

        assertEquals("Войти", loginPage.getLoginFormTitle());
        UserClient userClient = new UserClient();
        userClient.loginAndDeleteUser(user);
    }


    @Test
    @DisplayName("Check sign up with short password")
    @Description("Data deletion is not performed, because if the registration passes, the test will not be passed")
    public void shortPasswordSignUpTest() {
        User user = getNewBasicUserObject();
        user.setPassword("12");

        sendUserDataAndClickSubmit(user);

        assertEquals(SignUpPage.URL, driver.getCurrentUrl());
    }

    @Step("Create new user object")
    private User getNewBasicUserObject() {
        return new User("name-email" + ThreadLocalRandom.current().nextInt(0, 9999999) + "@yandex.ru",
                "password" + ThreadLocalRandom.current().nextInt(0, 9999),
                "Name" + ThreadLocalRandom.current().nextInt(0, 9999));
    }

    @Step("Send user credentials to sign up form and click submit")
    private void sendUserDataAndClickSubmit(User user) {
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.waitForNameFieldBeenDisplayed();
        signUpPage.clickNameField();
        signUpPage.setNameField(user.getName());

        signUpPage.waitForEmailFieldBeenDisplayed();
        signUpPage.clickEmailField();
        signUpPage.setEmailField(user.getEmail());

        signUpPage.waitForPasswordFieldBeenDisplayed();
        signUpPage.clickPasswordField();
        signUpPage.setPasswordField(user.getPassword());

        signUpPage.clickSubmitButton();
    }

}
