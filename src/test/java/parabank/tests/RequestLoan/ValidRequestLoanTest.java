package parabank.tests.RequestLoan;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.pages.FindTransactionsPage;
import parabank.pages.LoginPage;
import parabank.pages.OpenNewAccountPage;
import parabank.pages.RequestLoanPage;
import parabank.tests.BaseTest;

public class ValidRequestLoanTest extends BaseTest {
@BeforeMethod
public void setup(){
    loginPage = new LoginPage(driver);
    openNewAccountPage = new OpenNewAccountPage(driver);
    loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());

}
    @Test(description = "TC01: poprawnie udzielona pożyczka")
    @Severity(SeverityLevel.BLOCKER)
    public void validRequestLoan() {
        //When
        requestLoanPage = new RequestLoanPage(driver);
        requestLoanPage.getIntoRequestLink();
        requestLoanPage.enterAmount("100");
        requestLoanPage.enterDownPayment("10");
        requestLoanPage.selectAccount();
        requestLoanPage.applyNow();
        //Then
        Assert.assertEquals(pageElements.getSuccesfulRequestLoanMessage(), requestLoanPage.getRequestLoanMessage());
    }

}

