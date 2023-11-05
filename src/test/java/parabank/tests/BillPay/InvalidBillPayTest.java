package parabank.tests.BillPay;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.pages.BillPayPage;
import parabank.pages.LoginPage;
import parabank.tests.BaseTest;

public class InvalidBillPayTest extends BaseTest {
    @BeforeClass
    public void setup() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
    }
    @Test(description = "TC01 - pusty formularz")
    @Severity(SeverityLevel.BLOCKER)
    public void emptyFormTest() {
        billPayPage = new BillPayPage(driver);
        billPayPage.clickBillPayLink();
        billPayPage.clickBillPayBtn();
        //Then
        billPayPage.compareErrors(billPayPage.getErrorMessages());
    }
    @Test(description = "TC02 - pusta wartosc Zip Code")
    @Severity(SeverityLevel.BLOCKER)
    public void emptyOneFieldTest() {
        billPayPage = new BillPayPage(driver);
        String accNumber = "100032";
        billPayPage.sendBillPayForm("someName", standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), "", standardUser.getPhone(), accNumber, accNumber,"1000");
        //Then
        billPayPage.errorMessageShouldBe(pageElements.getEmptyFieldError("Zip Code"));
    }
    @Test(description = "TC03 - wartosc account nie jest liczba")
    @Severity(SeverityLevel.BLOCKER)
    public void invalidAccountData() {
        billPayPage = new BillPayPage(driver);
        String accNumber = "a";
        billPayPage.sendBillPayForm("someName", standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(), standardUser.getPhone(), accNumber, accNumber,"1000");
        //Then
        billPayPage.errorMessageShouldBe("Please enter a valid number.");
    }
    @Test(description = "TC04 - rozne wartosci Account i VerifyAccount")
    @Severity(SeverityLevel.BLOCKER)
    public void differentAccountAndVerifyAccountData() {
        billPayPage = new BillPayPage(driver);
        billPayPage.sendBillPayForm("someName", standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(), standardUser.getPhone(), "1", "2","1000");
        //Then
        billPayPage.errorMessageShouldBe("The account numbers do not match.");
    }
}
