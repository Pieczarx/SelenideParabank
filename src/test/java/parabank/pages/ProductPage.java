package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import parabank.pages.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage extends Page {

    public SelenideElement sortSelectedList = $(By.cssSelector(".product_sort_container"));
    public ElementsCollection productsName = $$(By.className("inventory_item_name"));
    public SelenideElement addBackPackToCartButton = $(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
    public SelenideElement addBikeToCartButton = $(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
    public SelenideElement cartButton = $(By.cssSelector(".shopping_cart_link"));




    public ElementsCollection productPrices = $$(By.className("inventory_item_price"));
    public ElementsCollection elementsOnProductPage = $$(By.className("inventory_item_description"));
    public ElementsCollection addToCartBtns = $$(By.className("btn_inventory"));

    public SelenideElement backButton = $(By.className("inventory_details_back_button"));
    public SelenideElement shoppingCartItemsAmount = $(By.className("shopping_cart_badge"));
}
