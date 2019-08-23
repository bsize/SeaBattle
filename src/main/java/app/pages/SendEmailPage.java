package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import webDriver.Logger.Logger;
import webDriver.elements.Button;
import webDriver.elements.Label;
import webDriver.elements.TextBox;
import webDriver.utils.PropertiesReader;
import webDriver.utils.Waiters;

import java.net.URL;

public class SendEmailPage {

    private TextBox txbEmailField;
    private Button btnSendEmail = new Button(By.xpath("//span[contains(text(),'ОТПРАВИТЬ')]"), "send Email button");
    private Label captcha;
    private static Logger logger = Logger.getInstance();
    private static By locatorForIframeOne = By.xpath("//iframe[@name='a-fr0i2wfxj8']");
    private static By locatorForIframeTwo = By.xpath("//iframe[@name='c-1zl9l85hcgtf']");
    private static URL confProp = PropertiesReader.class.getClassLoader().getResource("configuration.properties");

    public String getEmail(String email) {
        try {
            PropertiesReader props = new PropertiesReader();
            props.setUrl(confProp);
            captcha = new Label(locatorForIframeOne, "captcha");
            if (captcha.isPresent(Integer.parseInt(props.getTestProps("waitForElementToBePresent")))) {
                Waiters.waitToBeVisibleElementLocated(locatorForIframeTwo, Integer.parseInt(props.getTestProps("waitForElementToBePresent")));
                Waiters.waitToBeInVisibleElementLocated(locatorForIframeTwo, Integer.parseInt(props.getTestProps("waitForElementToBeInPresent")));
            }
        } catch (NoSuchElementException e) {
            logger.warn("Element captcha isn't present");
        }
        txbEmailField = new TextBox(By.xpath(String.format("//input[@value='%s']", email)), "Email field");
        return txbEmailField.getAttributeValue();
    }

    public void btnSendEmailClick() {
        btnSendEmail.click();
    }
}
