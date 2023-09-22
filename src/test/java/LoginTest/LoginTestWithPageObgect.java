package LoginTest;

import baseTest.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTestWithPageObgect extends BaseTest {

    @Test
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn(); // клік на кнопку Вхід
    //    pageProvider.getHomePage().getDashboard().waitForSpinnerToDisappear(); //!!!!Спінер
        pageProvider.getHomePage().getDashboard().checkIsDashboardVisible(); // перевірка чи є кнопка меню Головна
        pageProvider.getHomePage().getDashboard().checkIsTemplatesVisible(); // перевірка чи є кнопка меню Шаблони

    }

        @Test
        public void inValidLogin() {
            pageProvider.getloginPage().openLoginPage();
            pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
            pageProvider.getloginPage().enterTextIntoInputPassword("Aval#20202020"); // невірний пароль
            pageProvider.getloginPage().clickOnButtonSignIn(); // клік на кнопку Вхід
            pageProvider.getloginPage().isButtonSignInDisplayed(); // перевірка чи є кнопка Вхід
            pageProvider.getloginPage().isInvalidLoginOrPasswordDisplayed(); // перевірка чи є повідомлення про невірний логін чи пароль

        }

    }
