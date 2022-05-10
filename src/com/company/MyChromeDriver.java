package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class MyChromeDriver {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath(".//*[@name='q']"));
        Thread.sleep(3000);
        element.sendKeys("Selenium");
        element.submit();

        Thread.sleep(3000);
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
