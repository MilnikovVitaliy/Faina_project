package Functions;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementsClass {
        static final Logger logger = LoggerFactory.getLogger(ElementsClass.class);
        private final WebDriver driver;
        private final WaitersClass waiters;

        public ElementsClass(WebDriver driver){
            this.driver=driver;
            waiters = new WaitersClass(driver);
        }

        public WebElement findSingleElement(By by){
            try {
                waiters.waitvisabilityOFWebelement(by);
                logger.info("trying to find element "+by.toString());
                return driver.findElement(by);
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
            return null;
        }


        public WebElement findElementByXpath(String xpath){//стринга и есть наш локатор
            try {
                waiters.waitvisabilityOFWebelement(By.xpath(xpath));
                logger.info("trying to find element "+xpath.toString());
                return driver.findElement(By.xpath(xpath));
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
            return null;
        }
         public boolean isElementDisplayed(By by){
            logger.info("trying to find element and see it is Displayed "+by.toString());
            return findSingleElement(by).isDisplayed();
        }

         public String getTextFromElementBy(By locator){
            logger.info("getting text from element "+locator.toString());
            return  findSingleElement(locator).getText();
         }

         public void clickOnElementBy(By locators){
            waiters.waitvisabilityOFWebelement(locators);
            logger.info("clicking on Element "+locators.toString());
            findSingleElement(locators).click();
         }

         public void sendKeysToElementBy(By locator,String text){
            logger.info("trying to find element  "+locator.toString());
            logger.info("typing text to Element "+text.toString());
            findSingleElement(locator).sendKeys(text);

         }
    public void sendKeysAndChislaToElementBy(By locator,int... num){
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : num) {
            stringBuilder.append(number);}
        String text = stringBuilder.toString();

        logger.info("trying to find element  "+locator.toString());
        logger.info("typing text to Element "+num);
        findSingleElement(locator).sendKeys(text);

    }
         public void sendKeysToElementByAndClick(By locator,String text){
        logger.info("trying to find element  "+locator.toString());
        logger.info("typing text to Element  "+text.toString());
        findSingleElement(locator).sendKeys(text);
        findSingleElement(locator).sendKeys(Keys.ENTER);

        }
    public boolean isElementDisplayed(String xpath){
        return findElementByXpath(xpath).isDisplayed();
    }
    public void sendKeys(By locator, int... numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : numbers) {
            stringBuilder.append(number);}
        String text = stringBuilder.toString();
        }

}

