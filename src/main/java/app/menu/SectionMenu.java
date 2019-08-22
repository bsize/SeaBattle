package app.menu;

import org.openqa.selenium.By;
import webDriver.elements.Button;
import webDriver.elements.TextBox;

public class SectionMenu {
    private TextBox txbAccountMenu;
    private Button btnLoading = new Button(By.xpath("//div[contains(text(),'Загрузки')]"), "Download Button");

    public boolean checkAuthorization(String email) {        
        txbAccountMenu = new TextBox(By.xpath(String.format("//span[contains(text(), '%s')]", email)) , "User label email");
        return txbAccountMenu.isDisplayed();
    }

    public void btnLoadingClick() {
        btnLoading.click();
    }
}
