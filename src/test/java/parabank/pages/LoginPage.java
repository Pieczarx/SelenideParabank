package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends PageObjects {
    public LoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private final By logoutLink = By.linkText("Log Out");
    private final By loginBtn = By.xpath("//input[@value='Log In']");
    private final By usernameInput = By.xpath("//input[@name='username']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By errorMessage = By.xpath(".//p[@class='error']");
    private void enterUsername(String username) { waitForElement(usernameInput,5).sendKeys(username); }
    private void enterPassword(String password) { waitForElement(passwordInput,5).sendKeys(password); }
    private void clickLogOutLink() { waitForElement(logoutLink, 5).click();}
    private void clickLoginBtn() { waitForElement(loginBtn, 5).click(); }
    @Step
    public void errorMessageShouldBe() {
        waitForTextInElement(waitForElement(errorMessage,5), "Please enter a username and password.", 10);
    }
    @Step
    public void secondErrorMessageShouldBe() {
        waitForTextInElement(waitForElement(errorMessage,5), "The username and password could not be verified.", 10);
    }
    @Step
    public void logOutUser () {
        clickLogOutLink();
    }
    @Step
    public void loginUser(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
    }
}
