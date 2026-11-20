import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4LogOut {
    static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
        Thread.sleep(3000);
        WebElement uLogIn = driver.findElement(By.id("menu-item-20"));
        uLogIn.click();
        WebElement LoginPage = driver.findElement(By.linkText("Test Login Page"));
        LoginPage.click();
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(3000);

        WebElement LogOut = driver.findElement(By.linkText("Log out"));
        LogOut.click();

        /*
        String expectedLogOut = "https://practicetestautomation.com/";
        String actualLogOut = driver.getCurrentUrl();
        Assert.assertEquals(expectedLogOut, actualLogOut);
         */
        String expLO = "https://practicetestautomation.com/practice-test-login/";
        String actLO = driver.getCurrentUrl();
        Assert.assertEquals(expLO,actLO);
        //ne ide na pocetnu stranicu vec na login stranicu

    }
}
