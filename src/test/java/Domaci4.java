import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Domaci4 {
//    https://practice.expandtesting.com/login
//    Odraditi registraciju i login koristeci anotacije
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void sajt(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://practice.expandtesting.com/login");
    }
    @BeforeMethod
    public void before(){

    }
    @Test
    public void registracija() throws InterruptedException {
        WebElement registracija = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.visibilityOf(registracija));
        registracija.click();
        WebElement usernameReg = driver.findElement(By.id("username"));
        usernameReg.click();
        usernameReg.sendKeys("student");
        WebElement passwordReg = driver.findElement(By.id("password"));
        passwordReg.click();
        passwordReg.sendKeys("IamaStudent1");
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.click();
        confirmPassword.sendKeys("IamaStudent1");
        WebElement register = driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div/div/div[2]/div/div/div/form/button"));
        register.click();
    }
    @Test
    public void login() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.click();
        username.sendKeys("practice");
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("SuperSecretPassword!");
        WebElement submit = driver.findElement(By.id("submit-login"));

    }
    @AfterMethod
    public void cookies(){
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}
