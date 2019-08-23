package app.forms;

import org.openqa.selenium.By;
import web_driver.elements.Button;

public class ProductsForm {

    private Button btnDownload;

    public void btnDownloadClick(String nameOfProduct) {
        btnDownload = new Button(By.xpath(String.format("//div[contains(text(),'%s')]/ancestor::div[contains(@class,'download')]" +
                "//button[contains(@data-section,'Downloads')]", nameOfProduct)), "select product Button");
        btnDownload.clickWithExecutor();
    }
}
