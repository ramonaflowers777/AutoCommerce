package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LogIn;
import utils.ErrorMessageUtils;

import java.io.IOException;
import java.util.List;

public class LogInSteps {
    private final LogIn logIn = new LogIn();

    @When("I Enter {string} for email")
    @Step("Entering email: {0}")
    public void enteringValidEmail(String email) {
        logIn.enterEmail(email);
    }

    @When("I Enter {string} for password")
    @Step("Entering password: {0}")
    public void enteringInvalidPassword(String password) {
        logIn.enterPassword(password);
    }

    @When("I Click Log in button")
    @Step("Logging in")
    public void IClickInLogInButton() {
        logIn.logIn();
    }

    @Then("I should see {string}")
    @Step("Verifiying result : {0} ")
    public void myAccPageisShown(String expectedResult) throws IOException {
        if (expectedResult.equalsIgnoreCase("My account page")) {
            Assert.assertTrue(logIn.successLogin(), "My Account page is not displayed");
        }
        else if (expectedResult.equalsIgnoreCase("Error message")) {
            Assert.assertTrue(logIn.isErrorMessageDisplayed(), "Error message was not displayed");
            String actualMessage = logIn.getErrorMessage();
            List<String> possibleMessages = ErrorMessageUtils.errorMessagesList();
            Assert.assertTrue(possibleMessages.contains(actualMessage), "Expected message and error messages are not matching");
        }
    }
}
