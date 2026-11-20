import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak6 {


    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://practicetestautomation.com/");
    }
    @BeforeMethod
    public void sajt() throws InterruptedException {

        WebElement uLogIn = driver.findElement(By.id("menu-item-20"));
        uLogIn.click();
        WebElement LoginPage = driver.findElement(By.linkText("Test Login Page"));
        LoginPage.click();
    }
    @Test(priority = 1)
    public void LogInSaValid(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        WebElement titl = driver.findElement(By.className("post-title"));
        String actualtitle = titl.getText();
        String expectedtitle = "Logged In Successfully";
        Assert.assertEquals(actualtitle, expectedtitle);
    }
    @Test(priority = 2)
    public void LogOut(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Password123");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        WebElement LogOut = driver.findElement(By.linkText("Log out"));
        LogOut.click();
    }
    @Test(priority = 5)
    public void nevalidniKredencijali(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student1");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Password1234");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        WebElement error = driver.findElement(By.id("error"));
        String expectedText= "Your username and password are invalid!";
        String actualText = error.getText();
        Assert.assertTrue(error.isDisplayed());
    }
    @Test(priority = 3)
    public void invalidUsername() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student1");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Password123");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(3000);
        WebElement error = driver.findElement(By.id("error"));
        String expectedText= "Your username is invalid!";
        String actualText = error.getText();
        Assert.assertEquals(actualText, expectedText);
    }
    @Test(priority = 4)
    public void invalidPass() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Password1234");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(3000);
        WebElement error = driver.findElement(By.id("error"));
        String expectedText= "Your password is invalid!";
        Assert.assertEquals(error.getText(), expectedText);
    }
    @AfterMethod
    public void quit() throws InterruptedException {
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
