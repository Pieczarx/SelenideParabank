package parabank.pages;

import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BillPayPage extends PageObjects{

    public BillPayPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private final By billPayLink = By.linkText("Bill Pay");
    private final By payeeNameField = By.name("payee.name");
    private final By payeeAddressField = By.name("payee.address.street");
    private final By payeeCityField = By.name("payee.address.city");
    private final By payeeStateField = By.name("payee.address.state");
    private final By payeeZipCodeField = By.name("payee.address.zipCode");
    private final By payeePhoneNumberField = By.name("payee.phoneNumber");
    private final By accountNumberField = By.name("payee.accountNumber");
    private final By verifyAccountNumberField = By.name("verifyAccount");
    private final By amountField = By.name("amount");
    private final By sendPaymentButton = By.xpath("//input[@value='Send Payment']");
    private final By completeTitle = By.xpath("//div[@class='']//h1[@class='title']");
    private final List<String> fields = Arrays.asList("Payee name","Address","City","State","Zip Code","Phone number","Account number","Account number");
    private void enterPayeeName(String payeeName) { waitForElement(payeeNameField,5).sendKeys(payeeName); }
    private void enterAddressStreet(String payeeAddress) { waitForElement(payeeAddressField,5).sendKeys(payeeAddress); }
    private void enterCity(String payeeCity) { waitForElement(payeeCityField,5).sendKeys(payeeCity); }
    private void enterState(String payeeState) { waitForElement(payeeStateField,5).sendKeys(payeeState); }
    private void enterZipCode(String payeeZipCode) { waitForElement(payeeZipCodeField,5).sendKeys(payeeZipCode); }
    private void enterPhoneNumber(String payeePhoneNumber) { waitForElement(payeePhoneNumberField,5).sendKeys(payeePhoneNumber); }
    private void enterAccountNumber(String accountNumber) { waitForElement(accountNumberField,5).sendKeys(accountNumber); }
    private void enterVerifyAccountNumber(String verifyAccountNumber) { waitForElement(verifyAccountNumberField,5).sendKeys(verifyAccountNumber); }
    private void enterAmount(String amount) { waitForElement(amountField,5).sendKeys(amount); }
    public void clickBillPayLink() { waitForElement(billPayLink, 5).click(); }
    public void clickBillPayBtn() { waitForElement(sendPaymentButton, 5).click(); }
    @Step
    public void sendBillPayForm(String payeeName, String street, String city, String state, String zipCode,String phoneNumber, String accountNumber, String verifyAccountNumber, String amount) {
        clickBillPayLink();
        enterPayeeName(payeeName);
        enterAddressStreet(street);
        enterCity(city);
        enterState(state);
        enterZipCode(zipCode);
        enterPhoneNumber(phoneNumber);
        enterAccountNumber(accountNumber);
        enterVerifyAccountNumber(verifyAccountNumber);
        enterAmount(amount);
        clickBillPayBtn();
    }
    @Step
    public void errorMessageShouldBe(String expectedText){
        waitForTextInElement(waitForElement(possibleError, 5), expectedText, 10);
    }
    @Step
    public void invalidAccountDataErrorShouldBe(String expectedText){
        waitForTextInElement(waitForElement(possibleError, 5), expectedText, 10);
    }
    @Step
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
        allErrors.add("The amount cannot be empty.");
        Assert.assertEquals(allErrors, received);
    }
    @Step
    public String getBillPayTitle() {
        String title = waitForElement(completeTitle, 5).getText();
        return title;
    }
}
