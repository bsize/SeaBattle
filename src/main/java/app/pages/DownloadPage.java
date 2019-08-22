package app.pages;

import org.openqa.selenium.By;
import webDriver.elements.Button;

public class DownloadPage {

    private Button btnSendByEmail = new Button(By.xpath("//span[contains(text(),'Отправить по почте')]"), "download");

    public void btnSendByEmailClick() {
        btnSendByEmail.click();
    }
}
