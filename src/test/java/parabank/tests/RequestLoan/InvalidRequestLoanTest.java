package parabank.tests.RequestLoan;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.pages.LoginPage;
import parabank.pages.OpenNewAccountPage;
import parabank.pages.RequestLoanPage;
import parabank.tests.BaseTest;

public class InvalidRequestLoanTest extends BaseTest {
@BeforeMethod
public void setup(){
    loginPage = new LoginPage(driver);
    openNewAccountPage = new OpenNewAccountPage(driver);
    loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());

}
    @Test(description = "TC02: Niepoprawnie udzielona pożyczka - niewystarczające środki na zaliczkę")
    @Severity(SeverityLevel.BLOCKER)
    public void requestLoanNotEnoughFundsForADownPayment() {
        //When
        requestLoanPage = new RequestLoanPage(driver);
        requestLoanPage.getIntoRequestLink();
        requestLoanPage.enterAmount("1000000000");
        requestLoanPage.enterDownPayment("10000000");
        requestLoanPage.selectAccount();
        requestLoanPage.applyNow();
        //Then
        requestLoanPage.secondErrorMessageShouldBe("You do not have sufficient funds for the given down payment.");
    }
    @Test(description = "TC03: Niepoprawnie udzielona pożyczka - niepoprawna wartość")
    @Severity(SeverityLevel.BLOCKER)
    public void requestLoanWrongValue() {
        //When
        requestLoanPage = new RequestLoanPage(driver);
        requestLoanPage.getIntoRequestLink();
        requestLoanPage.enterAmount("aa");
        requestLoanPage.enterDownPayment("aa");
        requestLoanPage.selectAccount();
        requestLoanPage.applyNow();
        //Then
        requestLoanPage.errorMessageShouldBe("An internal error has occurred and has been logged.");
    }
}

