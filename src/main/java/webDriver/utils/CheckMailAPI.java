package webDriver.utils;


import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Browser;
import webDriver.Logger.Logger;
import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;



public class CheckMailAPI {

    private static URL confProp = PropertiesReader.class.getClassLoader().getResource("dates.xml");
    private static int maxTimeWaitUntilMessageCome = 10;
    private static Logger logger = Logger.getInstance();

    public static String getMessage() throws MessagingException, IOException{
        waitUntilComeMessage();
        Store store = createEmailSession();
        Folder emailFolder = createInbox(store);
        Message[] messages = emailFolder.getMessages();
        if (messages.length > 1) {
            throw new IndexOutOfBoundsException();
        }
        Message message = emailFolder.getMessage(messages.length);
        MimeMultipart content = (MimeMultipart) message.getContent();
        String messageText = getTextFromMimeMultipart(content);
        emailFolder.close(true);
        store.close();
        logger.info("Get text from message");
        return messageText;
    }

    private static Store createEmailSession() {
        logger.info("Create Mail session");
        PropertiesReader propertiesReader = new PropertiesReader();
        propertiesReader.setUrl(confProp);
        String host = propertiesReader.getPropsFromXML("host");
        String email = propertiesReader.getPropsFromXML("email");
        String password = propertiesReader.getPropsFromXML("password");
        Properties properties = new Properties();
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);
        Store store = null;
        try {
            store = emailSession.getStore("pop3s");
            store.connect(host, email, password);
        } catch (MessagingException e) {
            logger.error("Connect session failed");
        }
        return store;
    }

    private static Folder createInbox(Store store) {
        logger.info("Create Mail Box");
        Folder folder = null;
        try {
            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
        } catch (MessagingException e) {
            logger.error("Create a folder Inbox failed ");
        }
        return folder;
    }

    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
        logger.info("Get text from message");
        StringBuilder result = new StringBuilder();
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result.append("\n").append(bodyPart.getContent());
                break;
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result.append("\n").append(org.jsoup.Jsoup.parse(html).text());
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
            }
        }
        return result.toString();
    }

    public static void deleteMessageBeforeTest() {
        logger.info("Delete messages in Mail Box");
        Store store = createEmailSession();
        try {
            Folder emailFolder = createInbox(store);
            Message[] messages = emailFolder.getMessages();
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                message.setFlag(Flags.Flag.DELETED, true);
            }
            emailFolder.close(true);
            store.close();
        } catch (MessagingException e) {
            logger.error("Delete message failed");
        }
    }

    private static void waitUntilComeMessage(){
        logger.info("Wait until come message");
        WebDriverWait wait = new WebDriverWait(Browser.getInstance().getDriver(), maxTimeWaitUntilMessageCome);
        wait.until((ExpectedCondition<Boolean>) driver -> {
            Message[] messages;
            Store store = createEmailSession();
            Folder emailFolder = createInbox(store);
            try {
                messages = emailFolder.getMessages();
            } catch (MessagingException e) {
                logger.error("Get message in folder failed");
                return false;
            }
            return messages.length == 1;
        });
    }
}
