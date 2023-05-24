
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class MainPageTests extends BaseTest{

    @Test(priority = 1)//корректное название главной страниці
    public void titleTest() {
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        System.out.println(driver.getTitle());
        mainPage.checkNameOfPage();
    }
    @Test(priority = 2)//возврат на главную страницу с помоью лого
    public void comeBacktoMainViaLogo(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionZoloto();
        mainPage.comeBackToMainPageViaLogo();
    }
    @Test(priority = 3)
    public void rederectToFacebook(){//переход по соц сети фейсбук
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        Set<String> setFirst = driver.getWindowHandles(); //получаем идент.номер первого окна из множества открытых окон
        String firstdDesc = setFirst.iterator().next(); //получаем дискриптор нужного нам окна
        mainPage.clickOnSocialNet();
        Set<String> setSecond = driver.getWindowHandles(); //получаем идент.номер второго окна из множества открытых окон
        setSecond.removeAll(setFirst);//убираем дубликаты
        String secondDesc = setSecond.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(secondDesc);
        System.out.println(driver.getCurrentUrl());
        mainPage.checkPageOfFB();
        driver.switchTo().window(firstdDesc);//добавила чтобы дальнейшие тесты не упали
    }
    @Test(priority = 4)//отображение корзины
    public void korzinaDisplayed(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.checkDisplayedKorzina();
    }
    @Test(priority = 5)//под вопросом
    public void zakazZvorotniiDzvinok(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.zakazZvorotnDzvinka("Виталий");

    }
    @Test(priority = 6)//наличие секций в каталоге
    public void countSection(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.sections();
        List<WebElement> listSection=driver.findElements(By.xpath("//ul[@class='list-unstyled catalog-drop-list']/li"));
        assertTrue(listSection.size()==7);
    }


}
