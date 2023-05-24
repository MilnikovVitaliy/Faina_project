package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators{

        private final static By search=By.xpath("//input[@type='search']");
        private final static By logo=By.xpath("//div[@class='logo']");
        private final static By catalog=By.xpath("//div[@class='catalog-toggle no-link mr-lg-half all-open']");
        private final static By sectionZoloti=By.xpath("//nav[@id='nav-catalog']/ul/li[1]");
        private final static By sectionSriblo=By.xpath("//nav[@id='nav-catalog']/ul/li[3]");
        private final static By korzina=By.xpath("//div[@class='checkout-sidebar']/div[1]");
        private final static By windowKorzina=By.xpath("//div[@id='checkoutDialog']");
        private final static By zvorotDzvinok=By.xpath("//a[@class='btn red-35 button-feedback']");
        private final static By windowFormZvorotDzvinok=By.xpath("//div[@class='form-title']");
        private final static By windowFormZvorotDzvinokInputName=By.xpath("//input[@class='form-control firstname']");
        private final static By windowFormZvorotDzvinokInputTel=By.xpath("//input[@class='form-control cellphone']");
        private final static By buttonVidpraviti=By.xpath("//button[@class='btn red-35 btn-submit']");
        private final static By povidomlennya=By.xpath("//div[@id='messageDialog']");
        private final static By facebook=By.xpath("//a[@class='item social-facebook'][1]");
        private final static By laptopSection=By.xpath("//p[text()='Ноутбуки, ПК, планшети']");
        private final static By section=By.xpath("//i[@class='icon-grid']");
        private final static By laptops=By.xpath("//a[@data-url='L3VrL3Nob3AvZG5lcHIvbm91dGJ1a2kuaHRtbA==']");
        private final static By actOffer=By.xpath("//div[@class='current-offer-head']/div[@class='page__title']");

    }

    private static class Url{
        private final static String url = "https://faina.ua";
    }
    private static class Text{
        private final static String tranclationElement = "Актуальные предложения";
        private final static String nameOfPage = "\"ФАIНА\" - интернет магазин ювелирных украшений. Ювелирный магазин в Днепре - Faina.ua";
        private final static String UrlOfFaceBook="https://www.facebook.com/faina.jewelry.shop/";;
    }

    public void openPage(){driver.get(Url.url);}
    public void checkNameOfPage(){
        assertions.equalsOfStrings(driver.getTitle(),Text.nameOfPage);
    }
    public void comeBackToMainPageViaLogo(){
        elements.clickOnElementBy(Locators.logo);}
    public void switchToSectionZoloto(){
        elements.clickOnElementBy(Locators.catalog);
        elements.clickOnElementBy(Locators.sectionZoloti);
    }
    public void clickOnSocialNet(){
        elements.clickOnElementBy(Locators.facebook);
    }
    public void checkPageOfFB(){
        assertions.equalsOfStrings(driver.getCurrentUrl(),Text.UrlOfFaceBook);
    }
    public void checkDisplayedKorzina(){
        elements.clickOnElementBy(Locators.korzina);
        assertions.elementIsDisplayed(Locators.windowKorzina);
    }
    public void zakazZvorotnDzvinka(String nameUser){
        elements.clickOnElementBy(Locators.zvorotDzvinok);
        waiters.waitVisibilityOfElementLocated(Locators.windowFormZvorotDzvinok);
        elements.sendKeysToElementBy(Locators.windowFormZvorotDzvinokInputName,nameUser);
        elements.sendKeysAndChislaToElementBy(Locators.windowFormZvorotDzvinokInputTel,9,9,0,5,5,9,5,5,0);
        elements.clickOnElementBy(Locators.buttonVidpraviti);
        elements.isElementDisplayed(Locators.povidomlennya);
    }
    public void sections(){
        elements.clickOnElementBy(Locators.catalog);
    }
    public void switchToSectionSriblo(){
        elements.clickOnElementBy(Locators.catalog);
        elements.clickOnElementBy(Locators.sectionSriblo);
    }


    
    public void searchByText(String text){
        elements.sendKeysToElementByAndClick(Locators.search,text);
    }

    public void checkGetTextFromElementWithTranslateText(){
        assertions.equalsOfStrings(elements.getTextFromElementBy(Locators.actOffer),Text.tranclationElement);
    }


    public void switchToSectionLaptop(){
        waiters.waitvisabilityOFWebelement(Locators.section);
        action.moveToElementLocationAndClick(Locators.section);
        action.moveToElementLocation(Locators.laptopSection);
        action.moveToElementLocationAndClick(Locators.laptops);

    }

}
