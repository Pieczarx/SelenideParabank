package parabank.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import pages.ProductPage;
import parabank.Users.Users;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class RegisterPage extends Page {

    public SelenideElement firstNameInput = $(By.id("customer.firstName"));
    public SelenideElement lastNameInput = $(By.id("customer.lastName"));
    public SelenideElement addressInput = $(By.id("customer.address.street"));
    public SelenideElement cityInput = $(By.id("customer.address.city"));
    public SelenideElement stateInput = $(By.id("customer.address.state"));
    public SelenideElement zipCodeInput = $(By.id("customer.address.zipCode"));
    public SelenideElement phoneInput = $(By.id("customer.phoneNumber"));
    public SelenideElement ssnInput = $(By.id("customer.ssn"));
    public SelenideElement usernameInput = $(By.id("customer.username"));
    public SelenideElement passwordInput = $(By.id("customer.password"));
    public SelenideElement confirmPasswordInput = $(By.id("repeatedPassword"));
    public SelenideElement registerLink = $x("//a[text()='Register']");
    public SelenideElement registerBtn = $x("//input[@value='Register']");
    public SelenideElement lastNameErrorMessage = $x("//span[@id='customer.lastName.errors']");
    public SelenideElement existedUsernameErrorMessage = $(By.id("customer.username.errors"));
    public SelenideElement differentPasswordsErrorMessage = $(By.id("repeatedPassword.errors"));
    private List<String> fields = Arrays.asList("First name", "Last name", "Address", "City", "State", "Zip Code", "Social Security Number", "Username", "Password", "Password confirmation");
    public RegisterPage register(Users user) {
        registerLink.shouldBe(Condition.enabled).click();
        firstNameInput.shouldBe(Condition.enabled).setValue(user.getFirstName());
        lastNameInput.shouldBe(Condition.enabled).setValue(user.getLastName());
        addressInput.shouldBe(Condition.enabled).setValue(user.getAddress());
        cityInput.shouldBe(Condition.enabled).setValue(user.getCity());
        stateInput.shouldBe(Condition.enabled).setValue(user.getState());
        zipCodeInput.shouldBe(Condition.enabled).setValue(user.getZipCode());
        phoneInput.shouldBe(Condition.enabled).setValue(user.getPhone());
        ssnInput.shouldBe(Condition.enabled).setValue(user.getSsn());
        usernameInput.shouldBe(Condition.enabled).setValue(user.getUsername());
        passwordInput.shouldBe(Condition.enabled).setValue(user.getPassword());
        confirmPasswordInput.shouldBe(Condition.enabled).setValue(user.getConfirmPassword());
        registerBtn.shouldBe(Condition.enabled).click();
        return this;
    }
    public RegisterPage clickBtn() {
        registerBtn.shouldBe(Condition.enabled).click();
        return new RegisterPage();
    }
    public void lastNameErrorMessageShouldBeDisplayed() {
        Assert.assertEquals(lastNameErrorMessage.shouldBe(Condition.visible).getText(), "Last name is required.");
    }
    public void existedUsernameErrorMessageShouldBeDisplayed() {
        Assert.assertEquals(existedUsernameErrorMessage.shouldBe(Condition.visible).getText(), "This username already exists.");
    }
    public void differentPasswordsErrorMessageShouldBeDisplayed() {
        Assert.assertEquals(differentPasswordsErrorMessage.shouldBe(Condition.visible).getText(), "Passwords did not match.");
    }
    public List<String> getErrorMessages() {
        return possibleErrors.texts();
    }
    public void compareErrors (List<String> received) {
        List<String> allErrors = new ArrayList<>();
        for (String input : fields){
            String element = input + " is required.";
            allErrors.add(element);
        }
        Assert.assertEquals(allErrors, received);
    }
}