package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;

public class ForgotLoginInfoPage extends PageObjects{
    public ForgotLoginInfoPage (WebDriver driver) {
        super(driver);
        initElements();
    }
    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");
    private final By addressInput = By.id("address.street");
    private final By cityInput = By.id("address.city");
    private final By stateInput = By.id("address.state");
    private final By zipCodeInput = By.id("address.zipCode");
    private final By ssnInput = By.id("ssn");
    private final By forgotLoginInfoLink = By.linkText("Forgot login info?");
    private final By findMyLoginInfoBtn = By.xpath("//input[@value='Find My Login Info']");
    private final By emptyCityInputError = By.id("address.city.errors");
    private void enterFirstName(String firstName) { waitForElement(firstNameInput,5).sendKeys(firstName); }
    private void enterLastName(String lastName) { waitForElement(lastNameInput,5).sendKeys(lastName); }
    private void enterAddress(String address) { waitForElement(addressInput,5).sendKeys(address); }
    private void enterCity(String city) { waitForElement(cityInput,5).sendKeys(city); }
    private void enterState(String state) { waitForElement(stateInput,5).sendKeys(state); }
    private void enterZipCode(String zipCode) { waitForElement(zipCodeInput,5).sendKeys(zipCode); }
    private void enterSsn(String ssn) { waitForElement(ssnInput,5).sendKeys(ssn); }
    private void clickForgotLoginInfoLink() { waitForElement(forgotLoginInfoLink,5).click(); }
    private void clickForgotLoginInfoBtn() { waitForElement(findMyLoginInfoBtn,5).click(); }
    @Step
    public void forgotLoginInfo (String firstName, String lastName, String address, String city, String state, String zipCode, String ssn) {
        clickForgotLoginInfoLink();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterCity(city);
        enterState(state);
        enterZipCode(zipCode);
        enterSsn(ssn);
        clickForgotLoginInfoBtn();
    }
    @Step
    public PageObjects forgotLoginInfoValidData (String firstName, String lastName, String address, String city, String state, String zipCode, String ssn) {
        forgotLoginInfo(firstName,lastName,address,city,state,zipCode,ssn);
        return new PageObjects(driver);
    }
    @Step
    public void errorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(rightPanelMessage,5), expectedText, 10);
    }
    @Step
    public void inputCityErrorShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(emptyCityInputError,5), expectedText, 10);
    }
}