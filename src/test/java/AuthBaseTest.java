import client.UserClient;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import page_objects.LoginPage;
import pojos.User;

import static utils.BrowserFactory.getWebDriver;

public class AuthBaseTest {
    protected WebDriver driver;

    private User userCredentials;


    @Step("Enter the correct data and click submit button")
    protected void enterCredentialsOnLoginPageAndClickSubmit() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.waitForEmailFieldBeenDisplayed();
        loginPage.clickEmailField();
        loginPage.setEmailField(userCredentials.getEmail());

        loginPage.waitForPasswordFieldBeenDisplayed();
        loginPage.clickPasswordField();
        loginPage.setPasswordField(userCredentials.getPassword());

        loginPage.clickSubmitButton();
    }

    @Step("Create new user data by API")
    protected User getUserCredentials() {
        UserClient userClient = new UserClient();
        User user = userClient.getBasicUserCreationResponse();
        if (user == null) {
            throw new RuntimeException("User is not created by API");
        }
        return user;
    }

    @Step("Delete user data")
    protected void deleteUserData(User user) {
        System.out.println("REMOVE USER DATA");
        UserClient userClient = new UserClient();
        userClient.deleteUser(user);
    }

    @Before
    public void before() {
        driver = getWebDriver();

        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";

        userCredentials = getUserCredentials();
    }

    @After
    public void after() {
        deleteUserData(userCredentials);

        driver.quit();
    }
}
