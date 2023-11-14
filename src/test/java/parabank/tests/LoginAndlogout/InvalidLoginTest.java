package parabank.tests.LoginAndlogout;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class InvalidLoginTest extends TestMain {
    private Users standardUser;
    private Users incorrectPasswordUser;

    private void setUpTestUsers() {
        standardUser = new Users("firstName", "lastName", "address", "city", "state", "zipCode", "phone", "ssn", "username", "password", "password");}

    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {
        super.beforeClass();
    }

    @Test(description = "TC03: Nieprawidłowe hasło")
    public void loginWithIncorrectPassword() {
        setUpTestUsers();
        String username = standardUser.getUsername();
        String password = "haslo";
        Pages.loginPage.login(username, password);
        Pages.loginPage.incorrectPasswordMessage();

    }
    @Test(description = "TC04: Nieprawidłowy login")
    public void loginWithIncorrectLogin() {
        setUpTestUsers();
        String username = "login";
        String password = standardUser.getPassword();
        Pages.loginPage.login(username, password);
        Pages.loginPage.incorrectPasswordMessage();

    }
    @Test(description = "TC05: Brak nazwy użytkownika")
    public void loginWithEmptyLogin() {
        setUpTestUsers();
        String username = "";
        String password = standardUser.getPassword();
        Pages.loginPage.login(username, password);
        Pages.loginPage.emptyFieldMessage();

    }
    @Test(description = "TC05: Brak hasła")
    public void loginWithEmptyPassword() {
        setUpTestUsers();
        String username = standardUser.getUsername();
        String password = "";
        Pages.loginPage.login(username, password);
        Pages.loginPage.emptyFieldMessage();

    }
}


