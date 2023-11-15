package parabank.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.sleep;

public class FindTransactionsPage extends Page {
    public SelenideElement findTransactionsLink = $(By.linkText("Find Transactions"));
    public SelenideElement transactionByID = $(By.cssSelector("input[id='criteria.transactionId']"));
    public SelenideElement transactionByDate = $(By.cssSelector("input[id='criteria.onDate']"));
    public SelenideElement transactionByRangeDateFrom = $(By.cssSelector("input[id='criteria.fromDate']"));
    public SelenideElement transactionByRangeDateTo = $(By.cssSelector("input[id='criteria.toDate']"));
    public SelenideElement transactionByAmount = $(By.cssSelector("input[id='criteria.amount']"));
    public SelenideElement transferInput = $(By.cssSelector("input[type='submit']"));
    public SelenideElement transactionByIdInput = $(byXpath("//button[contains(@ng-click, \"criteria.searchType = 'ID'\")]"));
    public SelenideElement transactionByDateInput = $(byXpath("//button[contains(@ng-click, \"criteria.searchType = 'DATE'\")]"));
    public SelenideElement transactionByDateRangeInput = $(byXpath("//button[contains(@ng-click, \"criteria.searchType = 'DATE_RANGE'\")]"));
    public SelenideElement transactionByAmountInput = $(byXpath("//button[contains(@ng-click, \"criteria.searchType = 'AMOUNT'\")]"));
    public SelenideElement accountInput() {
        return $("#accountId");
    }
    public void selectAccount() {
        SelenideElement accountSelect = accountInput();
        accountSelect.selectOption(0);
    }

    public void findTransactionByID()
    {
        findTransactionsLink.click();
        sleep(2000);
        selectAccount();
        transactionByID.clear();
        String id = "15475";
        transactionByID.setValue(id);
        transactionByIdInput.click();
        sleep(2000);
    }
    public void findTransactionByDate()
    {
        findTransactionsLink.click();
        sleep(2000);
        selectAccount();
        transactionByDate.clear();
        String date = "11-15-2023";
        transactionByDate.setValue(date);
        transactionByDateInput.click();
        sleep(2000);
    }
    public void findTransactionByDateRange()
    {
        findTransactionsLink.click();
        sleep(2000);
        selectAccount();
        transactionByRangeDateFrom.clear();
        String date = "11-15-2023";
        transactionByRangeDateFrom.setValue(date);
        transactionByRangeDateTo.clear();
        transactionByRangeDateTo.setValue(date);
        transactionByDateRangeInput.click();
        sleep(2000);
    }
    public void findTransactionByAmount()
    {
        findTransactionsLink.click();
        sleep(2000);
        selectAccount();
        transactionByAmount.clear();
        String amount = "100";
        transactionByAmount.setValue(amount);
        transactionByAmountInput.click();
        sleep(2000);
    }
    public void findTransactionByInvalidID()
    {
        findTransactionsLink.click();
        sleep(2000);
        selectAccount();
        transactionByID.clear();
        String id = "asd";
        transactionByID.setValue(id);
        transactionByIdInput.click();
        sleep(2000);
    }
    public void foundTransactionMessage() {
        Assert.assertEquals(pageTitle.shouldBe(Condition.visible).getText(), "Transaction Results");
    }
    public void invalidIdMessage() {
        Assert.assertEquals(error.shouldBe(Condition.visible).getText(), "An internal error has occurred and has been logged.");
    }




}
