import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SribloPageTest extends BaseTest{
    @Test(priority = 1)//корректное название страницы серебра
    public void titleTVPageTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionSriblo();
        sribloPage.checkNameOfPage();
    }
    @Test(priority = 2)//работоспособность очищения фильтров
    public void clearFiltersTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionSriblo();
        sribloPage.choiseFilters();
        sribloPage.clearFiltersAndCheck();
        System.out.println(elements.getTextFromElementBy(By.xpath("//div[@class='amount-item']")));

    }
    @Test(priority =3)//фильтр по кол-ву продуктов на странице
    public void visabilityByFilterCountProductTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionSriblo();
        sribloPage.choiseFilterByCountProductOnPage();
        List<WebElement> listOfProduct=driver.findElements(By.xpath("//div[@id='content_products']/div"));
        assertTrue(listOfProduct.size()==24);

    }
    @Test(priority = 5)//добавление к сравнению
    public void compareProductsTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionSriblo();
        sribloPage.addToCompare();
        List<WebElement> listOfCompare=driver.findElements(By.xpath("//div[@id='compareHolder']/div/following-sibling::div/div/ul/li/a/span"));
        String[] massivIsTexta={"Кольца с цирконием (1)","Женские кольца (1)"};
        for (int i = 0; i < massivIsTexta.length; i++) {
            assertions.equalsOfStrings(listOfCompare.get(i).getText(),massivIsTexta[i]);
        }
    }
    @Test(priority = 4)//удаление товаров из корзины
    public void deleteInKorzinaProduct(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionSriblo();
        sribloPage.addToKorzinaAndDeleteInKorzina();
    }

}
