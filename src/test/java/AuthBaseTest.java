import client.UserClient;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.LoginPage;
import page_objects.MainPage;
import pojos.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthBaseTest {
    protected WebDriver driver;

    private User userCredentials;

    static {
        WebDriverManager.chromedriver().setup();
    }
    @Step("Enter the correct data and login")
    protected void enterCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.waitForEmailFieldBeenDisplayed();
        loginPage.clickEmailField();
        loginPage.setEmailField(userCredentials.getEmail());

        loginPage.waitForPasswordFieldBeenDisplayed();
        loginPage.clickPasswordField();
        loginPage.setPasswordField(userCredentials.getPassword());

        loginPage.clickSubmitButton();
        MainPage mainPage = new MainPage(driver);

        assertTrue(mainPage.isSignCollectBurgerVisible());

        assertEquals(MainPage.URL, driver.getCurrentUrl());
    }

    @Step("Create new user data by API")
    private User getUserCredentials(){
        UserClient userClient = new UserClient();
        User user = userClient.getBasicUserCreationResponse();
        if(user==null){
            throw new RuntimeException("User is not created by API");
        }
        return user;
    }
    @Before
    public void before(){
        driver = new ChromeDriver();

        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";

        userCredentials = getUserCredentials();
    }
    @After
    public void after(){
        driver.quit();
    }
}
