import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    protected WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    @DisplayName("Check transition from bun to filling on main page")
    public void transitionToFillingTest() {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingButton();
        assertEquals("Начинки", mainPage.getActiveConstructorSectionName());
    }

    @Test
    @DisplayName("Check transition from bun to sauce on main page")
    public void transitionToSauceTest() {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSauceButton();
        assertEquals("Соусы", mainPage.getActiveConstructorSectionName());
    }

    @Test
    @DisplayName("Check transition from sauce to bun on main page")
    public void transitionFromSauceToBunTest() {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        assertEquals("Булки", mainPage.getActiveConstructorSectionName());
    }

    @Test
    @DisplayName("Check transition from filling to bun on main page")
    public void transitionFromFillingToBunTest() {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        assertEquals("Булки", mainPage.getActiveConstructorSectionName());
    }

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }
}
