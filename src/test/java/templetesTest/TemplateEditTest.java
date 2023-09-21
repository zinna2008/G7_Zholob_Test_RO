package templetesTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class TemplateEditTest extends BaseTest {

    private String nameTemplate02 = "Inna " + getCurrentTimeAndDate();
        private String nameTemplateEdit = "Inna EDIT_" + getCurrentTimeAndDate();

    private String getCurrentTimeAndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmssyyyyMMdd");
        return sdf.format(new Date());
        }

// в прекандішині весь тест по створенню шаблону
@Before()

public void validLogin() {
    pageProvider.getloginPage().openLoginPage();
    pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
    pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
    pageProvider.getloginPage().clickOnButtonSignIn(); // клік на кнопку Вхід
    //ПЕРЕВІРКА ЧИ МИ НА ГОЛВНІЙ СТОРІНЦІ ПІСЛЯ ЛОГІНУ
    pageProvider.getHomePage().getDashboard().checkIsDashboardVisible(); // перевірка чи є кнопка меню Головна
    pageProvider.getHomePage().getDashboard().checkIsTemplatesVisible(); // перевірка чи є кнопка меню Шаблони
}

    @Test //            редагування шаблону
    public void editTemplate() {
        pageProvider.getHomePage().getDashboard()
                .clickOnMenuTemplates();// клік на кнопку меню Шаблони
        //
        pageProvider.getTemplatessPage().checkIsSearchTemplateVisible(); // перевірка чи є кнопка пошуку шаблону ПЕРЕВІРКА ЧИ МИ НА СТОРІНЦІ ШАБЛОНІВ
        //       Util.waitABit(20);
//        pageProvider.getTemplatessPage().checkIsDropdownCreateTemplateVisible(); // перевірка чи є кнопка Створити шаблон ПЕРЕВІРКА ЧИ МИ НА СТОРІНЦІ ШАБЛОНІВ
        pageProvider.getTemplatessPage().selectTextInDropdownCreateTemplate("Переказу"); //  метод для вибору значення дропдауну ПЕРЕКАЗИ

        //              нова сторінка створення шаблону
        // введення значення Visa Raifcard в допдаун рахунку по дебету
//        pageProvider.getCreateTemplatePage().selectTextInDebitAccount("•••• 0389");
        //перевырка що ми на сторінці створення шаблону
        pageProvider.getCreateTemplatePage().checkTextCreateTemplateVisible();
        Util.waitABit(10);
        pageProvider.getCreateTemplatePage().clickOnCardNumber(); // клык на роздыл "Номер картки"
        pageProvider.getCreateTemplatePage().enterTextIntoInputCardNumber("1234567890123456"); // вводимо номер картки для зарахування

        //              вводимо суму для зарахування
        Util.waitABit(15);
        pageProvider.getCreateTemplatePage().checkIsOtherBankVisible(); // перевірка чи є розділ "Інший банк"

        pageProvider.getCreateTemplatePage().entertextIntoInputSum("50"); // вводимо суму для зарахування

        pageProvider.getCreateTemplatePage().clickOnButtonContinue();// клік на кнопку "Продовжити"
        pageProvider.getCreateTemplatePage().checkIsPibOderguvachaVisible();// перевірка чи є розділ "ПІБ одержувача"
        //           Util.waitABit(30);
        pageProvider.getCreateTemplatePage().clickOnButtonContinue();// клік на кнопку "Продовжити"

        // ввожу назву шаблону
        pageProvider.getCreateTemplatePage().enterTextIntoInputTemplateName(nameTemplate02);
        // клік на кнопку ЗБЕРЕГТИ
        pageProvider.getCreateTemplatePage().clickOnButtonSave();
        // перевірка чи є повідомлення "Шаблон успішно збережено"
        pageProvider.getCreateTemplatePage().checkIsTemplateSaveVisible();
        // клік на кнопку Закрити після збереження шаблону
        pageProvider.getCreateTemplatePage().clickOnButtonClose();

        // перевырка що шаблон з такою назвою створився
        pageProvider.getTemplatessPage().checkIsSearchTemplateVisible(); // перевірка чи є кнопка пошуку шаблону
        pageProvider.getTemplatessPage().checkIsDropdownCreateTemplateVisible(); // перевірка чи є кнопка Створити шаблон
        pageProvider.getTemplatessPage().checkIsTemplateVisible(nameTemplate02); // перевірка чи є шаблон з такою назвою

        // Редагування новоствореного шаблону ///////////////////////////////////////////////////////////////////////

        // Обираю на дропдауны шаблону "Редагувати"
        pageProvider.getTemplatessPage().selectTextInTemplateDropdown(nameTemplate02, "Редагувати");
        // перевырка чи відображається заголовок редагування шаблону
        pageProvider.getEditTemplatePage().checkIsTitleEditTemplateVisible();
        // обираю роздыіл "Карта або рахунок"
        pageProvider.getEditTemplatePage().clickOnAccountCredit();
        // вибираю рахунок з дропдауна по кредиту
        pageProvider.getEditTemplatePage().clickOnDropdownEditAccounCredit();
//
        //редагую суму переказу
        Util.waitABit(30);
        //перевірка чи відображається input для введення суми
 //       pageProvider.getCreateTemplatePage().clicOninputSum();
        pageProvider.getCreateTemplatePage().entertextIntoInputSum("100");
        Util.waitABit(30);
        pageProvider.getCreateTemplatePage().entertextIntoInputSum("100");
        //ще раз кнопка продовжити
        pageProvider.getEditTemplatePage().clickOnButtonNext();
        Util.waitABit(30);

 //       Util.waitABit(30);
        //ще раз кнопка продовжити
        pageProvider.getEditTemplatePage().clickOnButtonNext();


        // тут багато чого з минулого тесту //////////////////////////////////////////////////////////////////

        pageProvider.getEditTemplatePage().checkIsTitleNameTemplateVisible();// выдобрадження назви поля "Назва шаблону"
        // ввожу назву шаблону
        pageProvider.getCreateTemplatePage().enterTextIntoInputTemplateName(nameTemplateEdit);
        // клік на кнопку ЗБЕРЕГТИ
        pageProvider.getCreateTemplatePage().clickOnButtonSave();
        // перевірка чи є повідомлення "Шаблон успішно збережено"
        pageProvider.getCreateTemplatePage().checkIsTemplateSaveVisible();
        // клік на кнопку Закрити після збереження шаблону
        pageProvider.getCreateTemplatePage().clickOnButtonClose();

// перевырка що шаблон з такою назвою створився
 //       pageProvider.getTemplatessPage().checkIsSearchTemplateVisible(); // перевірка чи є кнопка пошуку шаблону
        pageProvider.getTemplatessPage().checkIsDropdownCreateTemplateVisible(); // перевірка чи є кнопка Створити шаблон
        pageProvider.getTemplatessPage().checkIsTemplateVisible(nameTemplateEdit); // перевірка чи є шаблон з такою назвою


    }

    @After
    public void deleteTemplate() { // видалення шаблону

// метод перевырки відображення дропдауну з назвою шаблону
        pageProvider.getTemplatessPage().checkIsTemplateDropdownVisible(nameTemplateEdit);

// метод вибору "Видалити" з дропдауну конкретного шаблону з назвою "nameTemplate"
        pageProvider.getTemplatessPage().selectTextInTemplateDropdown(nameTemplateEdit, "Видалити");
        pageProvider.getTemplatessPage().cliсkOnButtonOK(); //підтвердження видалення шаблону кнопка ОК

        // метод перевырки выдсутності шаблону з назвою "nameTemplate"
        //       Util.waitABit(20);
        //      pageProvider.getTemplatessPage().checkIsTemplateDropdownNotVisible(nameTemplate);

    }
}

