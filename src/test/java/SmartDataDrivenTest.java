
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import javax.mail.MessagingException;
import java.io.IOException;

public class SmartDataDrivenTest extends BaseEntity {

    @Parameters({"email", "password", "os", "productName"})
    @Test
    public void DownloadKasperskyProductTest(String email, String password, String os, String productName) throws IOException, MessagingException {

        logger.step("Step 1", "Authorization");
        steps.authorize(email, password);
        logger.logDelim();

        logger.step("Step 2", "Go to the tab Downloads");
        steps.btnSiteSubMenuClick();
        logger.logDelim();

        logger.step("Step 3", "Select OS");
        steps.btnTypeOfOSClick(os);
        logger.logDelim();

        logger.step("Step 3.1", "Select product and click Download");
        steps.btnDownloadClick(productName);
        logger.logDelim();

        logger.step("Step 3.2", "Click Send by Email");
        steps.btnSendByEmailClick();
        logger.logDelim();

        logger.step("Step 3.3", "Click Send and check Email");
        steps.btnSendEmailClick();
        steps.checkMessageInMail();
    }
}
