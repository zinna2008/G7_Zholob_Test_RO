package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ТemplatessPage extends ParentPageWithDashboard {

    public ТemplatessPage(org.openqa.selenium.WebDriver webDriver) { // конструктор
        super(webDriver);
    } // конструктор

    //параметризований локатор для пошуку шаблону по назві
    private String nameTemplatelocator = ".//span[contains(text(),'%s')]"; //параметризований локатор для пошуку шаблону по назві

    //параметризований локатор для пошуку дробдауну з назвою шаблону
    private String nameTemplateDropdownlocator = "//*[text()='%s']//..//a[contains(@class,'actionBarTrigger')]"; // параметризований локатор для пошуку дробдауну з назвою шаблону




    @FindBy(xpath = ".//*[contains(text(),'Створити шаблон')]")// кнопка "Створити шаблон"
    private WebElement DropdownCreateTemplate;

    @FindBy(xpath = "//*[@class='button actionSearch']")// Заголовок "знайти"
    private WebElement SearchTemplate;


    //Пыдвердження видалення шаблону кнопка ОК ?????????  перевір на тесті
    @FindBy(xpath = ".//button[contains(text(),'OK')]")// кнопка "ОК"
    private WebElement buttonOK;


    // метод для перевірки чи відображається дропдаун "Створити шаблон" який повертає ту саму сторінку
    public ТemplatessPage checkIsDropdownCreateTemplateVisible() {
        checkElementDisplayed(DropdownCreateTemplate);
        return this;
    } // метод для перевірки чи відображається дропдаун "Створити шаблон" який повертає ту саму сторінку



    public ТemplatessPage checkIsSearchTemplateVisible() { // метод для перевірки чи відображається поле "Знайти"
        checkElementDisplayed(SearchTemplate);
        return this;
    }

    public CreateTemplatePage selectTextInDropdownCreateTemplate(String text) { // метод для вибору значення дропдауну при створенні шаблону
        selectTextInDropDownByUI(DropdownCreateTemplate, text);
        return new CreateTemplatePage(webDriver);
    }


    public ТemplatessPage clickOnButtonOk () { // метод для кліку на кнопку "ОК" при видаленні шаблону
        clickOnElement(buttonOK);
        return this;
    } //


    //метод який повертає список шаблонів з текстом "nameTemplate"
    //вставляємо в параметризований локатор значення "nameTemplate"
    private List<WebElement> getTemplatesList(String nameTemplate) { // метод для отримання списку шаблонів
        return webDriver.findElements(By.xpath(
                String.format(nameTemplatelocator, nameTemplate)));
    }
    public ТemplatessPage checkIsTemplateVisible(String nameTemplate) { // метод для перевірки чи відображається шаблон з такою назвою і він один
        Assert.assertEquals("Count of templates with title " + nameTemplate,
                1,
                getTemplatesList(nameTemplate).size());
        logger.info("Element is displaed");
   return this;
    }

    //метод перевірки чи відображається дродаун з назвою шаблону
public ТemplatessPage checkIsTemplateDropdownVisible(String nameTemplate) {
        checkElementDisplayed(webDriver.findElement(By.xpath(
                String.format(nameTemplateDropdownlocator, nameTemplate))));
        return this;
    }




//ДРОПДАУН ШАБЛОНА !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //метод вибору значення "Видалити" або "Редагувати" на дропдаун TemplateDropdown з параметризованим локатором
    public ТemplatessPage selectTextInTemplateDropdown(String nameTemplate, String text) {
        clickOnElement(webDriver.findElement(By.xpath(
                String.format(nameTemplateDropdownlocator, nameTemplate) )));
        clickOnElement(webDriver.findElement(By.xpath(
                String.format(nameTemplateDropdownlocator, nameTemplate) + "/..//*[contains(text(),'" + text + "')]")));
        logger.info(text + " was selected in DropDown");
        return this;
    }





}





