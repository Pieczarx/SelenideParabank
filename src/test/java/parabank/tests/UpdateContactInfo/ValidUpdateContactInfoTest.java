package parabank.tests.UpdateContactInfo;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import parabank.pages.LoginPage;
import parabank.pages.RegisterPage;
import parabank.pages.UpdateContactInfoPage;
import parabank.tests.BaseTest;

public class ValidUpdateContactInfoTest extends BaseTest {
    @Test(description = "TC01: poprawna aktualizacja informacji")
    @Severity(SeverityLevel.BLOCKER)
    public void validUpdateContactInfo() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
        //When
        updateContactInfoPage = new UpdateContactInfoPage(driver);
        updateContactInfoPage.changeAllData("change");
        updateContactInfoPage.waitForNextMove();
        String pageTitle = updateContactInfoPage.getPageTitle();
        //Then
        Assert.assertEquals(pageElements.getUpdateProfileInfoTitle(), pageTitle);
    }

}
