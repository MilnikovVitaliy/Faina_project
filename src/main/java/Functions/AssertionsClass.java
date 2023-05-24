package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionsClass {
    static final Logger logger = LoggerFactory.getLogger(AssertionsClass.class);
    private final ElementsClass elements;
    private final ActionClass actions;
    private final WebDriver driver;
    private final WaitersClass waiters;

    public AssertionsClass(WebDriver driver) {
        this.driver = driver;
        elements = new ElementsClass(driver);
        actions = new ActionClass(driver);
        waiters = new WaitersClass(driver);
    }

    public void equalsOfStrings(String actualString, String expectedString){
        logger.info("trying to check element "+actualString.toString()+" Equals to String "+expectedString.toString());
        assertEquals(actualString,expectedString,
                "Я ожидал получить "+expectedString+". А получил "+ actualString);
    }
    public void elementIsDisplayed(String xpath){
        assertTrue(elements.isElementDisplayed(xpath), "Элемент не отображается, хотя должен был");
    }
    public void elementIsDisplayed(By by){
        assertTrue(elements.isElementDisplayed(by), "Элемент не отображается, хотя должен был");
    }

}
