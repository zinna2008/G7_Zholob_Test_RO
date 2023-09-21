package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.dashboard.Dashboard;


public class HomePage extends ParentPageWithDashboard {
    //  private org.openqa.selenium.WebDriver
    //          WebDriver;

    @FindBy(xpath = ".//li[@class='templates']") // меню Шаблони
    private WebElement menuTemplates;

// роблю метод який буде заміняти логін з валідним логіном і паролем
    public HomePage(WebDriver webDriver) { // конструктор
        super(webDriver);
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginWithValidUserEndPassvord(); //логінюсь з валідним логіном і паролем
        checkToHomePage(); // перевіряю чи відображається домашня сторінка
        return this;
    }

    private HomePage checkToHomePage() {
        getDashboard().checkIsDashboardVisible();
        getDashboard().checkIsTemplatesVisible();
        return this;
    }


}


