package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.Locator;

public class SribloPage extends BasePage{
    //создался конструктор на основе родительского
    public SribloPage(WebDriver driver) {
        super(driver);
    }
    //создаем вложенный класс с локаторами на странице результатов
    private static class Locators{
        private final static By filterBySize21=By.xpath("//a[@data-value='21']");
        private final static By filterByVstavkaZhemchug=By.xpath("//a[@data-value='zhemchug']");
        private final static By filterByCvetWhite=By.xpath("//a[@data-value='belyjj']");
        private final static By asseptFilters=By.xpath("//button[@class='btn grey filter-btn confirm-filter-main']");
        private final static By clearFilters=By.xpath("//button[@class='btn grey filter-btn confirm-filter-main']");
        private final static By messageCountProductonPage=By.xpath("//div[@class='amount-item']");
        private final static By sortByCountProductOnPage=By.xpath("//div[@class='jq-selectbox__trigger']/div[1]");
        private final static By filterByCountProductOnPage24=By.xpath("//ul[@style='position: relative; list-style: none; overflow: hidden auto; max-height: 208px;']/li[3]");
        private final static By productToCompare1=By.xpath("//div[@id='product-332']/div/a[@data-id-product='332']");
        private final static By productToCompare2=By.xpath("//div[@id='product-919']/div/a[@data-id-product='919']");
        private final static By compareWindow=By.xpath("//div[@id='product-919']/div/a[@data-id-product='919']");
        private final static By by1Product=By.xpath("//a[@class='btn grey-buy button-buy-product'][1]");
        private final static By windowBasket=By.xpath("//div[@id='checkoutDialog']");
        private final static By deleteInBasket=By.xpath("//button[@class='remove checkout-delete']");
        private final static By noProductsInKorzina=By.xpath("//div[@class='align-center regular-text']");
        private final static By openFilterBySize=By.xpath("//button[@id='hidden_button']");

        ///////////

    }

    private static class Text{
        private final static String titleNameSriblo="Серебряные украшения | Купить ювелирные изделия из серебра в Украине - Faina.ua";
        private final static String noProductsInBasket="Ви ще не додали жодного товару";
        private final static String allProducts="359 ТОВАРІВ";

    }

    public void checkNameOfPage(){
        assertions.equalsOfStrings(driver.getTitle(), Text.titleNameSriblo);
    }
    public void choiseFilters(){
        elements.clickOnElementBy(Locators.openFilterBySize);
        elements.clickOnElementBy(Locators.filterBySize21);
        elements.clickOnElementBy(Locators.filterByVstavkaZhemchug);
        elements.clickOnElementBy(Locators.filterByCvetWhite);
        waiters.waitvisabilityOFWebelement(Locators.asseptFilters);
        elements.clickOnElementBy(Locators.asseptFilters);
    }
    public void clearFiltersAndCheck(){
        elements.clickOnElementBy(Locators.clearFilters);
        waiters.waitvisabilityOFWebelement(Locators.messageCountProductonPage);
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.messageCountProductonPage),Text.allProducts);

    }
    public void choiseFilterByCountProductOnPage(){
        elements.clickOnElementBy(Locators.sortByCountProductOnPage);
        waiters.waitvisabilityOFWebelement(Locators.filterByCountProductOnPage24);
        elements.clickOnElementBy(Locators.filterByCountProductOnPage24);
        //waiters.waitvisabilityOFWebelement(Locators.messageCountProductonPage);
        // assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.messageCountProductonPage),);

    }
    public void addToCompare(){
        elements.clickOnElementBy(Locators.productToCompare1);
        elements.clickOnElementBy(Locators.productToCompare2);
    }
    public void addToKorzinaAndDeleteInKorzina(){
        elements.clickOnElementBy(Locators.by1Product);
        elements.clickOnElementBy(Locators.windowBasket);
        elements.clickOnElementBy(Locators.deleteInBasket);
        waiters.waitvisabilityOFWebelement(Locators.noProductsInKorzina);
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.noProductsInKorzina),Text.noProductsInBasket);

    }

}
