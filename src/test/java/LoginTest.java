import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page_objects.MainPage;
import page_objects.PasswordRecoveryPage;
import page_objects.SignUpPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends AuthBaseTest {
    @Test
    @DisplayName("Check login after click sign in button on main page")
    public void successfulLoginAfterClickSignInButtonOnMainPageTest() {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSignInButton();

        enterCredentialsOnLoginPageAndClickSubmit();
        assertTrue(mainPage.isSignCollectBurgerVisible());
        assertEquals(MainPage.URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check login after click profile button on main page")
    public void successfulLoginAfterClickAccountButtonOnMainPageTest() {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickProfileButton();

        enterCredentialsOnLoginPageAndClickSubmit();

        assertTrue(mainPage.isSignCollectBurgerVisible());
        assertEquals(MainPage.URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check login after click sign in button on sign up page")
    public void successfulLoginAfterClickSignInButtonOnSignUpPageTest() {
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        enterCredentialsOnLoginPageAndClickSubmit();
        MainPage mainPage = new MainPage(driver);

        assertTrue(mainPage.isSignCollectBurgerVisible());
        assertEquals(MainPage.URL, driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check login after click sign in button on password recovery page")
    public void successfulLoginAfterClickSignInButtonOnPasswordRecoveryPageTest() {
        driver.get(PasswordRecoveryPage.URL);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);

        passwordRecoveryPage.clickSignInButton();

        enterCredentialsOnLoginPageAndClickSubmit();

        MainPage mainPage = new MainPage(driver);

        assertTrue(mainPage.isSignCollectBurgerVisible());
        assertEquals(MainPage.URL, driver.getCurrentUrl());
    }
}
