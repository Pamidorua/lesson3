package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvTest {
    WebDriver driver;

    @DataProvider(name = "dp")
    public Object[][] parseData() {
        return new Object[][] {
                {"https://www.google.com"},
                {"https://duckduckgo.com"}
        };
    }

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "dp")
    public void test(String searchUrl) throws InterruptedException {
        driver.get(searchUrl);
        WebElement element = driver.findElement(By.xpath(".//*[@name='q']"));
        element.sendKeys("Selenium");
        element.submit();
        Thread.sleep(3000);
        System.out.println("Page title is: " + driver.getTitle());
        Thread.sleep(3000);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
