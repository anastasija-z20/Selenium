import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    static void main(String[] args) {
        ChromeDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.linkedin.com");
        driver.navigate().refresh();
        driver.navigate().to("https://www.joberty.com");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
