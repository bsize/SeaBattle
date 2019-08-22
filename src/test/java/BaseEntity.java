import app.steps.Steps;
import webDriver.utils.CheckMailAPI;
import webDriver.Logger.Logger;
import webDriver.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseEntity {
    protected static Logger logger = Logger.getInstance();
    private static Browser browser;
    public Steps steps = new Steps();

    @BeforeClass
    public void before() {
        logger.logTestName(this.getClass().getName());
        CheckMailAPI.deleteMessageBeforeTest();
        browser = Browser.getInstance();
        browser.windowMaximise();
        browser.waitForPageToLoad();
        browser.navigate(Browser.getUrl());
    }

    @AfterClass
    public void after() {
        browser.exit();
    }
}
