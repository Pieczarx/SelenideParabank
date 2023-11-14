package parabank.tests.ForgotLoginInfo;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class InvalidForgotLoginInfoTest extends TestMain {
    private Users noCityData;
    private Users badSsn;
    private void setUpTestUsers(){
        noCityData = new Users("firstName", "lastName","address","","state","zipCode", "phone","ssn","username","password","password");
        badSsn = new Users("firstName", "lastName","address","city","state","zipCode", "phone","badSSN","username","password","password");
    }
    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
        setUpTestUsers();
    }
    @Test(description = "TC1: Pusty formularz")
    public void nullCityTest() {
        Pages.forgotLoginInfoPage.forgotLoginInfo(noCityData);
        Pages.registerPage.possibleErrors.shouldHave(CollectionCondition.texts("City is required."));
    }
    @Test(description = "TC2: Bledny ssn")
    public void badSsnTest() {
        Pages.forgotLoginInfoPage.forgotLoginInfo(badSsn);
        Pages.registerPage.rightPanelMessage.shouldBe(Condition.visible).shouldHave(Condition.text("The customer information provided could not be found."));
    }
}