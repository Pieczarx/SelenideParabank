package parabank.tests.OpenNewAccount;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.pages.LoginPage;
import parabank.pages.OpenNewAccountPage;
import parabank.tests.BaseTest;
public class ValidOpenNewAccountTest extends BaseTest {
    @BeforeClass
    public void setup(){
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
    }
    @Test(description = "TC01: Poprawne otwarcie nowego konta ")
    @Severity(SeverityLevel.BLOCKER)
    public void validOpening(){
        //When
        openNewAccountPage = new OpenNewAccountPage(driver);
        openNewAccountPage.openNew(1);
        openNewAccountPage.waitForNextMove();

        //Then
        Assert.assertEquals(pageElements.getAccountOpenedTitle(), openNewAccountPage.getPageTitle());
    }
}