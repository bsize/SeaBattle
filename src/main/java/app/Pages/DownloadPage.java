package app.Pages;

import org.openqa.selenium.By;
import webDriver.elements.Button;

public class DownloadPage {

    private Button btnSendByEmail = new Button(By.xpath("//span[contains(.,'Отправить по почте')]"), "download button");

    public void btnSendByEmailClick() {
        btnSendByEmail.click();
    }
}
