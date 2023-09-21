package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.dashboard.Dashboard;


public class HomePage extends ParentPageWithDashboard {

    public HomePage(WebDriver webDriver) { // конструктор
        super(webDriver);
    }


    //  метод який буде заміняти логін з валідним логіном і паролем
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


