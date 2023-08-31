package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider { // клас для повернення сторінки
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) { // конструктор
        this.webDriver = webDriver;
    }

public LoginPage getloginPage() { // метод для повернення сторінки LoginPage
        return new LoginPage(webDriver);
    }
}
