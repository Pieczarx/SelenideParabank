package parabank.tests.TransferFunds;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.pages.LoginPage;
import parabank.pages.TranferFundsPage;
import parabank.tests.BaseTest;

public class InvalidTransferTest extends BaseTest {
    @Test(description = "TC02: niepoprawnie wykonany transfer środków - niepoprawna wartość w polu amount")
    @Severity(SeverityLevel.BLOCKER)
    public void invalidTransfer() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
        //When
        tranferFundsPage = new TranferFundsPage(driver);
        tranferFundsPage.getIntoTransferFunds();
        tranferFundsPage.waitForNextMove();
        tranferFundsPage.enterAmount("abc");
        tranferFundsPage.selectAccounts();
        tranferFundsPage.sendMoney();
        tranferFundsPage.waitForNextMove();
        tranferFundsPage.errorMessageShouldBe("Please enter a valid amount.");
    }
}

