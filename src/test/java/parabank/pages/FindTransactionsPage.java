package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsPage extends PageObjects {
    public FindTransactionsPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private final By findTransactionsLink = By.linkText("Find Transactions");
    private final By transactionById = By.xpath("//input[@id='criteria.transactionId']");
    private final By transactionByDate = By.xpath("//input[@id='criteria.onDate']");
    private final By transactionByRangeDateFrom = By.xpath("//input[@id='criteria.fromDate']");
    private final By transactionByRangeDateTo = By.xpath("//input[@id='criteria.toDate']");
    private final By transactionByAmount = By.xpath("//input[@id='criteria.amount']");
    private WebElement accountInput(){
        return driver.findElement(By.id("accountId"));
    }
    private final By transferInput = By.xpath("//input[@type='submit']");
    private final By transactionByIdInput = By.xpath("//button[contains(@ng-click, \"criteria.searchType = 'ID'\")]");
   private final By transactionByDateInput = By.xpath("//button[contains(@ng-click, \"criteria.searchType = 'DATE'\")]");
   private final By transactionByDateRangeInput = By.xpath("//button[contains(@ng-click, \"criteria.searchType = 'DATE_RANGE'\")]");
  private final By transactionByAmountInput = By.xpath("//button[contains(@ng-click, \"criteria.searchType = 'AMOUNT'\")]");
   private final By errorMessage = By.xpath("//p[@class='error']");

    private void findTransactionClick() { waitForElement(findTransactionsLink,5).click(); }
    private void submitTransfer(){waitForElement(transferInput,5).click();}
    @Step
    public void findTransactionsByIdClick() {waitForElement(transactionByIdInput, 5).click();}
    @Step
    public void findTransactionsByDateClick() {waitForElement(transactionByDateInput, 5).click();}
    @Step
    public void findTransactionsByDateRangeClick() {waitForElement(transactionByDateRangeInput, 5).click();}
    @Step
    public void findTransactionsByAmountClick() {waitForElement(transactionByAmountInput,5).click();}
    @Step
    public void getIntoFindTransactionClick() {
        findTransactionClick();
    }
    @Step
    public void enterAmount(String amount) {
        WebElement amountofCash = driver.findElement(transactionByAmount);
        amountofCash.clear();
        amountofCash.sendKeys(amount);
    }
    @Step
    public void enterId(String id) {
        WebElement idValue = driver.findElement(transactionById);
        idValue.click();
        idValue.clear();
        idValue.sendKeys(id);
    }
    @Step
    public void enterDate(String date) {
        WebElement dateValue = driver.findElement(transactionByDate);
        dateValue.clear();
        dateValue.sendKeys(date);
    }
    @Step
    public void enterDateRange(String dateFrom, String dateTo) {
        WebElement dateRangeFrom = driver.findElement(transactionByRangeDateFrom);
        dateRangeFrom.clear();
        dateRangeFrom.sendKeys(dateFrom);
        WebElement dateRangeTo = driver.findElement(transactionByRangeDateTo);
        dateRangeTo.clear();
        dateRangeTo.sendKeys(dateTo);
    }
    @Step
    public void selectAccount() {
        WebElement fromAccountSelect = accountInput();
        Select newSelect = new Select(fromAccountSelect);
        newSelect.selectByIndex(0);
    }
    public void sendMoney(){
        submitTransfer();
    }
    @Step
    public void errorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(errorMessage,5), expectedText, 10);
    }


}
