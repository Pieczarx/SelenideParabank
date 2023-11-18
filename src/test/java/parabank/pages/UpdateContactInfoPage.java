package parabank.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import parabank.Users.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class UpdateContactInfoPage extends Page{
    public SelenideElement updateContactInfoLink = $(By.linkText("Update Contact Info"));
    public SelenideElement firstNameField = $(By.name("customer.firstName"));
    public SelenideElement lastNameField = $(By.name("customer.lastName"));
    public SelenideElement addressField = $(By.name("customer.address.street"));
    public SelenideElement cityField = $(By.name("customer.address.city"));
    public SelenideElement stateField = $(By.name("customer.address.state"));
    public SelenideElement zipCodeField = $(By.name("customer.address.zipCode"));
    public SelenideElement phoneNumberField = $(By.name("customer.phoneNumber"));
    public SelenideElement updateBtn = $x("//input[@value='Update Profile']");
    public ElementsCollection errorSpans = $$x("//span[@class='error ng-scope']");
    private final List<String> fields = Arrays.asList("First name","Last name","Address","City","State","Zip Code");
    public void clearFieldAndSendKeys(SelenideElement element, String word){
        element.shouldBe(Condition.enabled).clear();
        element.shouldBe(Condition.enabled).setValue(word);
    }
    public void clearField(SelenideElement element){
        element.shouldBe(Condition.enabled).clear();
    }
    public void clearAllFields(){
        updateContactInfoLink.shouldBe(Condition.visible).click();
        clearField(firstNameField);
        clearField(lastNameField);
        clearField(addressField);
        clearField(stateField);
        clearField(cityField);
        clearField(zipCodeField);
        clearField(phoneNumberField);
        updateBtn.shouldBe(Condition.visible).click();
    }
    public UpdateContactInfoPage updateContactInfoPage(Users user){
        updateContactInfoLink.shouldBe(Condition.visible).click();
        clearFieldAndSendKeys(addressField, user.getAddress());
        clearFieldAndSendKeys(firstNameField, user.getFirstName());
        clearFieldAndSendKeys(lastNameField, user.getLastName());
        clearFieldAndSendKeys(stateField, user.getState());
        clearFieldAndSendKeys(cityField, user.getCity());
        clearFieldAndSendKeys(zipCodeField, user.getZipCode());
        clearFieldAndSendKeys(phoneNumberField, user.getPhone());
        updateBtn.shouldBe(Condition.visible).click();
        return this;
    }
    public List<String> getErrorMessages() {
        System.out.println(errorSpans.texts());
        return errorSpans.texts();
    }
    public void compareErrors (List<String> received) {
        List<String> allErrors = new ArrayList<>();
        for (String input : fields){
            String element = input + " is required.";
            System.out.println(element);
            allErrors.add(element);
        }
        Assert.assertEquals(allErrors, received);
    }
}
