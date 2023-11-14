package parabank.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import parabank.config.TestMain;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class TransferFundsPage extends Page {
    public SelenideElement transferFundsLink = $(By.linkText("Transfer Funds"));
    public SelenideElement amountInput = $(By.cssSelector("input[id='amount']"));
    public SelenideElement transferInput = $(By.cssSelector("input[type='submit']"));
    public SelenideElement errorMessage = $(By.id("amount.errors"));

    public SelenideElement firstAccount() {
        return $("#fromAccountId");
    }

    public SelenideElement secondAccount() {
        return $("#toAccountId");
    }
    public void selectAccounts() {
        SelenideElement fromAccountSelect = firstAccount();
        fromAccountSelect.selectOption(0);

        SelenideElement toAccountSelect = secondAccount();
        toAccountSelect.selectOption(0);
    }
    public TransferFundsPage transfer(){
       transferFundsLink.click();
       sleep(2000);
       amountInput.clear();
       String amount = "100";
       amountInput.setValue(amount);
       selectAccounts();
       transferInput.click();
       sleep(2000);
       return this;
    }
    public void completedTransferMessageShouldBeDisplayed() {
        Assert.assertEquals(pageTitle.shouldBe(Condition.visible).getText(), "Transfer Complete!");
    }
}
