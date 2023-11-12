package parabank.tests.ForgotLoginInfo;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class ValidForgotLoginInfoTest extends TestMain {
    private Users standardUser;
    private void setUpTestUsers(){
        standardUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
    }
    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
        setUpTestUsers();
    }
    @Test(description = "TC1: Poprawnie wypelniony formularz")
    public void validForgotLoginInfoTest() {
        Pages.forgotLoginInfoPage.forgotLoginInfo(standardUser);
        Pages.registerPage.rightPanelMessage.shouldBe(Condition.visible).shouldHave(Condition.text("Your login information was located successfully. You are now logged in."));
    }
}
