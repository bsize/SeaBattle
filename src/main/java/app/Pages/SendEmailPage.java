package app.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import webDriver.Logger.Logger;
import webDriver.elements.Button;
import webDriver.elements.TextBox;
import webDriver.utils.Waiters;

public class SendEmailPage {

    private TextBox txbEmailField;
    private Button btnSendEmail;
    private static Logger logger = Logger.getInstance();
    private static By locatorForIframeOne = By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]");
    private static By locatorForIframeTwo = By.xpath("//iframe[starts-with(@name, 'c-') and starts-with(@src, 'https://www.google.com/recaptcha')]");
    private static int waitForElementToBePresent = 2;
    private static int waitForElementToBeInPresent = 80;

    public String getEmail(String email){
        try{
            Waiters.waitToBeVisibleElementLocated(locatorForIframeOne, waitForElementToBePresent);
            Waiters.waitToBeVisibleElementLocated(locatorForIframeTwo, waitForElementToBePresent);
            Waiters.waitToBeInVisibleElementLocated(locatorForIframeTwo, waitForElementToBeInPresent);
        }
        catch (NoSuchElementException e){
            logger.warn("Element captcha isn't present");
        }
        txbEmailField = new TextBox(By.xpath(String.format("//input[@value='%s']", email)), "Email field");
        return txbEmailField.getAttributeValue();
    }

    public void btnSendEmailClick() {
        btnSendEmail = new Button(By.xpath("//span[contains(.,'ОТПРАВИТЬ')]"), "send Email button");
        btnSendEmail.click();
    }
}
