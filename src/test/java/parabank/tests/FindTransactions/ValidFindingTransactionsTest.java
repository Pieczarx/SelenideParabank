package parabank.tests.FindTransactions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class ValidFindingTransactionsTest extends TestMain{
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

    @Test(description = "TC01: poprawnie znalezienie transakcji po ID")
    public void validFindingById() {
        Pages.findTransactionsPage.findTransactionByID();
        Pages.findTransactionsPage.foundTransactionMessage();
    }
    @Test(description = "TC02: poprawnie znalezienie transakcji po dacie")
    public void validFindingByDate() {
        Pages.findTransactionsPage.findTransactionByDate();
        Pages.findTransactionsPage.foundTransactionMessage();
    }
    @Test(description = "TC03: poprawnie znalezienie transakcji po zakresie dat")
    public void validFindingByDateRange() {
        Pages.findTransactionsPage.findTransactionByDateRange();
        Pages.findTransactionsPage.foundTransactionMessage();
    }
    @Test(description = "TC04: poprawnie znalezienie transakcji po kwocie")
    public void validFindingByAmount() {
        Pages.findTransactionsPage.findTransactionByAmount();
        Pages.findTransactionsPage.foundTransactionMessage();
    }


}
