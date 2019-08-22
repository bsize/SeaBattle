package webDriver.elements;

import org.openqa.selenium.By;
import webDriver.entity.BaseElement;

public class Button extends BaseElement {
    public Button(final By locator, String text) {
        super(locator, text);
    }
}
