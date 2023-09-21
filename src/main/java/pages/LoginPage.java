package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.dashboard.Dashboard;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@id='id8']") // введення логіна
    private WebElement inputUserNane;

    @FindBy(xpath = ".//input[@id='ida']") // введення пароля
    private WebElement inputPassword;

    @FindBy(xpath = ".//*[@id='id7']") // кнопка ВХІД
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//li[@class='feedbackPanelERROR']") //Повідомлення 'Введено невірний логін або пароль"
    private WebElement invalidLoginOrPassword;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    } // конструктор

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public LoginPage enterTextIntoInputUserName(String userName) { // метод для введення логіна
        enterTextIntoInput(inputUserNane, userName);
        return this;
    }

    public LoginPage enterTextIntoInputPassword(String password) { // метод для введення пароля
        enterTextIntoInput(inputPassword, password);
        return this;
    }

    public HomePage clickOnButtonSignIn() { // метод для кліку на кнопку ВХІД
        clickOnElement(buttonSignIn);
        return new HomePage(webDriver);
    }

    public LoginPage isInvalidLoginOrPasswordDisplayed() { // метод для перевірки чи відображається повідомлення 'Введено невірний логін або пароль"
        checkElementDisplayed(invalidLoginOrPassword);
        return this;
    }

    public LoginPage isButtonSignInDisplayed() {
        checkElementDisplayed(buttonSignIn); // метод для перевірки  відображення кнопки ВХІД
        return this;
    }

    //метод логіна з валідними логіном і паролем
    public void loginWithValidUserEndPassvord() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }

}

