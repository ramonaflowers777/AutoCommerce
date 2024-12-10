package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

import java.time.Duration;

public class MainPageSteps {
    private final MainPage mainPage = new MainPage();

    @Given("I am on the Main Page")
    @Step("when i am on the main page")
    public void iAmOnTheMainPage() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not open");
    }

    @When("I Click on My account and choose Log in")
    public void iClickOnMyAccAndLogIn() {
        mainPage.clickOnMyAccountAndChooseLogIn();
    }

    @When("I click on the search field and input {string}")
    public void searchForProduct(String product) {
        mainPage.searchForProduct(product);
    }

    @When("I open the currency dropdown")
    public void clickOnDropDown() {
        mainPage.openCurrencyDropDown();
    }

    @When("I select {string}")
    public void choosingCurrency(String currencyName) {
        mainPage.choosingCurrency(currencyName);
    }

    @Then("the currency for products should be displayed in {string}")
    public void isCurrencyChanged(String expectedSymbol) {
        String priceLabel = mainPage.priceLabel();
        Assert.assertEquals(priceLabel, expectedSymbol, "Currencies do not match");
    }

    @When("I add product with {string} in cart")
    public void iAddProductToTheCart(String id) {
        mainPage.addProductToCart(id);
    }

    @Then("Success Message with product {string} is shown")
    public void isSuccessMessageShown(String id) {
       Assert.assertTrue(mainPage.successMessageFromAddingToCart(id), "Success message for product is not shown");
    }

    @When("I open the cart")
    public void iOpenTheCart() {
        try {
            mainPage.openingCart();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("I click {string} link in footer")
    public void clickingOnTheFooterLink(String linkName) {
        mainPage.clickOnTheFooterLink(linkName);
    }

    @Then("Page should contain {string} displayed")
    public void isPageDisplayed(String pageHeader) {
            String headerXpath = String.format("//div[@id='content']//h1[text()='%s']", pageHeader);
            boolean isDisplayed = AqualityServices.getBrowser().getDriver().findElement(By.xpath(headerXpath)).isDisplayed();
            Assert.assertTrue(isDisplayed, "Page is not correctly displayed");
    }
}
