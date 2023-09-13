package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void enterTextIntoInputUserName(String userName) { // метод для введення логіна
        enterTextIntoInput(inputUserNane, userName);

    }

    public void enterTextIntoInputPassword(String password) { // метод для введення пароля
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonSignIn() { // метод для кліку на кнопку ВХІД
        clickOnElement(buttonSignIn);
    } // метод для кліку на кнопку ВХІД

// метод для перевірки чи відображається повідомлення 'Введено невірний логін або пароль"
    public void isInvalidLoginOrPasswordDisplayed() { // метод для перевірки чи відображається повідомлення 'Введено невірний логін або пароль"
        checkElementDisplayed(invalidLoginOrPassword);
    } //

        public void isButtonSignInDisplayed() {
            checkElementDisplayed(buttonSignIn);// метод для перевірки чи відображення кнопка ВХІД


    }
}
