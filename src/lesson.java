import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class lesson {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/romankapur/IdeaProjects/lesson3/sources/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");

        WebElement etSearchfield = driver.findElement(By.xpath(".//*[name = 'q']"));
        etSearchfield.sendKeys("Selenium");

        etSearchfield.submit();

        Thread.sleep(20_000);
        System.out.println("Page title is " +driver.getTitle());

        driver.quit();
    }


}
