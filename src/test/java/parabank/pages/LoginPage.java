package parabank.pages;

import org.testng.Assert;
import pages.ProductPage;
import parabank.Users.Users;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class LoginPage extends Page {
    public SelenideElement loginBtn = $(By.cssSelector("input[value='Log In']"));
    public SelenideElement logoutLink = $(By.linkText("Log Out"));
    public SelenideElement usernameInput = $(By.name("username"));
    public SelenideElement passwordInput = $(By.name("password"));
    public SelenideElement errorMessage = $x("p[class='error']");

    public LoginPage login(String username, String password){
        usernameInput.shouldBe(enabled).setValue(username);
        passwordInput.shouldBe(enabled).setValue(password);
        loginBtn.click();
        return this;
    }
    public LoginPage logOutUser () {
        logoutLink.shouldBe(enabled).click();
        return this;
    }
    public void loggedMessageShouldBeDisplayed() {
        Assert.assertEquals(pageTitle.shouldBe(Condition.visible).getText(), "Accounts Overview");
    }
    public void incorrectPasswordMessage() {
        Assert.assertEquals(error.shouldBe(Condition.visible).getText(), "The username and password could not be verified.");
    }
    public void emptyFieldMessage() {
        Assert.assertEquals(error.shouldBe(Condition.visible).getText(), "Please enter a username and password.");
    }

}
