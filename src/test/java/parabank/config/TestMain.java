package parabank.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import parabank.config.properties.ConstantValues;
import org.apache.commons.io.FileUtils;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import parabank.config.browser.Browser;

import java.io.File;
import java.io.IOException;

import static parabank.config.properties.ConstantValues.BROWSER_MAXIMIZED;

public abstract class TestMain {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuit() {
        //test for properties
        System.out.println(Configuration.baseUrl);
        //write out java version
        System.out.println(System.getProperty("java.version"));
        Browser.setUp();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
//        // Ustawienia preferencji przeglądarki
//        Configuration.browser = "chrome"; // Wybór przeglądarki (np. "chrome", "firefox", "edge", itp.)
//        Configuration.baseUrl = "https://practice.automationbro.com/";
//        Configuration.browserSize = "1920x1080";
//        // Bazowy adres strony do testowania
//        Configuration.timeout = 10000; // Czas oczekiwania na elementy (w milisekundach)
        Selenide.open(ConstantValues.TEST_URL);
        if(BROWSER_MAXIMIZED) {
            WebDriverRunner.getWebDriver().manage().window().maximize();
        }
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        WebDriverRunner.closeWebDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverRunner.closeWebDriver();
        try {
            FileUtils.deleteDirectory(new File(Configuration.downloadsFolder));
        } catch (IOException e) {
            System.out.println(String.format("Failed to clean download directory: %s", e.getMessage()));
            Reporter.log(String.format("Failed to clean downloads directory: %s", e.getMessage()));
        }
    }

}
