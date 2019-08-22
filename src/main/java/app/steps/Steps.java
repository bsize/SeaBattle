package app.steps;

import app.Pages.*;
import app.menu.SectionMenu;
import app.menu.OSandProductMenu;
import webDriver.Logger.Logger;
import webDriver.utils.CheckMailAPI;
import org.testng.Assert;
import webDriver.utils.RegularExpression;
import javax.mail.MessagingException;
import java.io.IOException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Steps {

    private static SignInPage signInPage;
    private static HomePage homePage;
    private static SectionMenu sectionMenu;
    private static OSandProductMenu oSandProductMenu;
    private static DownloadPage downloadPage;
    private static SendEmailPage sendEmailPage;
    private static ConfirmationPage confirmationPage;
    private static Logger logger = Logger.getInstance();

    public void btnSignInClick() {
        homePage = new HomePage();
        homePage.btnSignInClick();
        signInPage = new SignInPage();
        assertTrue(signInPage.checkSignInPageIsDisplayed(), "SignIn page not opened");
    }

    public void authorization(String email, String password) {
        signInPage.typeEmail(email);
        signInPage.typePassword(password);
        signInPage.btnSignInClick();
        sectionMenu = new SectionMenu();
        assertTrue(sectionMenu.checkAuthorization(email), "SignIn page not opened");
    }

    public void btnLoadingClick() {
        sectionMenu.btnLoadingClick();
        oSandProductMenu = new OSandProductMenu();
    }

    public void btnTypeOfOSClick(String os) {
        oSandProductMenu.btnTypeOfOSClick(os);
    }

    public void btnTypeOfProductClick(String productName) {
        oSandProductMenu.btnTypeOfProductClick(productName);
        downloadPage = new DownloadPage();
    }

    public void btnSendByEmailClick() {
        downloadPage.btnSendByEmailClick();
        sendEmailPage = new SendEmailPage();
    }

    public void btnSendEmailClick(String email) {
        assertEquals(sendEmailPage.getEmail(email), email, "Emails don't match");
        sendEmailPage.btnSendEmailClick();
        confirmationPage = new ConfirmationPage();
    }

    public void btnConfirmationClick() {
        confirmationPage.btnConfirmationClick();
    }

    public void checkMessageInMail() throws IOException, MessagingException {
        logger.info(logger.getLoc("loc.check.mail"));
        Assert.assertTrue(RegularExpression.searchRegex("https.*Download", CheckMailAPI.getMessage()).contains("Download"), "Text in message don't contains necessary word");
    }
}
