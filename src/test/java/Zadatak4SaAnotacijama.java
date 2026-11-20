import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zadatak4SaAnotacijama {
    WebDriver driver = new ChromeDriver();
@BeforeMethod
    public void topage(){
    WebDriverManager.chromedriver().setup();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.navigate().to("https://practicetestautomation.com/");
    WebElement uLogIn = driver.findElement(By.id("menu-item-20"));
    uLogIn.click();
    WebElement LoginPage = driver.findElement(By.linkText("Test Login Page"));
    LoginPage.click();
}
@Test
    public void logIn(){
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
@AfterMethod
    public void quit(){
    driver.manage().deleteAllCookies();
    driver.quit();
}


}
