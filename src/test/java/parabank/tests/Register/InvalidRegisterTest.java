package parabank.tests.Register;

import org.testng.annotations.Test;
import parabank.pages.RegisterPage;
/*
public class InvalidRegisterTest extends BaseTest {
    @Test(description = "TC01 - pusty formularz")
    public void registerEmptyFormTest() {
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterLink();
        registerPage.clickRegisterBtn();
        //Then
        registerPage.compareErrors(registerPage.getErrorMessages());
    }
    @Test(description = "TC02: brak podanej jednej wartości")
    public void registerWithEmptyLastNameInput () {
        //When
        registerPage = new RegisterPage(driver);
        registerPage.registerUser(standardUser.getFirstName(), "", standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(), standardUser.getPhone(), standardUser.getSsn(), standardUser.getUsername(), standardUser.getPassword(), standardUser.getPassword());

        //Then
        registerPage.errorMessageShouldBe("Last name is required.");
    }
    @Test(description = "TC03: istniejacy username")
    public void registerWithExistingUsernameInput () {
        //When
        registerPage = new RegisterPage(driver);
        registerPage.registerUser(standardUser.getFirstName(), standardUser.getLastName(), standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(), standardUser.getPhone(), standardUser.getSsn(), standardUser.getUsername(), standardUser.getPassword(), standardUser.getPassword());
        //Then
        registerPage.secondErrorMessageShouldBe("This username already exists.");
    }
    @Test(description = "TC04: rozne hasla")
    public void registerWithDifferentPasswords () {
        //When
        registerPage = new RegisterPage(driver);
        registerPage.registerUser(standardUser.getFirstName(), standardUser.getLastName(), standardUser.getAddress(), standardUser.getCity(), standardUser.getState(), standardUser.getZipCode(), standardUser.getPhone(), standardUser.getSsn(), standardUser.getUsername(), standardUser.getPassword(), "differentPassword");
        //Then
        registerPage.thirdErrorMessageShouldBe("Passwords did not match.");
    }
}
*/
