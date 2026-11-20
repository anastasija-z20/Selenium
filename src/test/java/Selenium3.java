import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium3 {
    static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://bing.com/");

        Thread.sleep(3000);
        //mora da se ukuca koliko da se saceka da bi se stranica loadovala
        driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea")).sendKeys("ITBootcamp");
        driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[4]/main/ol/li[1]/h2/a")).click();
        //lokatori
    }
}
