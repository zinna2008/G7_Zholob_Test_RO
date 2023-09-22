package pages;

import org.openqa.selenium.WebDriver;
import pages.dashboard.Dashboard;

public class ParentPageWithDashboard extends ParentPage {
    org.openqa.selenium.WebDriver
            WebDriver;

    public ParentPageWithDashboard(WebDriver webDriver) { // конструктор

        super(webDriver);
    }
    public Dashboard getDashboard() { // метод для повернення сторінки Dashboard
        return new Dashboard(webDriver);
    }

    };


