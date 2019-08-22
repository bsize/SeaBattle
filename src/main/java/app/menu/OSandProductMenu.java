package app.menu;

import org.openqa.selenium.By;
import webDriver.elements.Button;

public class OSandProductMenu {

    private Button btnTypeOfProduct;
    private Button btnTypeOfOS;

    public void btnTypeOfOSClick(String os) {
        btnTypeOfOS = new Button(By.xpath(String.format("//div[@data-at-selector='osName'][contains(.,'%s')]", os)), "select OS");
        btnTypeOfOS.click();
    }

    public void btnTypeOfProductClick(String nameOfProduct) {
        btnTypeOfProduct = new Button(By.xpath(String.format("//div[contains(text(),'%s')]/ancestor::div[contains(@class,'download')]" +
                "//button[contains(@data-section,'Downloads')]", nameOfProduct)), "select product Button");
        btnTypeOfProduct.clickWithExecutor();
    }
}
