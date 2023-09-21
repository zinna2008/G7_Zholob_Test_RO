package templetesTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class TemplatesTest extends BaseTest {
    private String nameTemplate = "Inna " + getCurrentTimeAndDate();

    private String getCurrentTimeAndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmssyyyyMMdd");
        return sdf.format(new Date());
    }


    @Test //            створення нового шаблону
    public void createNewTemplate() {

        pageProvider.getHomePage().openHomePage() //залогінитись і перевірили
                .getDashboard().clickOnMenuTemplates()// клік на кнопку меню Шаблони
                .checkIsSearchTemplateVisible() // перевірка чи є кнопка пошуку шаблону ПЕРЕВІРКА ЧИ МИ НА СТОРІНЦІ ШАБЛОНІВ
//              .checkIsDropdownCreateTemplateVisible(); // перевірка чи є кнопка Створити шаблон ПЕРЕВІРКА ЧИ МИ НА СТОРІНЦІ ШАБЛОНІВ
                .selectTextInDropdownCreateTemplate("Переказу") //  метод для вибору значення дропдауну ПЕРЕКАЗИ
  //нова сторінка створення шаблону
                .checkTextCreateTemplateVisible()// назва вікна "Створення шаблону"
                .selectTextInDebitAccount("•••• 3859"); // введення значення Visa Raifcard в допдаун рахунку по дебету
        Util.waitABit(20);
        pageProvider.getCreateTemplatePage().clickOnCardNumber()// клык на роздыл "Номер картки"
                .enterTextIntoInputCardNumber("1234567890123456"); // вводимо номер картки для зарахування
        Util.waitABit(20);
        pageProvider.getCreateTemplatePage().checkIsOtherBankVisible() // перевірка чи є розділ "Інший банк"
                .entertextIntoInputSum("50") // вводимо суму для зарахування
                .clickOnButtonContinue()// клік на кнопку "Продовжити"
                .checkIsPibOderguvachaVisible()// перевірка чи є розділ "ПІБ одержувача"
                .clickOnButtonContinue()// клік на кнопку "Продовжити"
                .enterTextIntoInputTemplateName(nameTemplate) // ввожу назву шаблону
                .clickOnButtonSave()// клік на кнопку ЗБЕРЕГТИ
                .checkIsTemplateSaveVisible() // перевірка чи є повідомлення "Шаблон успішно збережено"
                .clickOnButtonClose() // клік на кнопку Закрити після збереження шаблону

// перевырка що шаблон з такою назвою створився
                .checkIsSearchTemplateVisible()// перевірка чи є кнопка пошуку шаблону
                .checkIsTemplateVisible(nameTemplate); // перевірка чи є шаблон з такою назвою
    }

    @After
    public void deleteTemplate() { // видалення шаблону

// метод перевырки відображення дропдауну з назвою шаблону
        pageProvider.getTemplatessPage().checkIsTemplateDropdownVisible(nameTemplate)
// метод вибору "Видалити" з дропдауну конкретного шаблону з назвою "nameTemplate"
        .selectTextInTemplateDropdown(nameTemplate, "Видалити")
        .clickOnButtonOk(); //підтвердження видалення шаблону кнопка ОК

    }

}