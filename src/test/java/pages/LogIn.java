package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;

public class LogIn extends Form {
    private final ITextBox emailInput = getElementFactory().getTextBox(By.id("input-email"), "Email input");
    private final ITextBox passwordInput = getElementFactory().getTextBox(By.id("input-password"), "Passoword input");
    private final IButton logInBtn = getElementFactory().getButton(By.xpath("//input[@value='Login']"), "Log in Button");
    private final ILabel account = getElementFactory().getLabel(By.xpath("//div[@id='content']//h2[contains(text(),'My Account')]"), "Account");
    private final ILabel errorMsg = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'alert alert-danger') and contains(text(), 'Warning: Your account has exceeded')]"), "Error message");

    public LogIn() {
        super(By.xpath(String.format(LocatorConstants.PARTICULAR_TEXT_XPATH, "Returning Customer")), "Log in Page");
    }

    public void enterEmail(String email) {
        emailInput.clearAndType(email);
    }

    public void enterPassword(String password) {
        passwordInput.clearAndType(password);
    }

    public void logIn() {
        logInBtn.click();
    }

    public boolean successLogin() {
        return account.state().waitForDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMsg.state().waitForDisplayed();
    }

    public String getErrorMessage() {
        return errorMsg.getText();
    }
}
