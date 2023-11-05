package parabank.tests.Register;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import parabank.pages.RegisterPage;
import parabank.tests.BaseTest;

public class ValidRegisterTest extends BaseTest {
    @Test(description = "TC01: poprawna rejestracja")
    @Severity(SeverityLevel.BLOCKER)
    public void validRegister() {
        //When
        registerPage = new RegisterPage(driver);
        String pageTitle = registerPage.registerAsValidUser(standardUser.getFirstName(), standardUser.getLastName(), standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(), standardUser.getPhone(), standardUser.getSsn(), standardUser.getUsername(), standardUser.getPassword(), standardUser.getPassword()).getPageTitle();
        //Then
        Assert.assertEquals(pageElements.getRegisterAccountTitle(standardUser.getUsername()), pageTitle);
    }
}
