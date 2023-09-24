package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //Заголовок формы профиля
    private By profileTitle = By.xpath("//a[text()='Профиль']");
    //Кнопка конструктора
    private By constructorButton = By.xpath("//a[contains(p, 'Конструктор')]");
    //Логотип
    private By logotype = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    //Кнопка выхода
    private By signOutButton = By.xpath("//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Check if profile title visible")
    public boolean isProfileTittleVisible(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(profileTitle));
        return driver.findElement(profileTitle).isEnabled();
    }
    @Step("Click constructor button")
    public void clickConstructorButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(constructorButton));
        driver.findElement(constructorButton).click();
    }
    @Step("Click on logotype")
    public void clickOnLogotype(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(logotype));
        driver.findElement(logotype).click();
    }
    @Step("Click on sign out button")
    public void clickSignOutButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
        driver.findElement(signOutButton).click();
    }
}
