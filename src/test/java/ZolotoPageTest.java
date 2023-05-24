import org.testng.annotations.Test;
public class ZolotoPageTest extends BaseTest{
    @Test(priority = 1)//корректное название страницы золота
    public void titleZolotoPageTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionZoloto();
        System.out.println(driver.getTitle());
        zolotoPage.checkNameOfPage();
    }
    @Test(priority = 2)//корректно работающий фильтр Сортировка по цена по возрастанию
    public void filterByCheaptoExpensiveTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionZoloto();
        zolotoPage.choiceFilterCheapToExpensiveAndCheck();
    }
    @Test(priority = 3)//корректно работающий фильтр Сортировка по цена по убыванию
    public void filterByExpensiveToCheapTest(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionZoloto();
        zolotoPage.choiceFilterExpensiveToCheapAndCheck();

    }
    @Test(priority = 4)//Соответствие добавленного товара в корзину
    public void addToBasket(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionZoloto();
        zolotoPage.addToBasketProductAndCheck();
    }

    @Test(priority = 5)//Корректное отображение несовместиміх фильтров
    public void noProductIncompatibleFilters(){
        mainPage.openPage();//мы обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.switchToSectionZoloto();
        zolotoPage.choiseIncorrectFilter();
        zolotoPage.checkIncorrectFilters();
    }

}
