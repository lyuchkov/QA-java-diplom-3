package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {
    private static final String YANDEX_BROWSER = "yandex";

    public static WebDriver getWebDriver(){
        Properties properties = new Properties();
        String browser = readingBrowserNameProperty(properties);
        if(YANDEX_BROWSER.equalsIgnoreCase(browser)){
            return getYandexBrowserDriver(properties);
        }else{
            return getChromeDriver();
        }
    }

    private static ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static ChromeDriver getYandexBrowserDriver(Properties properties) {
        String browserPath = properties.getProperty("yandex.browser.path");
        String driverPath = properties.getProperty("yandex.driver.path");
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(browserPath);
        return new ChromeDriver(options);
    }

    private static String readingBrowserNameProperty(Properties properties) {
        try {
            properties.load(new FileInputStream("src/test/resources/test.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty("browser");
    }
}
