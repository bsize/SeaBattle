package app.Pages;

import org.openqa.selenium.By;
import webDriver.elements.Button;
import webDriver.elements.TextBox;

public class SignInPage {

    private TextBox txbEmailAddress = new TextBox(By.xpath("//input[@type='email']"), "Email field");
    private TextBox txbPassword = new TextBox(By.xpath("//input[@type='password']"), "Password field");
    private TextBox txbSignIn = new TextBox(By.xpath("//div[@class='u-text is-block is-bold is-mxl']"), "Sign in to My Kaspersky");
    private Button btnSignIn = new Button(By.xpath("//button[@type='submit']"), "SignIn Button");


    public boolean checkSignInPageIsDisplayed() {
        return txbSignIn.isDisplayed();
    }

    public void typeEmail(String email) {
        txbEmailAddress.sendKeys(email);
    }

    public void typePassword(String password) {
        txbPassword.sendKeys(password);
    }

    public void btnSignInClick() {
        btnSignIn.click();
    }
}
