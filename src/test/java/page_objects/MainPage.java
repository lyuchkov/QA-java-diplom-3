package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    private WebDriver driver;

    //Надпись соберите бургер
    private By collectBurgerSign = By.xpath("//h1[text()='Соберите бургер']");
    //Кнопка войти в аккаунт
    private By signInButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Кнопка личный кабинет
    private By profileButton = By.xpath("//a[contains(p, 'Личный Кабинет')]");
    //Кнопка раздела "Начинки"
    private By fillingsButton = By.xpath("//div[contains(span, 'Начинки')]");
    //Кнопка раздела "Соусы"
    private By sauceButton = By.xpath("//div[contains(span, 'Соусы')]");
    //Кнопка раздела "Булки"
    private By bunsButton = By.xpath("//div[contains(span, 'Булки')]");
    //Класс активного раздела конструктора
    private By activeConstructorSection = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check if collect burger sign is visible")
    public boolean isSignCollectBurgerVisible(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(collectBurgerSign));
        return driver.findElement(collectBurgerSign).getText().equals("Соберите бургер");
    }
    @Step("Click sign in button")
    public void clickSignInButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        driver.findElement(signInButton).click();
    }
    @Step("Click profile button")
    public void clickProfileButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        driver.findElement(profileButton).click();
    }
    @Step("Click filling button in constructor")
    public void clickFillingButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(fillingsButton));
        driver.findElement(fillingsButton).click();
    }
    @Step("Click sauce button in constructor")
    public void clickSauceButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(sauceButton));
        driver.findElement(sauceButton).click();
    }
    @Step("Click bun button in constructor")
    public void clickBunButton(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(bunsButton));
        driver.findElement(bunsButton).click();
    }
    @Step("Get active constructor section name")
    public String getActiveConstructorSectionName(){
        return driver.findElement(activeConstructorSection).getText();
    }
}
