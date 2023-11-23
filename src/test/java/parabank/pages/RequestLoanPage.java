package parabank.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class RequestLoanPage extends Page {
    public SelenideElement requestLoanLink = $(By.linkText("Request Loan"));
    public SelenideElement loadAmountInput = $x("//input[@id='amount']");
    public SelenideElement downPaymentInput = $x("//input[@id='downPayment']");
    public SelenideElement requestInput = $x("//input[@type='submit']");
    public SelenideElement secondErrorMessage = $(By.cssSelector("p[class='error ng-scope']"));
    public SelenideElement requestLoanMessage = $("div.ng-scope p", 0);
    public SelenideElement accountInput() {
        return $(By.id("fromAccountId"));
    }
    public void selectAccount() {
        SelenideElement accountSelect = accountInput();
        accountSelect.selectOption(0);
    }
    public void validRequest()
    {
        requestLoanLink.click();
        sleep(2000);
        loadAmountInput.clear();
        String amount = "100";
        loadAmountInput.setValue(amount);
        downPaymentInput.clear();
        String payment = "10";
        downPaymentInput.setValue(payment);
        selectAccount();
        requestInput.click();
        sleep(2000);
    }
    public void inValidPaymentValueRequest()
    {
        requestLoanLink.click();
        sleep(2000);
        loadAmountInput.clear();
        String amount = "1000000000";
        loadAmountInput.setValue(amount);
        downPaymentInput.clear();
        String payment = "10000000";
        downPaymentInput.setValue(payment);
        selectAccount();
        requestInput.click();
        sleep(2000);
    }
    public void invalidValueRequest()
    {
        requestLoanLink.click();
        sleep(2000);
        loadAmountInput.clear();
        String amount = "aa";
        loadAmountInput.setValue(amount);
        downPaymentInput.clear();
        String payment = "aa";
        downPaymentInput.setValue(payment);
        selectAccount();
        requestInput.click();
        sleep(2000);
    }
    public void successfulLoanMessage() {
        Assert.assertEquals(requestLoanMessage.shouldBe(Condition.visible).getText(), "Congratulations, your loan has been approved.");
    }
    public void invalidValueMessage() {
        Assert.assertEquals(error.shouldBe(Condition.visible).getText(), "An internal error has occurred and has been logged.");
    }
    public void notEnoughPaymentMoneyMessage() {
        Assert.assertEquals(secondErrorMessage.shouldBe(Condition.visible).getText(), "You do not have sufficient funds for the given down payment.");
    }
}
