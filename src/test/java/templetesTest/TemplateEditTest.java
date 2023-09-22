package templetesTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.PageProvider;

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

    public void createNewTemplate() {

        pageProvider.getHomePage().openHomePage() //залогінитись і перевірили
                .getDashboard().clickOnMenuTemplates()// клік на кнопку меню Шаблони
                .checkIsTitleTemplatesVisible() // перевірка чи є заголовок "Шаблони"
//              .checkIsDropdownCreateTemplateVisible(); // перевірка чи є кнопка Створити шаблон ПЕРЕВІРКА ЧИ МИ НА СТОРІНЦІ ШАБЛОНІВ
                .selectTextInDropdownCreateTemplate("Переказу") //  метод для вибору значення дропдауну ПЕРЕКАЗИ
                //нова сторінка створення шаблону
                .checkTextCreateTemplateVisible()// назва вікна "Створення шаблону"
                .selectTextInDebitAccount("•••• 3859"); // введення значення Visa Raifcard в допдаун рахунку по дебету
        Util.waitABit(20);
        pageProvider.getCreateTemplatePage().clickOnCardNumber()// клык на роздыл "Номер картки"
                .enterTextIntoInputCardNumber("1234567890123456"); // вводимо номер картки для зарахування
        Util.waitABit(30);
        pageProvider.getCreateTemplatePage().checkIsOtherBankVisible() // перевірка чи є розділ "Інший банк"
                .entertextIntoInputSum("50") // вводимо суму для зарахування
                .clickOnButtonContinue()// клік на кнопку "Продовжити"
                .checkIsPibOderguvachaVisible()// перевірка чи є розділ "ПІБ одержувача"
                .clickOnButtonContinue()// клік на кнопку "Продовжити"
                .enterTextIntoInputTemplateName(nameTemplate02) // ввожу назву шаблону
                .clickOnButtonSave()// клік на кнопку ЗБЕРЕГТИ
                .checkIsTemplateSaveVisible() // перевірка чи є повідомлення "Шаблон успішно збережено"
                .clickOnButtonClose() // клік на кнопку Закрити після збереження шаблону

// перевырка що шаблон з такою назвою створився
                .checkIsSearchTemplateVisible()// перевірка чи є кнопка пошуку шаблону
                .checkIsTemplateVisible(nameTemplate02); // перевірка чи є шаблон з такою назвою
    }

    @Test // редагування шаблону
    public void editTemplate() {

        pageProvider.getTemplatessPage().selectTextInTemplateDropdown(nameTemplate02, "Редагувати"); // Обираю на дропдауны шаблону "Редагувати"
        pageProvider.getEditTemplatePage().checkIsTitleEditTemplateVisible() // перевырка чи відображається заголовок редагування шаблону
                .clickOnAccountCredit() // обираю роздыіл "Карта або рахунок"
                .clickOnDropdownEditAccounCredit(); // вибираю рахунок з дропдауна по кредиту
        Util.waitABit(30);
        pageProvider.getCreateTemplatePage().entertextIntoInputSum("100"); //редагую суму переказу
        Util.waitABit(30);
        pageProvider.getCreateTemplatePage().entertextIntoInputSum("100");// не знайшла нычого розумнышого
        pageProvider.getEditTemplatePage().clickOnButtonNext(); //ще раз кнопка продовжити
        Util.waitABit(30);
        pageProvider.getEditTemplatePage().clickOnButtonNext() //ще раз кнопка продовжити


                .checkIsTitleNameTemplateVisible();// перевырка выдобрадження назви поля "Назва шаблону"
        pageProvider.getCreateTemplatePage().checkIsButtonSaveVisible()
                .enterTextIntoInputTemplateName(nameTemplateEdit) // ввожу назву шаблону
                .clickOnButtonSave() // клік на кнопку ЗБЕРЕГТИ
                .checkIsTemplateSaveVisible()// перевірка чи є повідомлення "Шаблон успішно збережено"
                .clickOnButtonClose() // клік на кнопку Закрити після збереження шаблону
                //.checkIsSearchTemplateVisible(); // перевірка чи є кнопка пошуку шаблону
                .checkIsDropdownCreateTemplateVisible() // перевірка чи є кнопка Створити шаблон
                .checkIsTemplateVisible(nameTemplateEdit); // перевірка чи є шаблон з такою назвою
    }

    @After
    public void deleteTemplate() { // видалення шаблону

        pageProvider.getTemplatessPage().checkIsTemplateDropdownVisible(nameTemplateEdit) // метод перевырки відображення дропдауну з назвою шаблону
                .selectTextInTemplateDropdown(nameTemplateEdit, "Видалити")
                .clickOnButtonOk(); //підтвердження видалення шаблону кнопка ОК
    }
}
