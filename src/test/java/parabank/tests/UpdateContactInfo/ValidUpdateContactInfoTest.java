package parabank.tests.UpdateContactInfo;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Pages;

public class ValidUpdateContactInfoTest extends TestMain {
    private Users standardUser;
    private Users newUser;
    private void setUpTestUsers(){
        standardUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
        newUser = new Users("changedFirstName", "changedLastName","changedAddress","changedCity","changedState","changedZipCode", "changedPhone","","","","");
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
    @Test(description = "TC1: poprawna aktualizacja informacji")
    public void validUpdateContactInfoTest() {
        Pages.updateContactInfoPage.updateContactInfoPage(newUser);
        Pages.updateContactInfoPage.pageTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Profile Updated"));
    }
}