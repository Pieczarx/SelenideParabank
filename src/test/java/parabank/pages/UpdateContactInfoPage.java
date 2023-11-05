package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateContactInfoPage extends PageObjects{
    public UpdateContactInfoPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private final By updateContactInfoLink = By.linkText("Update Contact Info");
    private final By firstNameField = By.name("customer.firstName");
    private final By lastNameField = By.name("customer.lastName");
    public final By addressField = By.name("customer.address.street");
    private final By cityField = By.name("customer.address.city");
    private final By stateField = By.name("customer.address.state");
    private final By zipCodeField = By.name("customer.address.zipCode");
    private final By phoneNumberField = By.name("customer.phoneNumber");
    private final By updateBtn = By.xpath("//input[@value='Update Profile']");
    private final By errorSpan = By.xpath("//span[@class='error ng-scope']");
    private final List<String> fields = Arrays.asList("First name","Last name","Address","City","State","Zip Code");
    public void clickUpdateContactInfoLink() { waitForElement(updateContactInfoLink, 5).click(); }
    public void clickUpdateBtn () { waitForElement(updateBtn, 5).click(); }
    @Step
    public void clearFieldAndSendKeys(By element, String data){
        waitForElement(element, 5).clear();
        waitForElement(element, 5).sendKeys(data);
    }
    @Step
    private void clearField(By elemenent) {
        waitForElement(elemenent, 5).clear();
    }
    @Step
    public void clearAllFields() {
        clickUpdateContactInfoLink();
        waitForNextMove();
        clearField(firstNameField);
        clearField(lastNameField);
        clearField(addressField);
        clearField(cityField);
        clearField(stateField);
        clearField(zipCodeField);
        clearField(phoneNumberField);
    }
    @Step
    public void changeAllData(String data){
        clickUpdateContactInfoLink();
        clearFieldAndSendKeys(firstNameField, data);
        clearFieldAndSendKeys(lastNameField, data);
        clearFieldAndSendKeys(addressField, data);
        clearFieldAndSendKeys(cityField, data);
        clearFieldAndSendKeys(stateField, data);
        clearFieldAndSendKeys(zipCodeField, data);
        clearFieldAndSendKeys(phoneNumberField, data);
        clickUpdateBtn();
    }
    @Step
    public List<String> getErrorMessages() {
        return waitForElements(errorSpan, 10).stream().map(WebElement::getText).collect(Collectors.toList());
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
    @Step
    public void errorMessageShouldBe(String expectedText){
        waitForTextInElement(waitForElement(errorSpan, 5), expectedText, 10);
    }
}