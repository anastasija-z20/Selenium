import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Selenium6 {
    static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> cards = driver.findElements(By.className("card"));

        Thread.sleep(3000);
        for (int i = 0; i < cards.size(); i++) {

            if (cards.get(i).getText().contains("Forms")) {
                js.executeScript("arguments[0].click();", cards.get(i));

                break;
            }
        }

    }
}
