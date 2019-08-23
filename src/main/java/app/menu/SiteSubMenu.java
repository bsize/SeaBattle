package app.menu;

import org.openqa.selenium.By;
import web_driver.elements.Button;

public class SiteSubMenu {

    private Button btnSelectSiteSubMenu;

    public void btnSiteSubMenuClick(String value) {
        btnSelectSiteSubMenu = new Button(By.xpath(String.format("//div[starts-with(@class, 'w-menu') and contains(text(), '%s')]", value)), "Header menu");
        btnSelectSiteSubMenu.click();
    }


}
