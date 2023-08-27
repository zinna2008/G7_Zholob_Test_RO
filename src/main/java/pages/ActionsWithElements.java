package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithElements {
    protected WebDriver webDriver; // оголошуємо змінну webDriver

    public ActionsWithElements(WebDriver webDriver) { // конструктор
        this.webDriver = webDriver;
    }

    public void openPage(String url) { // метод для відкриття сторінки
        try {
            webDriver.get(url);
            System.out.println("Page was opened" + url); // виводимо повідомлення про відкриття сторінки
        } catch (Exception e) {
            System.out.println("Can not open " + url); // виводимо повідомлення про невдале відкриття сторінки
            Assert.fail("Can not open " + url);
        }
    }


    public  void enterTextIntoInput(WebElement input, String text) { // метод для вводу тексту в інпут
        try {
            input.clear();
            input.sendKeys(text);
            System.out.println(text + " was inputted into input");
        } catch (Exception e) {
           printErrorAndStopTest(e); // виводимо повідомлення про невдале введення тексту в інпут
        }
    }

    public void clickOnElement(WebElement element) { // метод для кліку по елементу
        try {
            element.click();
            System.out.println("Element was clicked"); // виводимо повідомлення про клік по елементу
        } catch (Exception e) {
            printErrorAndStopTest(e); // виводимо повідомлення про невдале клікання по елементу
        }
    }

    public boolean isElementDisplayed(WebElement element) {  // перевірка чи елемент присутний на дисплеї
        try {
            boolean state = element.isDisplayed();
            if (state) {
                System.out.println("Element is displaed"); // виводимо повідомлення про те що елемент присутній на дисплеї
            } else {
                System.out.println("Element is not displaed"); // виводимо повідомлення про те що елемент не присутній на дисплеї
            }
            return state;
        } catch (Exception e) {
            System.out.println("Element is not displaed"); // виводимо повідомлення про те що елемент не присутній на дисплеї
            return false;
        }
    }


    private void printErrorAndStopTest(Exception e) { // метод для виводу повідомлення про помилку
        System.out.println("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }


}
