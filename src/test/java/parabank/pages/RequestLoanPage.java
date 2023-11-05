package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPage extends PageObjects {
    public RequestLoanPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private final By requestLoanLink = By.linkText("Request Loan");
    private final By loanAmountInput = By.xpath("//input[@id='amount']");
    private final By downPaymentInput = By.xpath("//input[@id='downPayment']");


    private WebElement accountInput(){
        return driver.findElement(By.id("fromAccountId"));
    }
    private final By requestInput = By.xpath("//input[@type='submit']");

   private final By errorMessage = By.xpath("//p[@class='error']");
    private final By secondErrorMessage = By.xpath("//p[@class='error ng-scope']");

    private void requestLoanClick() { waitForElement(requestLoanLink,5).click(); }
    private void submitTransfer(){waitForElement(requestInput,5).click();}
    @Step
    public void getIntoRequestLink() {
        requestLoanClick();
    }
    @Step
    public void enterAmount(String amount) {
        WebElement amountofCash = driver.findElement(loanAmountInput);
        amountofCash.clear();
        amountofCash.sendKeys(amount);
    }
    @Step
    public void enterDownPayment(String downPayment) {
        WebElement idValue = driver.findElement(downPaymentInput);
        idValue.click();
        idValue.clear();
        idValue.sendKeys(downPayment);
    }
    @Step
    public void selectAccount() {
        WebElement fromAccountSelect = accountInput();
        Select newSelect = new Select(fromAccountSelect);
        newSelect.selectByIndex(1);
    }
    @Step
    public void applyNow(){
    submitTransfer();
    }

    @Step
    public void errorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(errorMessage,5), expectedText, 10);
    }
    @Step
    public void secondErrorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(secondErrorMessage,5), expectedText, 10);
    }

}
