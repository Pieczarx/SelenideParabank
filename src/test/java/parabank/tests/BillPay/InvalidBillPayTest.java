package parabank.tests.BillPay;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.Users.Users;
import parabank.config.TestMain;
import parabank.pages.Page;
import parabank.pages.Pages;

public class InvalidBillPayTest extends TestMain {
    private Users standardUser;
    private Users noData;
    private Users emptyZipCode;
    private void setUpTestUsers(){
        standardUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
        emptyZipCode = new Users("firstName", "lastName","address","city","state","", "phone","ssn","username","password","password");
        noData = new Users("", "", "", "","" ,"","","","","","");
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
    @Test(description = "TC1: pusty formularz")
    public void emptyFormTest() {
        Pages.billPayPage.billPayForm(noData, "", "" ,"", "");
        Pages.billPayPage.compareErrors(Pages.billPayPage.getErrorMessages());
    }
    @Test(description = "TC02 - pusta wartosc Zip Code")
    public void emptyZipCodeFieldTest() {
        Pages.billPayPage.billPayForm(emptyZipCode, "someName", "100" ,"100", "150");
        Pages.billPayPage.possibleErrors.shouldHave(CollectionCondition.texts("Zip Code is required."));
    }
    @Test(description = "TC03 - wartosc account nie jest liczba")
    public void invalidAccountDataTest() {
        Pages.billPayPage.billPayForm(standardUser, "someName", "test" ,"test", "150");
        Pages.billPayPage.possibleErrors.get(0).shouldHave(Condition.text("Please enter a valid number."));
    }    @Test(description = "TC04 - rozne wartosci Account i VerifyAccount")
    public void differentAccountAndVerifyAccountDataTest() {
        Pages.billPayPage.billPayForm(standardUser, "someName", "100" ,"200", "150");
        Pages.billPayPage.possibleErrors.shouldHave(CollectionCondition.texts(" The account numbers do not match."));
    }
}
