package parabank.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Page{

    public SelenideElement rightPanelMessage = $(By.xpath("//div[@id='rightPanel']//p[1]"));
    public SelenideElement requestLoanMessage = $(By.xpath("//div[@class='ng-scope']//p[1]"));
    public ElementsCollection possibleErrors = $$x("//span[@class='error']");
    public SelenideElement error = $(By.className("error"));

    public SelenideElement pageTitle = $(By.className("title"));

}
