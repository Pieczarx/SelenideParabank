package parabank.tests.TransferFunds;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class InvalidTransferFundsTest extends TestMain{
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

    @Test(description = "TC02: niepoprawnie wykonany transfer środków - niepoprawna wartość w polu amount")
    public void invalidTransferFundsTest() {
        Pages.transferFundsPage.transferWithInvalidAmount();
        Pages.transferFundsPage.invalidAmountMessage();
    }

}
