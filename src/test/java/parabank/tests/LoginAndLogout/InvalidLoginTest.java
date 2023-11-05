package parabank.tests.LoginAndLogout;

import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank.pages.LoginPage;
import parabank.tests.BaseTest;
public class InvalidLoginTest extends BaseTest {
    @Test(description = "TC02: Nieprawidłowe hasło ")
    public void loginWithIncorrectPasswordInput() {
        //When
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), "wrongPassword");

        //Then
        loginPage.secondErrorMessageShouldBe();
    }
    @Test(description = "TC03: Nieprawidłowy login ")
    public void loginWithIncorrectLoginInput() {
        //When
        loginPage = new LoginPage(driver);
        loginPage.loginUser("wrongLogin", standardUser.getPassword());

        //Then
        loginPage.secondErrorMessageShouldBe();
    }

    @Test(description = "TC04: Brak nazwy użytkownika ")
    public void loginWithoutUsernameShouldDisplayError() {
        //When
        loginPage = new LoginPage(driver);
        loginPage.loginUser("", standardUser.getPassword());

        //Then
        loginPage.errorMessageShouldBe();

    }
    @Test(description = "TC05: Brak hasła")
    public void loginWithoutPasswordShouldDisplayError() {
        //When
        loginPage = new LoginPage(driver);
        loginPage.loginUser(standardUser.getUsername(), "");

        //Then
        loginPage.errorMessageShouldBe();

    }
}
