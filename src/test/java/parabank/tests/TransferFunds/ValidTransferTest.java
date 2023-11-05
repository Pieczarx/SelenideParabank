package parabank.tests.TransferFunds;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.pages.ForgotLoginInfoPage;
import parabank.pages.LoginPage;
import parabank.pages.PageObjects;
import parabank.pages.TranferFundsPage;
import parabank.tests.BaseTest;

public class ValidTransferTest extends BaseTest {

    public void openParaBank() {
        driver.get(BASE_URL);
    }
    @Test(description = "TC01: poprawnie wykonany transfer środków")
    @Severity(SeverityLevel.BLOCKER)
    public void validTransfer() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
        //When
        tranferFundsPage = new TranferFundsPage(driver);
        tranferFundsPage.getIntoTransferFunds();
        tranferFundsPage.waitForNextMove();
        tranferFundsPage.enterAmount("10000");
        tranferFundsPage.selectAccounts();
        tranferFundsPage.sendMoney();
        tranferFundsPage.waitForNextMove();
        //Then
        Assert.assertEquals(pageElements.transferFundsTitle(), tranferFundsPage.getPageTitle());
    }
}

