package parabank.tests.UpdateContactInfo;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import parabank.pages.LoginPage;
import parabank.pages.UpdateContactInfoPage;
import parabank.tests.BaseTest;

public class InvalidUpdateContactInfoTest extends BaseTest {
    @Test(description = "TC01: pusty formularz")
    @Severity(SeverityLevel.BLOCKER)
    public void emptyAllFields() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
        //When
        updateContactInfoPage = new UpdateContactInfoPage(driver);
        updateContactInfoPage.clearAllFields();
        //Then
        updateContactInfoPage.compareErrors(updateContactInfoPage.getErrorMessages());
    }
    @Test(description = "TC02: puste 1 pole")
    @Severity(SeverityLevel.BLOCKER)
    public void emptyOneField() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
        //When
        updateContactInfoPage = new UpdateContactInfoPage(driver);
        updateContactInfoPage.clickUpdateContactInfoLink();
        updateContactInfoPage.waitForNextMove();
        updateContactInfoPage.clearFieldAndSendKeys(updateContactInfoPage.addressField, "");
        //Then
        updateContactInfoPage.errorMessageShouldBe("Address is required.");
    }
}