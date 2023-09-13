package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTemplatePage extends ParentPageWithDashboard {
    public CreateTemplatePage(WebDriver webDriver) {
        super(webDriver);
    }

    //       рахунок по дебету  дропдаун???????????????
   @FindBy(xpath = "//*[@class='combobox comboboxField formControl']//*[@class='ui-combobox']")
    private WebElement debitAccount;


    //  //label[@for='ida36-CARD']   обираю розділ НОМЕР КАРТКИ
    @FindBy(xpath = "//div[@class='credit']//*//*//*[contains(text(),'Номер картки')]")
    private WebElement cardNumber;

    //   //input[@class='number']   вводжу номер карти для зарахування
    @FindBy(xpath = ".//input[@class='number']")
    private WebElement inputСardNumber;


    //   //input[@class='sum']   вводжу суму для зарахування
    @FindBy(xpath = ".//input[@class='sum']")
    private WebElement inputSumInput;

    // повыдомлення "Інший банк"
    @FindBy (xpath = "//*[contains(text(),'Інший банк')]")
    private WebElement otherBank;

    //   //button[@name='actions:list:1:actionComponent'] кнопка ПРОДОВЖИТИ
    @FindBy(xpath = ".//button[@name='actions:list:1:actionComponent']")
    private WebElement buttonContinue;


    //  //input[@id='idc25']  назва шаблону
    @FindBy(xpath = ".//input[@name='fields:template.name:component']")
    private WebElement templateName;

    //   //button[@name="actions:list:0:actionComponent"]  кнопка ЗБЕРЕГТИ
    @FindBy(xpath = ".//button[@name='actions:list:0:actionComponent']")
    private WebElement buttonSave;

    // розділ 'ПІБ одержувача'
    @FindBy (xpath = "//*[contains(text(),'ПІБ одержувача')]")
    private WebElement pibOderguvacha;

    //повыдомленя "шаблон успышно збережено"
    @FindBy (xpath = "//span[@class='feedbackPanelINFO']")
    private WebElement TemplateSave;

    //кнопка Закрити пысля збереження шаблону
    @FindBy (xpath = "//button[@class='button close actionDefault']")
    private WebElement buttonClose;


    // метод вибору значення в дробдауні рахунку по дебету
    public void selectTextInDebitAccount(String text) {
        selectTextInDropDownByUI(debitAccount, text);
    }


    public void clickOnCardNumber() { // метод для кліку на кнопку "Номер карти"
        clickOnElement(cardNumber);
    }

    public void enterTextIntoInputCardNumber(String cardNumber) { // метод для введення номеру карти
        enterTextIntoInput(inputСardNumber, cardNumber);
    }

    //метод для введення суми
    public void entertextIntoInputSum(String sum) {
        enterTextIntoInput(inputSumInput, sum);
    }

    //  Метод для перевырки повыдомлення "Інший банк"
    public void checkIsOtherBankVisible() {
        checkElementDisplayed(otherBank);
    }



    public void clickOnButtonContinue() { // метод для кліку на кнопку "Продовжити"
        clickOnElement(buttonContinue);
    }

    public void enterTextIntoInputTemplateName(String templateName) { // метод для введення назви шаблону
        enterTextIntoInput(this.templateName, templateName);
    }

    public void clickOnButtonSave() { // метод для кліку на кнопку "Зберегти"
        clickOnElement(buttonSave);
    }

      // метод перевырки чи відображається розділ 'ПІБ одержувача'
    public void checkIsPibOderguvachaVisible() {
        checkElementDisplayed(pibOderguvacha);
        }

        //метод перевыряє повідомлення "Шаблон успішно збережено
        public void checkIsTemplateSaveVisible() {
            checkElementDisplayed(TemplateSave);
        }

        //метод для кліку на кнопку Закрити після збереження шаблону
        public void clickOnButtonClose() {
            clickOnElement(buttonClose);
        }
        



}
