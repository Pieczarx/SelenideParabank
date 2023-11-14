package parabank.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import parabank.Users.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BillPayPage extends Page{
    public SelenideElement billPayLink = $(By.linkText("Bill Pay"));
    public SelenideElement payeeNameField= $(By.name("payee.name"));
    public SelenideElement payeeAddressField = $(By.name("payee.address.street"));
    public SelenideElement payeeCityField= $(By.name("payee.address.city"));
    public SelenideElement payeeStateField = $(By.name("payee.address.state"));
    public SelenideElement payeeZipCodeField= $(By.name("payee.address.zipCode"));
    public SelenideElement payeePhoneNumberField = $(By.name("payee.phoneNumber"));
    public SelenideElement accountNumberField= $(By.name("payee.accountNumber"));
    public SelenideElement verifyAccountNumberField = $(By.name("verifyAccount"));
    public SelenideElement amountField= $(By.name("amount"));
    public SelenideElement sendPaymentButton = $x("//input[@value='Send Payment']");
    public SelenideElement completeTitle= $x("//div[@class='']//h1[@class='title']");
    private final List<String> fields = Arrays.asList("Payee name","Address","City","State","Zip Code","Phone number","Account number","Account number");
    public BillPayPage billPayForm(Users user, String name, String accNumber, String verifyAccNumber, String amount) {
        billPayLink.shouldBe(Condition.visible).click();
        payeeNameField.shouldBe(Condition.enabled).setValue(name);
        payeeAddressField.shouldBe(Condition.enabled).setValue(user.getAddress());
        payeeCityField.shouldBe(Condition.enabled).setValue(user.getCity());
        payeeStateField.shouldBe(Condition.enabled).setValue(user.getState());
        payeeZipCodeField.shouldBe(Condition.enabled).setValue(user.getZipCode());
        payeePhoneNumberField.shouldBe(Condition.enabled).setValue(user.getPhone());
        accountNumberField.shouldBe(Condition.enabled).setValue(accNumber);
        verifyAccountNumberField.shouldBe(Condition.enabled).setValue(verifyAccNumber);
        amountField.shouldBe(Condition.enabled).setValue(amount);
        sendPaymentButton.shouldBe(Condition.visible).click();
        return this;
    }
    public List<String> getErrorMessages() {
        return possibleErrors.texts();
    }
    public void compareErrors (List<String> received) {
        List<String> allErrors = new ArrayList<>();
        for (String input : fields){
            String element = input + " is required.";
            allErrors.add(element);
        }
        allErrors.add("The amount cannot be empty.");
        Assert.assertEquals(allErrors, received);
    }
}
