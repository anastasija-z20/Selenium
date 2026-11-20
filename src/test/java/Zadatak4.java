import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4 {
    static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Zadatak 4
//Na linku https://practicetestautomation.com/ otici do login stranice,
// uradite log in i dodajte asertacije
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

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(actualURL, expectedURL);

        WebElement titl = driver.findElement(By.className("post-title"));
        String actualtitle = titl.getText();
        String expectedtitle = "Logged In Successfully";
        Assert.assertEquals(actualtitle, expectedtitle);

    }
}
