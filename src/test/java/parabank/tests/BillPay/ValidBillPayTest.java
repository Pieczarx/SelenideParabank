package parabank.tests.BillPay;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import parabank.pages.BillPayPage;
import parabank.pages.LoginPage;
import parabank.tests.BaseTest;

public class ValidBillPayTest extends BaseTest {
    @Test(description = "TC01 - poprawne wypełnienie formularza")
    @Severity(SeverityLevel.BLOCKER)
    public void validBillPayTest() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), standardUser.getPassword());
        //When
        billPayPage = new BillPayPage(driver);
        String accNumber = "100032";
        billPayPage.sendBillPayForm("someName", standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(), standardUser.getPhone(), accNumber, accNumber,"1000");
        //Then
        Assert.assertEquals(pageElements.getBillPayTitle(), billPayPage.getBillPayTitle());
    }
}
