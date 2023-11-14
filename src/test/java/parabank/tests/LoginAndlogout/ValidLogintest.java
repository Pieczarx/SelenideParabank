package parabank.tests.LoginAndlogout;

import parabank.Users.Users;


import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import parabank.config.TestMain;
import org.testng.annotations.Test;
import parabank.pages.LoginPage;
import parabank.pages.Pages;
public class ValidLogintest extends TestMain {
    private Users standardUser;
    private void setUpTestUsers(){
    standardUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
    }
    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
    }

    @Test(description = "TC01: Prawidłowe logowanie")
    public void validLoginTest() {
        setUpTestUsers();
        String username = standardUser.getUsername();
        String password = standardUser.getPassword();
        Pages.loginPage.login(username, password);
        Pages.loginPage.loggedMessageShouldBeDisplayed();

    }
    @Test(description = "TC02: poprawne wylogowanie", dependsOnMethods = "validLoginTest")
    public void validLogout() {
        Pages.loginPage.logOutUser();
    }
}
