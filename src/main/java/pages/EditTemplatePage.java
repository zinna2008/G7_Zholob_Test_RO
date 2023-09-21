package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditTemplatePage extends ParentPageWithDashboard {

    public EditTemplatePage(org.openqa.selenium.WebDriver webDriver) { //конструктор
        super(webDriver);
    }// конструктор
    //описуємо елементи сторінки редагування шаблну переказу

    //вибыр рахунку по дебету на сторынцы редагування шаблону
        @FindBy(xpath = ".//a[@class='ui-combobox-input ui-autocomplete-input option-placeholder']")
    private WebElement DropdownEditAccounDebet;

    //заголовок "Редагування шаблону"
    @FindBy(xpath = ".//h1[contains(text(),\"Редагування шаблону\")]")
    private WebElement TitleEditTemplate;

    //выбыр розділу "Карта або рахунок" по кредету
    @FindBy(xpath = ".//div[@class='credit']//*//*//*[contains(text(),'Картка або рахунок')]")
    private WebElement AccountCredit;

    // Дропдаун вибору рахунку по кредету
    @FindBy(xpath = ".//*[@class='credit']//*//*[@class='combobox comboboxField formControl']//*[@class='ui-combobox']")
    private WebElement DropdownEditAccounCredit;

    // вибыр значення дропдауну рахунку по кредету
    @FindBy(xpath = "//*[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//*//*//*[contains(text(),'•••• 1766')]")
    private WebElement selectDropdownEditAccounCredit;

    // назва поля "Назва шаблону"
    @FindBy(xpath = ".//label[contains(text(),'Назва шаблону')]")
    private WebElement titleNameTemplate;



   //кнопка "ПРОДОВЖИТИ"
   @FindBy(xpath = ".//button[@name='actions:list:2:actionComponent']")
   private WebElement buttonNext;

//    сумма переказу так само як для створення шаблону
//   "назва шаблону" - така як для створення шаблону
//    "Збререгти" аналогычна
//    "Шаболон успышно збережено" налогычно
//    "Закрити" аналогычно

// методи

    // метод для вибору значення в дробдауні рахунку по дебету
    public EditTemplatePage selectTextInDropdownEditAccounDebet(String text) {
        selectTextInDropDownByUI(DropdownEditAccounDebet, text);
        return this;
    }
    //клік на розділ "Карта або рахунок" по кредету
    public EditTemplatePage clickOnAccountCredit() {
        clickOnElement(AccountCredit);
        return this;
    }

    // метод для вибору значення в дробдауні рахунку по кредету
    public EditTemplatePage selectTextInDropdownEditAccountCredit(String text) {
        selectTextInDropDownByUI(DropdownEditAccounCredit, text);
        return this;
       }

    // метод для вибору значення в дробдауні рахунку по кредету по значенню
    public EditTemplatePage selectTextInDropdownEditAccounCreditByValue(String value) {
        selectTextInDropDownByUI_X(DropdownEditAccounCredit, value);
        return this;
    }


    // метод для перевірки чи відображається заголовок "Редагування шаблону"
    public EditTemplatePage checkIsTitleEditTemplateVisible() {
        checkElementDisplayed(TitleEditTemplate);
        return this;
    }

    // метод для клыку на кнопку "ПРОДОВЖИТИ" на сторынцы редагування шаблону
    public EditTemplatePage clickOnButtonNext() {
        clickOnElement(buttonNext);
        return this;
    }

    //метод для вибору дропдауну рахунку по кредиту
    //клыкаю дропдаун
    public EditTemplatePage clickOnDropdownEditAccounCredit() {
        clickOnElement(DropdownEditAccounCredit);
        clickOnElement(selectDropdownEditAccounCredit);
        logger.info(".... 1766" + " was selected in DropDown");
        return this;
    }
    //метод выдобрадження назви поля "Назва шаблону"
    public EditTemplatePage checkIsTitleNameTemplateVisible() {
        checkElementDisplayed(titleNameTemplate);
        return this;
    }



}
