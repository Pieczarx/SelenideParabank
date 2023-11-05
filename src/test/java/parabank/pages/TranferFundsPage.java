package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import parabank.tests.BaseTest;

public class TranferFundsPage extends PageObjects {
    public TranferFundsPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private final By transferFundsLink = By.linkText("Transfer Funds");
    private final By amountInput = By.xpath("//input[@id='amount']");
    private WebElement firstAccount(){
        return driver.findElement(By.id("fromAccountId"));
    }
    private WebElement secondAccount(){
        return driver.findElement(By.id("toAccountId"));
    }
private final By transferInput = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.id("amount.errors");

    private void transferFundsClick() { waitForElement(transferFundsLink,5).click(); }
    private void submitTransfer(){waitForElement(transferInput,5).click();}


    @Step
    public void getIntoTransferFunds() {
        transferFundsClick();
    }
    @Step
    public void enterAmount(String amount) {
        WebElement amountofCash = driver.findElement(amountInput);
        amountofCash.clear();
        amountofCash.sendKeys(amount);
    }
    @Step
    public void  selectAccounts() {
        WebElement fromAccountSelect = firstAccount();
        Select firstSelect = new Select(fromAccountSelect);
        firstSelect.selectByIndex(0);
        WebElement toAccountSelect = secondAccount();
        Select secondSelect = new Select(toAccountSelect);
        secondSelect.selectByIndex(0);
    }
public void sendMoney(){
        submitTransfer();
}
    @Step
    public void errorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(errorMessage,5), expectedText, 10);
    }


}

