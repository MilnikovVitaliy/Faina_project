import Driver.DriverClass;
import Functions.ActionClass;
import Functions.AssertionsClass;
import Functions.ElementsClass;
import Functions.WaitersClass;
import Pages.BasePage;
import Pages.ZolotoPage;
import Pages.MainPage;
import Pages.SribloPage;
import Utils.TestResultListeners;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;


@Listeners(TestResultListeners.class)
public class BaseTest {
    static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver = DriverClass.startChromeDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected ZolotoPage zolotoPage=new ZolotoPage(driver);
    protected SribloPage sribloPage = new SribloPage(driver);
    protected WaitersClass waiters = new WaitersClass(driver);
    protected ActionClass action = new ActionClass(driver);
    protected AssertionsClass assertions = new AssertionsClass(driver);
    protected ElementsClass elements = new ElementsClass(driver);

    @AfterSuite
    public void closeDriver(){
        logger.info("driver is closing");
        driver.quit();
    }
}
