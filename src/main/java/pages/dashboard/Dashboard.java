package pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.ТemplatessPage;

public class Dashboard extends ActionsWithElements {
    private org.openqa.selenium.WebDriver
            WebDriver;


    @FindBy(xpath = ".//li[@class='active dashboard']") // меню Головна
    private WebElement menuDashboard;

    @FindBy(xpath = ".//li[@class='templates']") // меню Шаблони
    private WebElement menuTemplates;






    public Dashboard(WebDriver webDriver) { // конструктор
        super(webDriver);
    } // конструктор

    public void checkIsDashboardVisible() {
        checkElementDisplayed(menuDashboard); // метод для перевірки чи відображається меню Головна
    }
    public void checkIsTemplatesVisible() {
        checkElementDisplayed(menuTemplates); // метод для перевірки чи відображається меню Шаблони
    }


public void clickOnMenuTemplates() {
        clickOnElement(menuTemplates);
    }


//    // метод для кліку на кнопку "Головна"
//    //метод для вибору значення дропдауну
//    public  ТemplatessPage clickOnMenuTemplates()  { // мметод для кліку на кнопку "Шаблони'
//       clickOnElement(menuTemplates);
//        return new ТemplatessPage(WebDriver); // ТУТ повертається нова сторінка Шаблони
//   }

}


