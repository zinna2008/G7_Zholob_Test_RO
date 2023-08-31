package pages;

//import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsWithElements {

    Logger logger = Logger.getLogger(getClass()); //

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15; //  чекаємо поки елемент буде клікабельний

    public ActionsWithElements(WebDriver webDriver) { // конструктор
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); //initialization of elements
// element in @FindBy
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10)); // чекаємо макс 10с поки елемент буде клікабельний
//        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW())); // чекаємо макс 15с поки елемент буде клікабельний
    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    public void clickOnElement(WebElement element) { //method for clicking on element
        try {
            String elementName = getElementName(element);
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element)); // чекаємо поки елемент буде клікабельний
            element.click();
            logger.info(getElementName(element) + "Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(String locator) { //ме метод для кліку по елементу
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)));
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void enterTextIntoInput(WebElement  input , String text) { // метод для вводу тексту в інпут
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input" + getElementName(input)); // виводимо в консоль інформацію про те що ввели в інпут
        } catch (Exception e) {


            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {  // перевырка чи елемент присутный на дысплеї
        try {

            boolean state = element.isDisplayed();
            if (state) {
                logger.info("Element is displaed");
            } else {
                logger.info("Element is not displaed");

            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displaed");
            return false;
        }
    }

//////????????????????????????? ЕКСПЕРЕМЕНТ
//Метод чекає поки елемент з'явиться на сторінці
public void waitElementIsVisible(WebElement element) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }



    public void checkElementDisplayed(WebElement element) { // перевірка чи елемент присутній на дисплеї
        Assert.assertTrue("Element is not displaed", isElementDisplayed(element));
    }

    public void checkElementNotDisplayed(WebElement element) { // перевірка чи елемент відсутній на дисплеї
        Assert.assertFalse("Element is displaed", isElementDisplayed(element));
    }

    public void selectTextInDropDown(WebElement dropDown, String text) {  // метод для вибору вказаного значення з дропдауну
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) { // якщо вибраного значення немає в дропдауні
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropDown(WebElement dropDown, String value) {  // метод для вибору value значення з дропдауну
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in DropDown");
        } catch (Exception e) { // якщо вибраного значення немає в дропдауні
            printErrorAndStopTest(e);
        }
    }

    public void selectTextInDropDownByUI(WebElement dropDown, String text) {  // ще метод для вибору вказаного значення з дропдауну
        try {
            clickOnElement(dropDown);
            clickOnElement(dropDown.findElement(By.xpath("//*[contains(text(),'" + text + "')]")));
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) { // якщо вибраного значення немає в дропдауні
            printErrorAndStopTest(e);
        }
    }

    public void toMarkCheckBox(WebElement element) { // метод для встановлення чекбокса
        try {
            if (!element.isSelected()) { // якщо чекбокс не вибраний
                element.click(); // вибрати чекбокс
                logger.info("Checkbox was marked");
            } else {
                logger.info("Checkbox is already marked");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void toUnMarkCheckBox(WebElement element) { // метод для зняття чекбокса
        try {
            if (element.isSelected()) { // якщо чекбокс вибраний
                element.click(); // зняти чекбокс
                logger.info("Checkbox was unmarked");
            } else {
                logger.info("Checkbox is already unmarked");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    //

    public void toMarkAndToUnMarkCheckBoxByUI(WebElement element, String text) { // метод для встановлення або зняття чекбокса
        try {
            if (!element.isSelected() && text.equals("check")) { // якщо чекбокс не вибраний
                toMarkCheckBox(element); // вибрати чекбокс
                logger.info("Checkbox was marked");
            } else if (element.isSelected() && text.equals("uncheck")) { // якщо чекбокс вибраний
                toUnMarkCheckBox(element); // зняти чекбокс
                logger.info("Checkbox was unmarked");
            } else {
                logger.info("Checkbox is already marked");
            }

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }


}