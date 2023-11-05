package parabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends PageObjects {
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private final By openNewAccountLink = By.linkText("Open New Account");
    private final By openNewAccountInput = By.xpath("//input[@value='Open New Account']");
    private final By open = By.cssSelector("input.button");
    private final By typeOfAccount = By.id("type");
    private void clickOpenNewAccountLink() {
        waitForElement(openNewAccountLink, 5).click();
    }
    private void selectValue(int index){
        Select select = new Select(waitForElement(typeOfAccount, 5));
        select.selectByIndex(index);
    }

    @Step
    public void openNew(int index) {
        clickOpenNewAccountLink();
        selectValue(index);
        clickElementWithWait(open);
    }
}