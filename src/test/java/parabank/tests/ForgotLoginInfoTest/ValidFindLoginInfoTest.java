package parabank.tests.ForgotLoginInfoTest;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.pages.ForgotLoginInfoPage;
import parabank.pages.LoginPage;
import parabank.pages.RegisterPage;
import parabank.tests.BaseTest;

import static parabank.tests.BaseTest.driver;

public class ValidFindLoginInfoTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
        loginPage.logOutUser();
    }
    @Test(description = "TC05: poprawnie wypelniony formularz")
    @Severity(SeverityLevel.BLOCKER)
    public void validFindLoginInfo() {
        //When
        forgotLoginInfoPage = new ForgotLoginInfoPage(driver);
        String message = forgotLoginInfoPage.forgotLoginInfoValidData(standardUser.getFirstName(), standardUser.getLastName(), standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(), standardUser.getSsn()).getRightPanelMessage();

        //Then
        Assert.assertEquals(pageElements.getFindLoginInfoMessage(), message);
    }
}
