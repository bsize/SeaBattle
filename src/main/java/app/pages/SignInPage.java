package app.pages;

import org.openqa.selenium.By;
import webDriver.elements.Button;
import webDriver.elements.Label;
import webDriver.elements.TextBox;

public class SignInPage {

    private TextBox txbEmailAddress = new TextBox(By.xpath("//input[@type='email']"), "Email");
    private TextBox txbPassword = new TextBox(By.xpath("//input[@type='password']"), "Password");
    private Button btnSignIn = new Button(By.xpath("//button[@type='submit']"), "SignIn");

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
