package app.pages;

import org.openqa.selenium.By;
import webDriver.elements.Button;

public class HomePage {

    //TODO разобраться с локатором
    private Button btnSignIn = new Button(By.xpath("//button[contains(@class,'btn btn-primary size-lg js-signin-button')]"), "SignIn");

    public HomePage() {
        super();
    }

    public void btnSignInClick() {
        btnSignIn.click();
    }
}
