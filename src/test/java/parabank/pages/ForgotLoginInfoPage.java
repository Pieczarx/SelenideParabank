package parabank.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import parabank.Users.Users;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ForgotLoginInfoPage extends Page{
    public SelenideElement firstNameInput = $(By.id("firstName"));
    public SelenideElement lastNameInput = $(By.id("lastName"));
    public SelenideElement addressInput = $(By.id("address.street"));
    public SelenideElement cityInput = $(By.id("address.city"));
    public SelenideElement stateInput = $(By.id("address.state"));
    public SelenideElement zipCodeInput = $(By.id("address.zipCode"));
    public SelenideElement ssnInput = $(By.id("ssn"));
    public SelenideElement forgotLoginInfoLink = $(By.linkText("Forgot login info?"));
    public SelenideElement findMyLoginInfoBtn = $x("//input[@value='Find My Login Info']");
    public ForgotLoginInfoPage forgotLoginInfo (Users user) {
        forgotLoginInfoLink.shouldBe(Condition.enabled).click();
        firstNameInput.shouldBe(Condition.enabled).setValue(user.getFirstName());
        lastNameInput.shouldBe(Condition.enabled).setValue(user.getLastName());
        addressInput.shouldBe(Condition.enabled).setValue(user.getAddress());
        cityInput.shouldBe(Condition.enabled).setValue(user.getCity());
        stateInput.shouldBe(Condition.enabled).setValue(user.getState());
        zipCodeInput.shouldBe(Condition.enabled).setValue(user.getZipCode());
        ssnInput.shouldBe(Condition.enabled).setValue(user.getSsn());
        findMyLoginInfoBtn.shouldBe(Condition.enabled).click();
        return this;
    }

}
