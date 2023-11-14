package parabank.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class OpenNewAccountPage extends Page {
    public SelenideElement openNewAccountLink = $(By.linkText("Open New Account"));
    public SelenideElement openButton = $(By.cssSelector("input.button"));
    public SelenideElement typeOfAccount = $(By.id("type"));
    private void selectValue(int index) {
        $(typeOfAccount).selectOption(index);
    }
    public OpenNewAccountPage openAccount() {
        openNewAccountLink.click();
        selectValue(0);
        sleep(2000);
        openButton.click();
        sleep(2000);
        return this;
    }
    public void openedAccountMessageShouldBeDisplayed() {
        Assert.assertEquals(pageTitle.shouldBe(Condition.visible).getText(), "Account Opened!");
    }
}
