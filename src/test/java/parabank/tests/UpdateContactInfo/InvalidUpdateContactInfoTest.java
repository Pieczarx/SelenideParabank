package parabank.tests.UpdateContactInfo;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.LoginPage;
import parabank.pages.Page;
import parabank.pages.Pages;
import parabank.pages.UpdateContactInfoPage;

public class InvalidUpdateContactInfoTest extends TestMain {
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
    @Test(description = "TC01: pusty formularz")
    public void emptyAllFields() {
        Pages.updateContactInfoPage.clearAllFields();
        Pages.updateContactInfoPage.compareErrors(Pages.updateContactInfoPage.getErrorMessages());
    }
    @Test(description = "TC02: puste 1 pole")
    public void emptyOneField() {
        Pages.updateContactInfoPage.updateContactInfoLink.shouldBe(Condition.visible).click();
        Pages.updateContactInfoPage.clearField(Pages.updateContactInfoPage.zipCodeField);
        Pages.updateContactInfoPage.updateBtn.shouldBe(Condition.visible).click();
        Pages.updateContactInfoPage.errorSpans.shouldHave(CollectionCondition.texts("Zip Code is required."));
    }
}