package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZolotoPage extends BasePage {
    public ZolotoPage(WebDriver driver) {
        super(driver);
    }
    private static class Locators{
        private final static By sortBy=By.xpath("//div[@class='jq-selectbox jqselect select-styler sort change-sorting']/div[@class='jq-selectbox__select']");
        private final static By priceCheapToExpensive=By.xpath("//option[@value='price-asc']");
        private final static By priceExpensiveToCheap=By.xpath("//option[@value='price-desc']");
        private final static By minPriceZolota=By.xpath("//div[@class='price price-view'][1]");
        private final static By maxPriceZolota=By.xpath("//div[@class='price price-view'][1]");
        private final static By by1Product=By.xpath("//a[@class='btn grey-buy button-buy-product'][1]");
        private final static By windowBasket=By.xpath("//div[@id='checkoutDialog']");
        private final static By productInBasket=By.xpath("//div[@class='wrap']/div[@class='title']");
        private final static By filterByCvetWhite=By.xpath("//a[@data-value='belyjj']");
        private final static By filterByProba750=By.xpath("//a[@data-value='750']");
        private final static By filterByVstavkaRubin=By.xpath("//a[@data-value='rubin']");
        private final static By asseptFilters=By.xpath("//button[@class='btn grey filter-btn confirm-filter-main']");
        private final static By messageByIncorrectFilters=By.xpath("//div[@class='amount-item']");
        private final static By deleteInBasket=By.xpath("//button[@class='remove checkout-delete']");

    }
    private static class Text{
        private final static String minPrice1product="730.8 грн";
        private final static String maxPrice1product="264267.2 грн";
        private final static String zolotoCep="ЗОЛОТАЯ ЦЕПЬ (002/10)";
        private final static String incorrectFilter="0 ТОВАРІВ";
        private final static String titleNameOfZoloto="Золотые украшения | Купить ювелирные изделия из золота в Украине - Faina.ua";
    }
    public void checkNameOfPage(){
        assertions.equalsOfStrings(driver.getTitle(), Text.titleNameOfZoloto);
    }
    public void choiceFilterCheapToExpensiveAndCheck(){
        elements.clickOnElementBy(Locators.sortBy);//ожидания добавила в clickOnElementBy
        elements.clickOnElementBy(Locators.priceCheapToExpensive);//ожидания добавила в clickOnElementBy
        waiters.waitvisabilityOFWebelement(Locators.maxPriceZolota);
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.minPriceZolota),Text.minPrice1product);

    }
    public void choiceFilterExpensiveToCheapAndCheck(){
        elements.clickOnElementBy(Locators.sortBy);
        elements.clickOnElementBy(Locators.priceExpensiveToCheap);
        waiters.waitvisabilityOFWebelement(Locators.minPriceZolota);
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.minPriceZolota),Text.maxPrice1product);

    }
    public void addToBasketProductAndCheck(){
        elements.clickOnElementBy(Locators.by1Product);
        waiters.waitVisibilityOfElementLocated(Locators.windowBasket);
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.productInBasket),Text.zolotoCep);
        elements.clickOnElementBy(Locators.deleteInBasket);
    }
    public void choiseIncorrectFilter(){
        elements.clickOnElementBy(Locators.filterByProba750);//ожидания добавила в clickOnElementBy
        elements.clickOnElementBy(Locators.filterByVstavkaRubin);
        elements.clickOnElementBy(Locators.filterByCvetWhite);
        waiters.waitvisabilityOFWebelement(Locators.asseptFilters);
        elements.clickOnElementBy(Locators.asseptFilters);
    }
    public void checkIncorrectFilters(){
        waiters.waitVisibilityOfElementLocated(Locators.messageByIncorrectFilters);
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.messageByIncorrectFilters),Text.incorrectFilter);
    }
}
