package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MainPage extends Form {
    private final ILink dropDown = getElementFactory().getLink(By.xpath("//ul[@class='list-inline']//li[@class='dropdown']"), "Drop down menu");
    private final ILink logInBtn = getElementFactory().getLink(By.xpath(String.format(LocatorConstants.PARTICULAR_TEXT_XPATH, "Login")), "Login Link");
    private final ITextBox searchField = getElementFactory().getTextBox(By.className("form-control"), "Search input");
    private final IButton searchBtn = getElementFactory().getButton(By.xpath("//span[@class='input-group-btn']//button"), "Search Button");
    private final IButton currencyDropdownButton = getElementFactory().getButton(By.className("dropdown-toggle"), "Dropdown menu for currency");
    private final IElement currencyDropDownMenu = getElementFactory().getLabel(By.className("dropdown-menu"),"Drop Down menu");
    private final ILabel priceLabel = getElementFactory().getLabel(By.className("price"), "Price Label");
    private final ILabel successMessageForAddingToCart= getElementFactory().getLabel(By.xpath(  "//div[contains(@class,'alert-success') and contains(text(),'Success: You have added')] "),"Success message with adding to cart");
    private final IButton cartButton = getElementFactory().getButton(By.id("cart"), "Cart");
    private final ILink viewCartLink = getElementFactory().getLink(By.xpath("//div[@id='cart']//a[contains(@href,'checkout/cart')]"), "Viewing cart");
    private final ILink aboutUsLink = getElementFactory().getLink(By.xpath("//footer//a[contains(text(),'About us')]"),"Footer About us  Link");


    public MainPage() {
        super(By.xpath("//div[@class='swiper-viewport']"), "Main Page");
    }


    public void clickOnMyAccountAndChooseLogIn() {
        dropDown.click();
        logInBtn.click();
    }

    public void searchForProduct(String product) {
        searchField.clearAndType(product);
        searchBtn.click();
    }

    public void openCurrencyDropDown() {
        currencyDropdownButton.click();
    }

    public void choosingCurrency(String currencyName) {
        IButton currencyButton = currencyDropDownMenu.findChildElement(By.xpath(".//button[@name='" + currencyName + "']"), ElementType.BUTTON);
        currencyButton.click();
    }

    public String priceLabel() {
        String priceText = priceLabel.getText().trim();

        if (priceText.startsWith("$") || priceText.startsWith("£")) {
            return priceText.substring(0,1);
        }
        else {
            return priceText.substring(priceText.length()-1);
        }
    }

    public void addProductToCart(String id) {
        IButton addToCartButton = getElementFactory().getButton(By.xpath("//button[@onclick=\"cart.add('" + id + "');\"]"),"Add to cart Button");
        addToCartButton.click();
    }

    public boolean successMessageFromAddingToCart(String id) {
        ILink successMessageHref = successMessageForAddingToCart.findChildElement(By.xpath("//a[contains(@href,'product_id=" + id + "')]"),ElementType.LINK);
        return successMessageHref.state().waitForDisplayed();
    }

    public void openingCart() throws InterruptedException {
       try {
           cartButton.click();
           viewCartLink.click();
           Thread.sleep(3000);
       }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnTheFooterLink(String linkName) {
        WebElement footer = AqualityServices.getBrowser().getDriver().findElement(By.tagName("footer"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",footer);

        ILink footerLink = getElementFactory().getLink(By.xpath(String.format("//footer//a[contains(text(),'%s')]",linkName)),"Footer link");
        footerLink.click();
    }


}
