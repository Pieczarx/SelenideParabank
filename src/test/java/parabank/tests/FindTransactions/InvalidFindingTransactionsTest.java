package parabank.tests.FindTransactions;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.pages.FindTransactionsPage;
import parabank.pages.LoginPage;
import parabank.pages.TranferFundsPage;
import parabank.tests.BaseTest;

public class InvalidFindingTransactionsTest extends BaseTest {
    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
    }
    @Test(description = "TC05: Nieprawidłowa wartość w polu szukania transakcji")
    @Severity(SeverityLevel.BLOCKER)
    public void invalidFindingTransaction() {
        //When
        findTransactionsPage = new FindTransactionsPage(driver);
        findTransactionsPage.getIntoFindTransactionClick();
        findTransactionsPage.waitForNextMove();
        findTransactionsPage.selectAccount();
        findTransactionsPage.enterId("asdfg");
        findTransactionsPage.findTransactionsByIdClick();
        findTransactionsPage.errorMessageShouldBe("An internal error has occurred and has been logged.");
    }
}
