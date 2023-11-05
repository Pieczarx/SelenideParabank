package parabank.tests.LoginAndLogout;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import parabank.pages.LoginPage;
import parabank.tests.BaseTest;

public class ValidLoginAndLogoutTest extends BaseTest {
    @Test(description = "TC01: poprawne logowanie")
    @Severity(SeverityLevel.BLOCKER)
    public void validLogin() {

        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());

    }
    @Test(description = "TC02: poprawne wylogowanie", dependsOnMethods = "validLogin")
    @Severity(SeverityLevel.BLOCKER)
    public void validLogout() {
        loginPage.logOutUser();
    }
}
