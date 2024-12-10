package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Then("The Shopping cart page should be open")
    @Step("Opening Shopping cart page")
    public void isShoppingCartPageOpen() {
        Assert.assertTrue(shoppingCartPage.state().waitForDisplayed(), "Shopping cart page is not displayed");
    }

    @Then("Product with {string} is in the cart")
    @Step("Product with id is in the cart")
    public void productWithIsInTheCart(String id) {
        Assert.assertEquals(shoppingCartPage.productId(), id, "Incorrect product is added to the cart");
    }

    @Given("I have product with {string} in the cart")
    @Step("Having product in the cart with correct id")
    public void isItemWithIdInTheCart(String id) {
        Assert.assertTrue(shoppingCartPage.isProductWithIdInTheCart(id), "Item with specified id is not in the cart");
    }

    @When("I change quantity by {string} and submit")
    @Step("Changing quantity of item")
    public void changingQuantity(String quantity) {
        shoppingCartPage.changingQuantityOfItem(quantity);
    }

    @Then("The product with {string} should be removed from the cart if the {string} is 0")
    @Step("Product with quantity of 0, is removed from the cart")
    public void removeItemWithZeroQuantity(String id, String quantity) {
        int qty = Integer.parseInt(quantity);
        if (qty > 0) {
            AqualityServices.getLogger().info("Quantity is not zero so product should be in the cart");
            return;
        }
        Assert.assertFalse(shoppingCartPage.isProductWithIdInTheCart(id), "Product is still in the cart");
    }

    @Then("The total price should be price times {string} if the quantity is greater than 0")
    @Step("If quantity greater than 0, total price is calculated correctly")
    public void isTotalPriceCorrect(String quantity) {
        int qty = Integer.parseInt(quantity);
        if (qty == 0) {
            AqualityServices.getLogger().info("since quantity is 0, we are not calculating total price");
            return;
        }
        Assert.assertTrue(shoppingCartPage.isTotalPriceCorrect(quantity), "Total price is not calculated correctly");
    }
}
