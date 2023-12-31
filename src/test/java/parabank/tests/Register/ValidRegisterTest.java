package parabank.tests.Register;

import parabank.Users.Users;


import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import parabank.config.TestMain;
import org.testng.annotations.Test;
import parabank.pages.Pages;

public class ValidRegisterTest extends TestMain {
    private Users standardUser;
    private void setUpTestUsers(){
        standardUser = new Users("firstName", "lastName","address","city","state","zipCode", "phone","ssn","username","password","password");
    }
    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
        setUpTestUsers();
    }
    @Test(description = "TC1: Prawidłowa rejestacja")
    public void validRegisterTest() {
        Pages.registerPage.register(standardUser);
        Pages.registerPage.pageTitle.shouldBe(Condition.visible).shouldHave(Condition.text(standardUser.getUsername()));
    }
}
