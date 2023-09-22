package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;

import java.time.Duration;

import static java.time.Duration.*;

public class BaseTest {
    WebDriver webDriver;
    protected PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());


    @Before  // анотація для того щоб метод setUp() запускався перед кожним тестом
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(); // ініціалізуємо драйвер
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(ofSeconds(40)); // чекаємо макс 60с поки елемент буде клікабельний
        // намагається клікнути на елемент кожні 500мс, якщо вийде відразуйди далі
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver); // ініціалізуємо сторінку

    }

    @After // анотація для того щоб метод tearDown() запускався після кожного тесту
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }

}
