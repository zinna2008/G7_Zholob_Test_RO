package LoginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTestWithPageObgect extends BaseTest {

    @Test
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName("zinna2008");
        pageProvider.getloginPage().enterTextIntoInputPassword("Aval#2020");
        pageProvider.getloginPage().clickOnButtonSignIn();
        //TODO перевірка чи ми залогінились
    }

        @Test
        public void inValidLogin() {
            pageProvider.getloginPage().openLoginPage();
            pageProvider.getloginPage().enterTextIntoInputUserName("zinna2008");
            pageProvider.getloginPage().enterTextIntoInputPassword("Aval#20202020"); // невірний пароль
            pageProvider.getloginPage().clickOnButtonSignIn(); // клік на кнопку Вхід
            pageProvider.getloginPage().isButtonSignInDisplayed(); // перевірка чи є кнопка Вхід
            pageProvider.getloginPage().isInvalidLoginOrPasswordDisplayed(); // перевірка чи є повідомлення про невірний логін чи пароль

        }

    }
