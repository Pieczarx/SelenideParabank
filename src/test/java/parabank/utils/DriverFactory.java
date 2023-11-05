package parabank.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {
        // Prywatny konstruktor, aby zapobiec tworzeniu instancji tej klasy
    }


    public static WebDriver getDriver(BrowserType browserType) {
        if (driver == null) {
            switch (browserType) {
                case CHROME:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                // Dodaj obsługę innych przeglądarek w razie potrzeby
                default:
                    throw new IllegalArgumentException("Niewspierana przeglądarka: " + browserType);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public enum BrowserType {
        CHROME,
        FIREFOX
        // Dodaj obsługę innych przeglądarek w razie potrzeby
    }
}
