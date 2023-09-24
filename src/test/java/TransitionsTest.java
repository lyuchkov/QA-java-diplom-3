import com.sun.tools.javac.Main;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.LoginPage;
import page_objects.MainPage;
import page_objects.ProfilePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransitionsTest extends AuthBaseTest {

    @Test
    @DisplayName("Check transition from main page to profile page")
    public void transitionFromMainToProfilePageTest() {
        driver.get(LoginPage.URL);
        enterCredentials();

        driver.get(MainPage.URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);

        assertTrue(profilePage.isProfileTittleVisible());
    }
    @Test
    @DisplayName("Check transition from profile to main page by click constructor button")
    public void transitionFromProfileToConstructorPageTest(){
        driver.get(LoginPage.URL);
        enterCredentials();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.clickConstructorButton();

        assertEquals(MainPage.URL, driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check transition from profile page to main page by click on logotype")
    public void transitionFromProfileToConstructorPageByLogotypeTest(){
        driver.get(LoginPage.URL);
        enterCredentials();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.clickOnLogotype();

        assertEquals(MainPage.URL, driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check sign out")
    public void signOutTest(){
        driver.get(LoginPage.URL);
        enterCredentials();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.clickSignOutButton();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe(LoginPage.URL));
        assertEquals(LoginPage.URL, driver.getCurrentUrl());
    }
}
