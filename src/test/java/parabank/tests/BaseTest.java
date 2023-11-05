
package parabank.tests;


import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.*;
import parabank.model.PageElements;
import parabank.model.User;
import parabank.pages.*;
/*
public class BaseTest {

    public static WebDriver driver;
    public RegisterPage registerPage;

    public LoginPage loginPage;
    public ForgotLoginInfoPage forgotLoginInfoPage;
    public OpenNewAccountPage openNewAccountPage;
    public TranferFundsPage tranferFundsPage;
    public FindTransactionsPage findTransactionsPage;
    public BillPayPage billPayPage;
    public UpdateContactInfoPage updateContactInfoPage;
    public RequestLoanPage requestLoanPage;

    protected User standardUser = new User("name", "surname","street","city","state","code","123456789","123","username","password");
    public PageElements pageElements = new PageElements();


    protected static final String BASE_URL = "https://parabank.parasoft.com/parabank";
   //zmienna statyczna przyjmująca driver

    //ustawienie przeglądarki przed każdym testem
    @BeforeClass
    public static void setUpChromeDriver() {
        driver = DriverFactory.getDriver(DriverFactory.BrowserType.CHROME);
        driver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDownDriver() {
        //driver.quit();
        //DriverFactory.quitDriver();
    }
//    @AfterTest
//    public void clearBrowser() {
//        driver.manage().deleteAllCookies();
//        LocalStorage local = ((WebStorage) driver).getLocalStorage();
//        local.clear();
//    }

//    @BeforeClass
//    public void openSouceDemoPage() {
//        driver.get(BASE_URL);
//    }

    //otworzenie strony
//    @BeforeTest
//    public void openSouceDemoPage() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get(BASE_URL);
//    }

    //wyczyszczenie przeglądarki przed każdym testem
//    @AfterMethod
//    public void clearBrowser() {
//        driver.manage().deleteAllCookies();
//        LocalStorage local = ((WebStorage) driver).getLocalStorage();
//        local.clear();
//
//    }

//    @BeforeTest
//    public static void driverSetup(){
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//    }
//    @AfterTest
//    public static void driverQuit(){
//
//        driver.quit();
//    }

}
*/