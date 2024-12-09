package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ProductPage;

public class ProductSteps {
    private final static String productMessage = "Search - ";
    private final ProductPage productPage = new ProductPage();

    @Then("{string} page is displayed")
    public void isProductPageDisplayed(String productName) {
        Assert.assertEquals(productPage.productHeader().toLowerCase(), (productMessage + productName).toLowerCase());
    }
}
