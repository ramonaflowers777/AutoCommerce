package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class ShoppingCartPage extends Form {
    private final ILink addedProduct = getElementFactory().getLink(By.xpath("//td[@class='text-center']//a[contains(@href,'product_id')]"), "Product");
    private final ILink productIdLink = getElementFactory().getLink(By.xpath("//div[@class='table-responsive']//table//tbody//a[contains(@href,'product_id')]"), "Product Link");
    private final ITextBox quantityInput = getElementFactory().getTextBox(By.xpath("//input[contains(@name, 'quantity[')]"), "Quantity input");

    public ShoppingCartPage() {
        super(By.xpath("//ul[@class='breadcrumb']//a[contains(@href,'checkout/cart')]"), "Shopping Cart page");
    }

    public String productId() {
        String hrefOfProduct = addedProduct.getHref();
        return hrefOfProduct.substring(hrefOfProduct.length()-2);
    }

    public void removeButton(String id) {
        try {
            String hrefOfProduct = productIdLink.getHref();
            String productId = hrefOfProduct.substring(hrefOfProduct.indexOf("product+id=") + 2);


            if (id.equalsIgnoreCase(productId)) {
                IButton removeBtn = getElementFactory().getButton(By.xpath("//a[contains(@href, 'product_id=" + id + "')]/ancestor::tr//button[contains(@onclick,'cart.remove')]"), "Removing product button");
                removeBtn.click();
            }
            Thread.sleep(30000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isProductWithIdInTheCart(String id) {
        ILink cartItem = getElementFactory().getLink(By.xpath("//table//td[@class='text-left']//a[contains(@href,'product_id=" + id + "')]"), "Cart Item");
        return cartItem.state().isDisplayed();
    }

    public void changingQuantityOfItem(String quantity) {
        quantityInput.clearAndType(quantity + Keys.ENTER);
    }

    public boolean isTotalPriceCorrect(String quantity) {
        String unitpriceText =  getElementFactory().getLabel(By.xpath("//tbody//td[@class='text-right'][1]"), "Unit price").getText();
        String unitPriceNumericPart = unitpriceText.replaceAll("[^0-9.]", ""); // removes everything except digits and decimal points

        String totalPriceText =  getElementFactory().getLabel(By.xpath("//tbody//td[@class='text-right'][2]"), "total price").getText();
        String totalPriceNumericPart = totalPriceText.replaceAll("[^0-9.]", "");

        double unitPrice = Double.parseDouble(unitPriceNumericPart);
        double totalPrice = Double.parseDouble(totalPriceNumericPart);

        int quantityInteger = Integer.parseInt(quantity);

        double totalPriceTimes = unitPrice * quantityInteger;
        return totalPrice == totalPriceTimes;
    }
}
