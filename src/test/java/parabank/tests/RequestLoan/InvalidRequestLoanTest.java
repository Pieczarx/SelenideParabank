package parabank.tests.RequestLoan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class InvalidRequestLoanTest extends TestMain {
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
    @Test(description = "TC02: Niepoprawnie udzielona pożyczka - niewystarczające środki na zaliczkę")
    public void invalidPaymentValueTest() {
        Pages.requestLoanPage.inValidPaymentValueRequest();
        Pages.requestLoanPage.notEnoughPaymentMoneyMessage();
    }
    @Test(description = "TC03: Niepoprawnie udzielona pożyczka - niepoprawna wartość")
    public void invalidValeTest() {
        Pages.requestLoanPage.invalidValueRequest();
        Pages.requestLoanPage.invalidValueMessage();
    }
}
