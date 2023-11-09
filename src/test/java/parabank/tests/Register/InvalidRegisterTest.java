package parabank.tests.Register;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;
import parabank.pages.RegisterPage;

public class InvalidRegisterTest extends TestMain {
    /*
    private Users standardUser;
    private Users userWithoutOneValue;
    private void setUpTestUsers(){
        standardUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
        emptyUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
    }

    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
        setUpTestUsers();
    }
    @Test(description = "TC02 - pusty formularz")
    public void registerEmptyFormTest() {
        Pages.registerPage.clickBtn();
        //Then

        Pages.registerPage.compareErrors(registerPage.getErrorMessages());

    }
    @Test(description = "TC02: brak podanej jednej wartości")
    public void registerWithEmptyLastNameInput () {
        //When
        Pages.registerPage.register(userWithoutOneValue);
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

     */
}

