package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.util.HashMap;
import java.util.Map;

class HW4enum {
    public static void main(String[] args) throws InterruptedException {

        WebDriver browser =  getDriver(Browsers.FIREFOX);
        browser.get("https://www.google.com/");
        Thread.sleep(3000);
        WebElement element = browser.findElement(By.xpath(".//*[@name='q']"));
        Thread.sleep(2000);
        element.sendKeys("Selenium");
        element.submit();

        Thread.sleep(2000);
        System.out.println("Page title is: " + browser.getTitle());



    }

    enum Browsers { CHROME, FIREFOX, CHROME_MOB, FIREFOX_MOB }

    public static WebDriver getDriver (Browsers browsers) {



        switch (browsers) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/chromedriver");
                return new ChromeDriver();

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/geckodriver");
                return new FirefoxDriver();

            case CHROME_MOB:
                System.setProperty("webdriver.chrome.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/chromedriver");
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 5");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                return new ChromeDriver(chromeOptions);

            case FIREFOX_MOB:
                System.setProperty("webdriver.gecko.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/geckodriver");


                final String userAgent =
                        "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 "
                                + "(KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16";
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("general.useragent.override", userAgent);
                return new FirefoxDriver(firefoxOptions);

            default:
                return new FirefoxDriver();

        }


    }
}













