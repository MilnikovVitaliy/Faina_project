package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionClass {
    static final Logger logger = LoggerFactory.getLogger(ActionClass.class);
    private final ElementsClass elements;
    private final Actions actions;
    private final WebDriver driver;

    public ActionClass(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        elements = new ElementsClass(driver);
    }

    public void moveToElementLocation(By by){
        logger.info("trying to move element "+by.toString());
        actions.moveToElement(elements.findSingleElement(by)).perform();
    }

    public void moveToElementLocationAndClick(By by){
        logger.info("trying to move element and click him "+by.toString());
        actions.moveToElement(elements.findSingleElement(by)).click().perform();
    }
}
