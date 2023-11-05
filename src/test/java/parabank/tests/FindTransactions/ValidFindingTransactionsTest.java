package parabank.tests.FindTransactions;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.pages.FindTransactionsPage;
import parabank.pages.LoginPage;
import parabank.tests.BaseTest;

public class ValidFindingTransactionsTest extends BaseTest {
@BeforeMethod
public void setup(){
    loginPage = new LoginPage(driver);
    loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
}
    @Test(description = "TC01: poprawnie znalezienie transakcji po ID")
    @Severity(SeverityLevel.BLOCKER)
    public void validFindingById() {
        //When
        findTransactionsPage = new FindTransactionsPage(driver);
        findTransactionsPage.getIntoFindTransactionClick();
        findTransactionsPage.waitForNextMove();
        findTransactionsPage.selectAccount();
        findTransactionsPage.enterId("14476");
        findTransactionsPage.findTransactionsByIdClick();
        findTransactionsPage.waitForNextMove();
        //Then
        Assert.assertEquals(pageElements.findTransactionsResultTitle(), findTransactionsPage.getPageTitle());
    }
    @Test(description = "TC02: poprawnie znalezienie transakcji po dacie")
    @Severity(SeverityLevel.BLOCKER)
    public void validFindingByDate() {
        //When
        findTransactionsPage = new FindTransactionsPage(driver);
        findTransactionsPage.getIntoFindTransactionClick();
        findTransactionsPage.waitForNextMove();
        findTransactionsPage.selectAccount();
        findTransactionsPage.enterDate("10-10-2023");
        findTransactionsPage.findTransactionsByDateClick();
        findTransactionsPage.waitForNextMove();
        //Then
        Assert.assertEquals(pageElements.findTransactionsResultTitle(), findTransactionsPage.getPageTitle());
    }
    @Test(description = "TC03: poprawnie znalezienie transakcji po zakresie dat")
    @Severity(SeverityLevel.BLOCKER)
    public void validFindingByDateRange() {
        //When
        findTransactionsPage = new FindTransactionsPage(driver);
        findTransactionsPage.getIntoFindTransactionClick();
        findTransactionsPage.waitForNextMove();
        findTransactionsPage.selectAccount();
        findTransactionsPage.enterDateRange("10-09-2023","10-11-2023");
        findTransactionsPage.findTransactionsByDateRangeClick();
        findTransactionsPage.waitForNextMove();
        //Then
        Assert.assertEquals(pageElements.findTransactionsResultTitle(), findTransactionsPage.getPageTitle());
    }
    @Test(description = "TC04: poprawnie znalezienie transakcji po kwocie transakcji")
    @Severity(SeverityLevel.BLOCKER)
    public void validFindingByAmount() {
        //When
        findTransactionsPage = new FindTransactionsPage(driver);
        findTransactionsPage.getIntoFindTransactionClick();
        findTransactionsPage.waitForNextMove();
        findTransactionsPage.selectAccount();
        findTransactionsPage.enterAmount("10000");
        findTransactionsPage.findTransactionsByAmountClick();
        findTransactionsPage.waitForNextMove();
        //Then
        Assert.assertEquals(pageElements.findTransactionsResultTitle(), findTransactionsPage.getPageTitle());
    }
}

