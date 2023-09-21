package pages.dashboard;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ActionsWithElements;
import pages.EditTemplatePage;
import pages.ТemplatessPage;

import javax.xml.transform.Templates;
import java.time.Duration;

public class Dashboard extends ActionsWithElements {
    private org.openqa.selenium.WebDriver
            WebDriver;
    Logger logger = Logger.getLogger(getClass());


    @FindBy(xpath = ".//li[@class='active dashboard']") // меню Головна
    private WebElement menuDashboard;

    @FindBy(xpath = ".//li[@class='templates']") // меню Шаблони
    private WebElement menuTemplates;

    //СПІНЕР !!!!!!!!!!!!!!!!
    @FindBy(xpath = "//div[@class='blocking-indicator blocking-indicator-global in']")
    private WebElement mySpinner;






    public Dashboard(WebDriver webDriver) { // конструктор
        super(webDriver);
    }


// метод для роботи зі спінером !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public boolean waitForSpinnerToDisappear() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2)); // Ожидание на появление элемента в течение 2 секунд
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='blocking-indicator blocking-indicator-global in']")));
        } catch (Exception e) {
            // Если элемент не был найден в течение 3 секунд, продолжаем выполнение кода
            logger.info("Элемент spinner не был найден. Продолжаем выполнение кода.");
//            System.out.println("Элемент spinner не был найден. Продолжаем выполнение кода.");
            return true; // Возвращаем true, чтобы указать, что элемент не был найден
        }

        // Если элемент был найден, начинаем ожидание его исчезновения в течение 40 секунд
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(40));
        try {
            wait.until(ExpectedConditions.invisibilityOf(mySpinner));//ожидание исчезновения элемента
        } catch (Exception e) {
            // Если элемент не исчез в течение 40 секунд, выведем сообщение об ошибке
            logger.info("Элемент spinner не исчез в течение 40 секунд. Ошибка!");
//            System.out.println("Элемент spinner не исчез в течение 40 секунд. Ошибка!");
            return false; // Возвращаем false, чтобы указать, что произошла ошибка
        }

        // Если элемент исчез в течение 70 секунд, возвращаем true
        return true;
    }

//           // Вызываем метод, чтобы дождаться исчезновения спиннера
//        boolean spinnerDisappeared = page.waitForSpinnerToDisappear(driver); //
//
//        if (spinnerDisappeared) { // Если спиннер исчез
//            // Продолжаем выполнение кода после исчезновения спиннера
//            System.out.println("Продолжаем выполнение кода.");
//        } else { // Если спиннер не исчез
//            // Обработка ошибки, если spinner не исчез
//            System.out.println("Произошла ошибка. Не удалось дождаться исчезновения spinner.");
//        }
/// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    // попитка номер 2 роботи з спынером
    public void waitForSpinnerToDisappear(WebDriver webDriver) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.stalenessOf(mySpinner));
            // Ждем, пока элемент исчезнет
        } catch (NullPointerException e) {
            // Если mySpinner не был найден, выводим сообщение и продолжаем выполнение кода
            System.out.println("Элемент mySpinner не был найден. Продолжаем выполнение кода.");
        }
    }



    public Dashboard checkIsDashboardVisible() {
        checkElementDisplayed(menuDashboard); // метод для перевірки чи відображається меню Головна
    return this;
    }

    public Dashboard checkIsTemplatesVisible() {
        checkElementDisplayed(menuTemplates); // метод для перевірки чи відображається меню Шаблони
   return this;
    }

// метод відриває сторінку TemplatessPage

    public ТemplatessPage clickOnMenuTemplates() { // метод для кліку на кнопку "Шаблони'
        clickOnElement(menuTemplates);
        return new ТemplatessPage(webDriver); // ТУТ повертається нова сторінка Шаблони
    }
}

//    // метод для кліку на кнопку "Головна"
//    //метод для вибору значення дропдауну
//    public  ТemplatessPage clickOnMenuTemplates()  { // мметод для кліку на кнопку "Шаблони'
//       clickOnElement(menuTemplates);
//        return new ТemplatessPage(WebDriver); // ТУТ повертається нова сторінка Шаблони
//   }




