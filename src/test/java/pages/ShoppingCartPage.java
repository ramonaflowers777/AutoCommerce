package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Form {
    private final ILink addedProduct = getElementFactory().getLink(By.xpath("//td[@class='text-center']//a[contains(@href,'product_id')]"), "Product");
    private final ILink productIdLink = getElementFactory().getLink(By.xpath("//div[@class='table-responsive']//table//tbody//a[contains(@href,'product_id')]"), "Product Link");

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


}

