package parabank.tests.BillPay;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class ValidBillPayTest extends TestMain {
    private Users standardUser;
    private void setUpTestUsers(){
        standardUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
    }
    public void setup(){
        setUpTestUsers();
        String username = standardUser.getUsername();
        String password = standardUser.getPassword();
        Pages.loginPage.login(username, password);
        Pages.loginPage.loggedMessageShouldBeDisplayed();
    }
    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
        setup();
    }
    @Test(description = "TC1: Poprawnie wypelniony formularz")
    public void validForgotLoginInfoTest() {
        Pages.billPayPage.billPayForm(standardUser, "someName", "100", "100", "150");
        Pages.billPayPage.completeTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Bill Payment Complete"));
    }
}
