package app.Pages;

import org.openqa.selenium.By;
import webDriver.elements.Button;

public class HomePage {

    private Button btnSignIn = new Button(By.xpath("//button[contains(@class,'btn btn-primary size-lg js-signin-button')]"), "SignIn button");

    public HomePage() {
        super();
    }

    public void btnSignInClick() {
        btnSignIn.click();
    }
}
