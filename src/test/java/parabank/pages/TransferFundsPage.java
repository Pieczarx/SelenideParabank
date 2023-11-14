package parabank.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import parabank.config.TestMain;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class TransferFundsPage extends TestMain {
    public SelenideElement transferFundsLink = $(By.linkText("Transfer Funds"));
    public SelenideElement amountInput = $x("input[id='amount']");
    public SelenideElement transferInput = $x("input[type='submit']");
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
       amountInput.clear();
       String amount = "100";
       $("#amountofCash").setValue(amount);
       selectAccounts();
       sleep(2000);
       transferInput.click();
        return this;
    }
}
