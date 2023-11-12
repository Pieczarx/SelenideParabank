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