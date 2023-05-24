package Driver;

import Functions.ActionClass;
import Functions.AssertionsClass;
import Functions.ElementsClass;
import Functions.WaitersClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverClass {
    static final Logger logger = LoggerFactory.getLogger(DriverClass.class);
    private static final long IMPLICITY_WAIT= 5l;
    static WaitersClass waiters;
    static ActionClass action;
    static AssertionsClass assertions;
    static ElementsClass elements;
    private static WebDriver driver;

    private static WebDriver setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        waiters = new WaitersClass(driver);
        elements = new ElementsClass(driver);
        action = new ActionClass(driver);
        assertions = new AssertionsClass(driver);

        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(IMPLICITY_WAIT, TimeUnit.SECONDS); //отработка скрипта 10 сек
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver getInstance(){
        if (driver == null) {
            try{
                driver= setUpDriver();
            }catch (Exception e){
                e.printStackTrace();
            }
        }return driver;
    }

    public static WebDriver startChromeDriver(){
        logger.info("Trying to start driver");
        driver = getInstance();
        return driver;
    }
}
