import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        //sleepers - ceka toliko vremena koliko mu prosledimo
        //cekanje je fiksno
        //moze se koristiti tokom kreiranja testova
        //ne preporucuje se u praksi da se nalazi ova vrsta cekanja

        //Implicit wait - ceka zadato vreme dok se element ne pojavi
        //kreira se na pocetku projekta

        //Explicit wait - ceka zadato vreme dok se ne ispuni uslov

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu-item-20"))));

        WebElement testLogIn = driver.findElement(By.linkText("Test Login Page"));
        wait.until(ExpectedConditions.elementToBeClickable(testLogIn));
        testLogIn.click();
        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/practice-test-login/"));
    }
}
