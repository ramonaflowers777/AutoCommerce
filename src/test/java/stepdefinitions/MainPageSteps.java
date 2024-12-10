package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPage;

public class MainPageSteps {
    private final MainPage mainPage = new MainPage();

    @Given("I am on the Main Page")
    @Step("I am on the main page")
    public void iAmOnTheMainPage() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not open");
    }

    @When("I Click on My account and choose Log in")
    @Step("Logging in on My account page")
    public void iClickOnMyAccAndLogIn() {
        mainPage.clickOnMyAccountAndChooseLogIn();
    }

    @When("I click on the search field and input {string}")
    @Step("Searching for products")
    public void searchForProduct(String product) {
        mainPage.searchForProduct(product);
    }

    @When("I open the currency dropdown")
    @Step("Opening currency dropdown menu")
    public void clickOnDropDown() {
        mainPage.openCurrencyDropDown();
    }

    @When("I select {string}")
    @Step("Selecting desiered currency")
    public void choosingCurrency(String currencyName) {
        mainPage.choosingCurrency(currencyName);
    }

    @Then("the currency for products should be displayed in {string}")
    @Step("Changed currency correctly")
    public void isCurrencyChanged(String expectedSymbol) {
        String priceLabel = mainPage.priceLabel();
        Assert.assertEquals(priceLabel, expectedSymbol, "Currencies do not match");
    }

    @When("I add product with {string} in cart")
    @Step("Clicking on Add to cart button")
    public void iAddProductToTheCart(String id) {
        mainPage.addProductToCart(id);
    }

    @Then("Success Message with product {string} is shown")
    @Step("Correct success message is displayed with the product name")
    public void isSuccessMessageShown(String id) {
        Assert.assertTrue(mainPage.successMessageFromAddingToCart(id), "Success message for product is not shown");
    }

    @When("I open the cart")
    @Step("Opening cart in different page")
    public void iOpenTheCart() {
        try {
            mainPage.openingCart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I click {string} link in footer")
    @Step("Testing functionality of links in footer")
    public void clickingOnTheFooterLink(String linkName) {
        mainPage.clickOnTheFooterLink(linkName);
    }

    @Then("Page should contain {string} displayed")
    @Step("Correct link page is displayed")
    public void isPageDisplayed(String pageHeader) {
        String headerXpath = String.format("//div[@id='content']//h1[text()='%s']", pageHeader);
        boolean isDisplayed = AqualityServices.getBrowser().getDriver().findElement(By.xpath(headerXpath)).isDisplayed();
        Assert.assertTrue(isDisplayed, "Page is not correctly displayed");
    }
}
