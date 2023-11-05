package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterPage extends PageObjects {
    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private final By firstNameInput = By.id("customer.firstName");
    private final By lastNameInput = By.id("customer.lastName");
    private final By addressInput = By.id("customer.address.street");
    private final By cityInput = By.id("customer.address.city");
    private final By stateInput = By.id("customer.address.state");
    private final By zipCodeInput = By.id("customer.address.zipCode");
    private final By phoneInput = By.id("customer.phoneNumber");
    private final By ssnInput = By.id("customer.ssn");
    private final By usernameInput = By.id("customer.username");
    private final By passwordInput = By.id("customer.password");
    private final By confirmPasswordInput = By.id("repeatedPassword");
    private final By registerLink = By.linkText("Register");
    private final By registerBtn = By.xpath("//input[@value='Register']");
    private final By errorMessage = By.xpath("//span[@id='customer.lastName.errors']");
    private final By secondErrorMessage = By.id("customer.username.errors");
    private final By thirdErrorMessage = By.id("repeatedPassword.errors");
    private final List<String> fields = Arrays.asList("First name","Last name","Address","City","State","Zip Code","Social Security Number","Username","Password","Password confirmation");
    private void enterFirstName(String firstName) { waitForElement(firstNameInput,5).sendKeys(firstName); }
    private void enterLastName(String lastName) { waitForElement(lastNameInput,5).sendKeys(lastName); }
    private void enterAddress(String address) { waitForElement(addressInput,5).sendKeys(address); }
    private void enterCity(String city) { waitForElement(cityInput,5).sendKeys(city); }
    private void enterState(String state) { waitForElement(stateInput,5).sendKeys(state); }
    private void enterZipCode(String zipCode) { waitForElement(zipCodeInput,5).sendKeys(zipCode); }
    private void enterPhone(String phone) { waitForElement(phoneInput,5).sendKeys(phone); }
    private void enterSsn(String ssn) { waitForElement(ssnInput,5).sendKeys(ssn); }
    private void enterUsername(String username) { waitForElement(usernameInput,5).sendKeys(username); }
    private void enterPassword(String password) { waitForElement(passwordInput,5).sendKeys(password); }
    private void enterConfirmPassword(String password) { waitForElement(confirmPasswordInput,5).sendKeys(password); }
    public void clickRegisterLink() { waitForElement(registerLink,5).click(); }
    public void clickRegisterBtn() { waitForElement(registerBtn,5).click(); }
    @Step
    public void registerUser (String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password, String confirmPassword) {
        clickRegisterLink();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterCity(city);
        enterState(state);
        enterZipCode(zipCode);
        enterPhone(phone);
        enterSsn(ssn);
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickRegisterBtn();
    }
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
