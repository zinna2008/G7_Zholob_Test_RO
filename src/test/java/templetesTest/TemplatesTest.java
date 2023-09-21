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
// створення шаблону
//    @Before()
//
//    public void validLogin() {
//
//        pageProvider.getloginPage().openLoginPage();
//        pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
//        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
//        pageProvider.getloginPage().clickOnButtonSignIn(); // клік на кнопку Вхід
//        //ПЕРЕВІРКА ЧИ МИ НА ГОЛВНІЙ СТОРІНЦІ ПІСЛЯ ЛОГІНУ
//        pageProvider.getHomePage().getDashboard().checkIsDashboardVisible(); // перевірка чи є кнопка меню Головна
//        pageProvider.getHomePage().getDashboard().checkIsTemplatesVisible(); // перевірка чи є кнопка меню Шаблони
//    }

    @Test //            створення нового шаблону
    public void createNewTemplate() {

        pageProvider.getHomePage().openHomePage(); //залогінитись і перевірили

        pageProvider.getHomePage().getDashboard().clickOnMenuTemplates();// клік на кнопку меню Шаблони

  //      pageProvider.getTemplatessPage().checkIsSearchTemplateVisible(); // перевірка чи є кнопка пошуку шаблону ПЕРЕВІРКА ЧИ МИ НА СТОРІНЦІ ШАБЛОНІВ
 //       Util.waitABit(10);
        pageProvider.getTemplatessPage().checkIsDropdownCreateTemplateVisible(); // перевірка чи є кнопка Створити шаблон ПЕРЕВІРКА ЧИ МИ НА СТОРІНЦІ ШАБЛОНІВ
        pageProvider.getTemplatessPage().selectTextInDropdownCreateTemplate("Переказу"); //  метод для вибору значення дропдауну ПЕРЕКАЗИ

        //              нова сторінка створення шаблону

        pageProvider.getCreateTemplatePage().checkTextCreateTemplateVisible();
        // введення значення Visa Raifcard в допдаун рахунку по дебету
        pageProvider.getCreateTemplatePage().selectTextInDebitAccount("•••• 3859");
        Util.waitABit(20);
        pageProvider.getCreateTemplatePage().clickOnCardNumber(); // клык на роздыл "Номер картки"
        pageProvider.getCreateTemplatePage().enterTextIntoInputCardNumber("1234567890123456"); // вводимо номер картки для зарахування

        //              вводимо суму для зарахування
                   Util.waitABit(20);
        pageProvider.getCreateTemplatePage().checkIsOtherBankVisible(); // перевірка чи є розділ "Інший банк"

        pageProvider.getCreateTemplatePage().entertextIntoInputSum("50"); // вводимо суму для зарахування

        pageProvider.getCreateTemplatePage().clickOnButtonContinue();// клік на кнопку "Продовжити"
        pageProvider.getCreateTemplatePage().checkIsPibOderguvachaVisible();// перевірка чи є розділ "ПІБ одержувача"
        //           Util.waitABit(30);
        pageProvider.getCreateTemplatePage().clickOnButtonContinue();// клік на кнопку "Продовжити"

        // ввожу назву шаблону
        pageProvider.getCreateTemplatePage().enterTextIntoInputTemplateName(nameTemplate);
        // клік на кнопку ЗБЕРЕГТИ
        pageProvider.getCreateTemplatePage().clickOnButtonSave();
        // перевірка чи є повідомлення "Шаблон успішно збережено"
        pageProvider.getCreateTemplatePage().checkIsTemplateSaveVisible();
        // клік на кнопку Закрити після збереження шаблону
        pageProvider.getCreateTemplatePage().clickOnButtonClose();

// перевырка що шаблон з такою назвою створився
        pageProvider.getTemplatessPage().checkIsSearchTemplateVisible(); // перевірка чи є кнопка пошуку шаблону
        pageProvider.getTemplatessPage().checkIsDropdownCreateTemplateVisible(); // перевірка чи є кнопка Створити шаблон
        pageProvider.getTemplatessPage().checkIsTemplateVisible(nameTemplate); // перевірка чи є шаблон з такою назвою


    }

    @After
    public void deleteTemplate() { // видалення шаблону

// метод перевырки відображення дропдауну з назвою шаблону
        pageProvider.getTemplatessPage().checkIsTemplateDropdownVisible(nameTemplate);

// метод вибору "Видалити" з дропдауну конкретного шаблону з назвою "nameTemplate"
        pageProvider.getTemplatessPage().selectTextInTemplateDropdown(nameTemplate, "Видалити");
        pageProvider.getTemplatessPage().cliсkOnButtonOK(); //підтвердження видалення шаблону кнопка ОК

        // метод перевырки выдсутності шаблону з назвою "nameTemplate"
 //       Util.waitABit(20);
 //      pageProvider.getTemplatessPage().checkIsTemplateDropdownNotVisible(nameTemplate);

    }

}