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
    public HomePage getHomePage() { // метод для повернення сторінки HomePage
        return new HomePage(webDriver);
    }

    public CreateTemplatePage getCreateTemplatePage() { // метод для повернення сторінки CreateTemplatePage
        return new CreateTemplatePage(webDriver);
    }


   public ТemplatessPage getTemplatessPage() { // метод для повернення сторінки Templates
         return new ТemplatessPage(webDriver);
    }


}

