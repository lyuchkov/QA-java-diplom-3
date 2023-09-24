import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page_objects.MainPage;
import page_objects.PasswordRecoveryPage;
import page_objects.SignUpPage;

public class LoginTest extends AuthBaseTest {

    @Test
    @DisplayName("Check login after click sign in button on main page")
    public void successfulLoginAfterClickSignInButtonOnMainPageTest() {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSignInButton();

        enterCredentials();
    }

    @DisplayName("Check login after click profile button on main page")
    @Test
    public void successfulLoginAfterClickAccountButtonOnMainPageTest() {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickProfileButton();

        enterCredentials();
    }

    @Test
    @DisplayName("Check login after click sign in button on sign up page")
    public void successfulLoginAfterClickSignInButtonOnSignUpPageTest() {
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        enterCredentials();
    }
    @Test
    @DisplayName("Check login after click sign in button on password recovery page")
    public void successfulLoginAfterClickSignInButtonOnPasswordRecoveryPageTest() {
        driver.get(PasswordRecoveryPage.URL);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);

        passwordRecoveryPage.clickSignInButton();

        enterCredentials();
    }


}
