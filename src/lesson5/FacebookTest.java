package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FacebookTest {
    WebDriver driver;
    WebElement firstNameField;
    WebElement lastNameField;
    WebElement etMobileNumberEmail;
    WebElement etEmailConfitm;
    WebElement etNewPassword;
    Select drMonth;
    Select drDay;
    Select drYear;
    WebElement gender;
    String name = "Roma";
    String lastname = "Kapur";
    String mobileNumberEmail = "tester@tester.tester";
    String emailConfirm = "tester@tester.tester";
    String passwrordCheck = "Kitzen18!";






    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/chromedriver");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("chrome.switches", Arrays.asList("--disable-javascript"));
        driver = new ChromeDriver(caps);

    }

    @Test (priority = 0)
    public void goToRegistrationPage () throws InterruptedException{
        driver.get("https://www.facebook.com/");


        WebElement addAccount = driver.findElement(By.xpath(".//*[@data-testid='open-registration-form-button']"));
        addAccount.click();
        Thread.sleep(3000);
    }

    @Test (priority = 1)
    public void field ()  throws InterruptedException {
        firstNameField = driver.findElement(By.xpath(".//*[@name ='firstname']"));
        firstNameField.click();
        firstNameField.sendKeys("Roma");


        lastNameField = driver.findElement(By.xpath(".//*[@name='lastname']"));
        lastNameField.sendKeys("Kapur");

        etMobileNumberEmail = driver.findElement(By.xpath(".//*[@name='reg_email__']"));
        etMobileNumberEmail.sendKeys("tester@tester.tester");

        etEmailConfitm = driver.findElement(By.name("reg_email_confirmation__"));
        etEmailConfitm.sendKeys("tester@tester.tester");

        etNewPassword = driver.findElement(By.xpath(".//*[@name='reg_passwd__']"));
        etNewPassword.sendKeys("Kitzen18!");


        drMonth = new Select(driver.findElement(By.name("birthday_month")));
        drMonth.selectByValue("7");

        drDay = new Select(driver.findElement(By.name("birthday_day")));
        drDay.selectByValue("20");

        drYear = new Select(driver.findElement(By.name("birthday_year")));
        drYear.selectByValue("1995");


        gender = driver.findElement(By.xpath("//input[@value='2']"));
        gender.click();

        Thread.sleep(4000);
    }


@Test (priority = 2)
    public void checkFields () throws InterruptedException {
       Assert.assertEquals( firstNameField.getAttribute("value"), name);
       Assert.assertEquals(lastNameField.getAttribute("value"), lastname);
       Assert.assertEquals(etMobileNumberEmail.getAttribute("value"), mobileNumberEmail);
       Assert.assertEquals(etEmailConfitm.getAttribute("value"), emailConfirm);
       Assert.assertEquals(etNewPassword.getAttribute("value"), passwrordCheck);
       Assert.assertEquals(drMonth.getFirstSelectedOption().getText(), "июл");
       Assert.assertEquals(drDay.getFirstSelectedOption().getText(), "20");
       Assert.assertEquals(drYear.getFirstSelectedOption().getText(), "1995");
       Assert.assertEquals(gender.getAttribute("value"),"2");



    }

    @Test (priority = 3)
    public void button () {
        boolean check = driver.findElement(By.name("websubmit")).isDisplayed();
        Assert.assertTrue(check);
    }

   // @AfterTest
          //  public void finishTest () {
      //  driver.quit();

    }



