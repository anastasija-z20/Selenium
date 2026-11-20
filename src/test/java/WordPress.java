import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WordPress {
    static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://wordpress.com/");

        WebElement logIn = driver.findElement(By.linkText("Log in"));
        logIn.click();
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("usernameOrEmail"));
        username.sendKeys("bruszezelenko@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));





    }
}
