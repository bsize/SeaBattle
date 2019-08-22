package app.Pages;

import org.openqa.selenium.By;
import webDriver.elements.Button;

public class ConfirmationPage {
    private Button btnConfirmation = new Button(By.xpath("//button[contains(.,'OK')]"), "confirmation button");

    public void btnConfirmationClick(){
        btnConfirmation.click();
    }
}
