import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4IncorrectPassword {
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
        pass.sendKeys("Password1234");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        String expectedResult = "https://practicetestautomation.com/practice-test-login/";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
        Thread.sleep(3000);
        WebElement error = driver.findElement(By.id("error"));
        String expectedText= "Your password is invalid!";
        String actualText = error.getText();
        Assert.assertEquals(actualText, expectedText);
    }
}
