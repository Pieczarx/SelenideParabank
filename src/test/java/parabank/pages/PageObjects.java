package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class PageObjects {
    protected final By pageTitle = By.xpath("//h1[@class='title']");
    protected final By rightPanelMessage = By.xpath("//div[@id='rightPanel']//p[1]");
    protected final By requestLoanMessage = By.xpath("//div[@class='ng-scope']//p[1]");
    protected final By possibleError = By.xpath("//span[@class='error']");
    @Step
    public String getPageTitle() {
        String title = waitForElement(pageTitle, 10).getText();
        return title;
    }
    @Step
    public String getRightPanelMessage() {
        String message = waitForElement(rightPanelMessage, 10).getText();
        return message;
    }
    @Step
    public String getRequestLoanMessage() {
        String loanMessage = waitForElement(requestLoanMessage, 10).getText();
        return loanMessage;
    }
    protected WebDriver driver;
    public PageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void initElements() {
        PageFactory.initElements(driver, this);
    }
    public void waitForNextMove(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriverWait wait(int seconds) {
        return new WebDriverWait(driver, Duration.of(seconds, SECONDS));
    }

    protected WebElement waitForElement(By elementLocator, int seconds) {
        return wait(seconds).until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    protected List<WebElement> waitForElements(By elementsLocator, int seconds) {
        try {
            wait(seconds).until(ExpectedConditions.presenceOfElementLocated(elementsLocator));
            return driver.findElements(elementsLocator);
        }
        catch (org.openqa.selenium.TimeoutException e) {
            return List.of(); // W przypadku TimeoutException, zwróć pustą listę
        }
    }

    protected void waitForTextInElement(WebElement webElement, String expectedText, int seconds) {
        wait(seconds).until(ExpectedConditions.textToBePresentInElement(webElement, expectedText));
    }
    public void clickElementWithWait(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

}
