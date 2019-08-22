package app.pages;

import org.openqa.selenium.By;
import webDriver.elements.Button;

public class ConfirmationPage {
    private Button btnConfirmation = new Button(By.xpath("//button[contains(text(),'OK')]"), "confirmation");

    public void btnConfirmationClick(){
        btnConfirmation.click();
    }
}
