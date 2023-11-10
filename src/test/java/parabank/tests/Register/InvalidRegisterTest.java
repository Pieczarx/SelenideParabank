package parabank.tests.Register;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Page;
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
    private Users emptyLastName;
    private Users standardUser;
    private Users noData;
    private Users differentPasswords;
    private void setUpTestUsers(){
        standardUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
        noData = new Users("", "", "", "","" ,"","","","","","");
        emptyLastName = new Users("firstName", "","address","city","state","zipCode", "phone","ssn","username","password","password");
        differentPasswords = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username1","password","differentPassword");
    }
    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
        setUpTestUsers();
    }
    @Test(description = "TC1: Pusty formularz")
    public void emptyFormTest() {
        Pages.registerPage.register(noData);
        //Pages.registerPage.pageTitle.shouldBe(Condition.visible).shouldHave(Condition.text(noData.getUsername()));
        Pages.registerPage.compareErrors(Pages.registerPage.getErrorMessages());
    }

    @Test(description = "TC2: brak podanej jednej wartości")
    public void registerWithEmptyLastNameInputTest() {
        Pages.registerPage.register(emptyLastName);
        Pages.registerPage.lastNameErrorMessageShouldBeDisplayed();
    }
    @Test(description = "TC3: istniejacy username")
    public void existedUsernameTest() {
        Pages.registerPage.register(standardUser);
        Pages.registerPage.existedUsernameErrorMessageShouldBeDisplayed();
    }
    @Test(description = "TC04: rozne hasla")
    public void registerWithDifferentPasswordsTest() {
        Pages.registerPage.register(differentPasswords);
        Pages.registerPage.differentPasswordsErrorMessageShouldBeDisplayed();
    }
}