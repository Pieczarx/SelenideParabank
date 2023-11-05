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
import parabank.tests.BaseTest;

public class InvalidFindLoginInfoTest extends BaseTest {
    @Test(description = "TC06: brak city")
    @Severity(SeverityLevel.BLOCKER)
    public void nullCityInput() {
        //When
        forgotLoginInfoPage = new ForgotLoginInfoPage(driver);
        forgotLoginInfoPage.forgotLoginInfoValidData(standardUser.getFirstName(), standardUser.getLastName(), standardUser.getAddress(), "", standardUser.getState(), standardUser.getZipCode(), standardUser.getSsn());
        //Then
        forgotLoginInfoPage.inputCityErrorShouldBe("City is required.");
    }
    @Test(description = "TC07: nieprawidlowa dana - ssn")
    @Severity(SeverityLevel.BLOCKER)
    public void invalidFindLoginInfo() {
        //When
        forgotLoginInfoPage = new ForgotLoginInfoPage(driver);
        forgotLoginInfoPage.forgotLoginInfoValidData(standardUser.getFirstName(), standardUser.getLastName(), standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(),"invalidData");
        //Then
        //Assert.assertEquals(pageElements.getFindLoginInfoMessage(), message);
        forgotLoginInfoPage.errorMessageShouldBe("The customer information provided could not be found.");
    }
}
