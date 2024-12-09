package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ProductPage extends Form {
    private final ILabel productName = getElementFactory().getLabel(By.xpath("//div[@id='content']//h1"), "Product name");

    public ProductPage() {
        super(By.id("product-search"), "Product search page is shown");
    }

    public String productHeader() {
        return productName.getText();
    }
}
