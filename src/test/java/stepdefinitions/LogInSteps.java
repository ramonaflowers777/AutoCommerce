package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LogIn;

public class LogInSteps {
    private static final String errMsg = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    private final LogIn logIn = new LogIn();

    @When("I Enter email for email")
    @Step("Entering email")
    public void iEnterEmail() {
        logIn.enterEmail(System.getenv("USER_EMAIL"));
    }

    @When("I Enter password for password")
    @Step("Entering password")
    public void iEnterPassword() {
        logIn.enterPassword(System.getenv("USER_PASS"));
    }

    @And("I Click Log in button")
    @Step("Logging in")
    public void IClickInLogInButton() {
        logIn.logIn();
    }

    @Then("My account Page is shown")
    @Step("My account page is displayed")
    public void myAccPageisShown() {
        Assert.assertTrue(logIn.successLogin(), "My Account page is not displayed");
    }

    //error message sheidzleba sxvac iyos da gasasworebeli maq
    @Then("I Should see an error message")
    @Step("Error message is displayed")
    public void isErrorMessageShown() {
        Assert.assertTrue(logIn.isErrorMessageDisplayed(), "Error message was not displayed");
        String actualMessage = logIn.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(errMsg), "Expected message and error messages are not matching");
    }
}
