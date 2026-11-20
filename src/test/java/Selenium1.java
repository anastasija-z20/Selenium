import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //postavlja se drajver
        WebDriver driver = new ChromeDriver();
        //kreira se objekat u kom cemo davati komande
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.youtube.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.quit();

    }
}
