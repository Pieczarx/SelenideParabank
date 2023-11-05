package parabank.pages;

import pages.ProductPage;
import parabank.Users.Users;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import parabank.model.User;

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
    public SelenideElement errorMessage = $x("//span[@id='customer.lastName.errors']");
    public SelenideElement secondErrorMessage = $(By.id("customer.username.errors"));
    public SelenideElement thirdErrorMessage = $(By.id("repeatedPassword.errors"));
    private List<String> fields = Arrays.asList("First name", "Last name", "Address", "City", "State", "Zip Code", "Social Security Number", "Username", "Password", "Password confirmation");


    public ProductPage register(Users user) {
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
        return new ProductPage();
    }

}
/*
    @Step
    public PageObjects registerAsValidUser (String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password, String confirmPassword) {
        registerUser(firstName,lastName,address,city,state,zipCode,phone,ssn,username,password,confirmPassword);
        return new PageObjects(driver);
    }
    @Step
    public void errorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(errorMessage,5),expectedText,10);
    }
    @Step
    public void secondErrorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(secondErrorMessage,5),expectedText,10);
    }
    @Step
    public void thirdErrorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(thirdErrorMessage,5),expectedText,10);
    }
    public List<String> getErrorMessages() {
        return waitForElements(possibleError, 10).stream().map(WebElement::getText).collect(Collectors.toList());
    }
    @Step
    public void compareErrors (List<String> received) {
        List<String> allErrors = new ArrayList<>();
        for (String input : fields){
            String element = input + " is required.";
            allErrors.add(element);
        }
        Assert.assertEquals(allErrors, received);
    }
}
*/