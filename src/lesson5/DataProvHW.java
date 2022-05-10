package lesson5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DataProvHW {
    WebDriver driver;

    @DataProvider(name = "BrowserProvider")
    public Object[][] parseData() {
        return new Object[][] {
                {Browsers.CHROME},
                {Browsers.FIREFOX}
        };

}
@Test (dataProvider = "BrowserProvider")
    public void testhw (Browsers browsers) throws InterruptedException {
        driver = getDriver(browsers);
        driver.get("https://www.google.com");
    Thread.sleep(3000);
    WebElement element = driver.findElement(By.xpath(".//*[@name='q']"));
    Thread.sleep(3000);
    element.sendKeys("Selenium");
    element.submit();

    Thread.sleep(3000);
    System.out.println("Page title is: " + driver.getTitle());


}

    enum Browsers { CHROME, FIREFOX}

    public static WebDriver getDriver (Browsers browsers) {



        switch (browsers) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/chromedriver");
                return new ChromeDriver();

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/geckodriver");
                return new FirefoxDriver();



            default:
                return new FirefoxDriver();

        }


    }

}
