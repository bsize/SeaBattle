
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import javax.mail.MessagingException;
import java.io.IOException;

public class SmartDataDrivenTest extends BaseEntity {

    @Parameters({"email", "password", "os", "productName"})
    @Test
    public void DownloadKasperskyProductTest(String email, String password, String os, String productName) throws IOException, MessagingException {

        logger.step("Step 1", "Authorization");
        steps.btnSignInClick();
        steps.authorization(email, password);

        logger.step("Step 2", "Go to the tab Downloads");
        steps.btnLoadingClick();

        logger.step("Step 3.1", "Select OS and Product and click Download");
        steps.btnTypeOfOSClick(os);
        steps.btnTypeOfProductClick(productName);

        logger.step("Step 3.1", "Click Send by Email");
        steps.btnSendByEmailClick();

        logger.step("Step 3.3", "Click Send and check Email");
        steps.btnSendEmailClick(email);
        steps.btnConfirmationClick();
        steps.checkMessageInMail();
    }
}
