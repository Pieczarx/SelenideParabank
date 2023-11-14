package parabank.tests.OpenNewAccount;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.LoginPage;
import parabank.pages.Pages;

public class ValidOpenNewAccountTest extends TestMain {
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


    @Test(description = "TC01: Prawidłowe otwarcie nowego konta")
    public void validOpenNewAccountTest() {
        Pages.openNewAccountPage.openAccount();
        Pages.openNewAccountPage.openedAccountMessageShouldBeDisplayed();

    }
}
