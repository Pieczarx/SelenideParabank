package parabank.tests.FindTransactions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class InvalidFindingTransactionsTest extends TestMain{
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

    @Test(description = "TC05: Nieprawidłowa wartość w polu szukania transakcji")
    public void invalidFindingTransaction() {
        Pages.findTransactionsPage.findTransactionByInvalidID();
        Pages.findTransactionsPage.invalidIdMessage();
    }


}
