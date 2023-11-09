package parabank.pages;

import org.testng.Assert;
import pages.ProductPage;
import parabank.Users.Users;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class LoginPage extends Page {
    public SelenideElement loginBtn = $(By.cssSelector("input[value='Log In']"));
    public SelenideElement logoutLink = $(By.linkText("Log Out"));
    public SelenideElement usernameInput = $(By.name("username"));
    public SelenideElement passwordInput = $(By.name("password"));
    public SelenideElement errorMessage = $x("p[class='error']");

    public LoginPage login(String username, String password){
        usernameInput.shouldBe(Condition.enabled).setValue(username);
        passwordInput.shouldBe(Condition.enabled).setValue(password);
        loginBtn.click();
        return new LoginPage();
    }
    public void loggedMessageShouldBeDisplayed() {
        Assert.assertEquals(pageTitle.shouldBe(Condition.visible).getText(), "Accounts Overview");
    }
}
