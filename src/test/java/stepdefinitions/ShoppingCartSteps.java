package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Then("The Shopping cart page should be open")
    public void isShoppingCartPageOpen() {
        Assert.assertTrue(shoppingCartPage.state().waitForDisplayed(), "Shopping cart page is not displayed");
    }

    @Then("Product with {string} is in the cart")
    public void productWithIsInTheCart(String id) {
        Assert.assertEquals(shoppingCartPage.productId(),id, "Incorrect product is added to the cart");
    }


    @When("I remove product with {string} from the cart")
    public void removingProductFromCart(String id) {
        shoppingCartPage.removeButton(id);
    }
}
