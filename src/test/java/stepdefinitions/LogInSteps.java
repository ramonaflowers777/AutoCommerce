package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LogIn;

public class LogInSteps {
    private static final String errMsg = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    private final LogIn logIn = new LogIn();

    @When("I Enter email for email")
    public void iEnterEmail() {
        logIn.enterEmail(System.getenv("USER_EMAIL"));
    }

    @When("I Enter password for password")
    public void iEnterPassword() {
        logIn.enterPassword(System.getenv("USER_PASS"));
    }

    @And("I Click Log in button")
    public void IClickInLogInButton() {
        logIn.logIn();
    }

    @Then("My account Page is shown")
    public void myAccPageisShown() {
        Assert.assertTrue(logIn.successLogin(), "My Account page is not displayed");
    }

    //error message sheidzleba sxvac iyos da gasasworebeli maq
    @Then("I Should see an error message")
    public void isErrorMessageShown() {
        Assert.assertTrue(logIn.isErrorMessageDisplayed(), "Error message was not displayed");
        String actualMessage = logIn.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(errMsg), "Expected message and error messages are not matching");
    }
}
