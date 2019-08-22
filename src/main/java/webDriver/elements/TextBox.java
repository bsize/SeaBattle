package webDriver.elements;

import org.openqa.selenium.By;
import webDriver.Logger.Logger;
import webDriver.entity.BaseElement;

public class TextBox extends BaseElement {

    private static Logger logger = Logger.getInstance();

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void sendKeys(String key) {
        waitForIsElementPresent();
        getElement().sendKeys(key);
        logger.info(logger.getLoc("loc.set.value") + key + " in field " + name);
    }
}