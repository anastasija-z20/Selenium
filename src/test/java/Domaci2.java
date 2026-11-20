import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci2 {
    static void main(String[] args) throws InterruptedException {
        //Na sajtu https://the-internet.herokuapp.com/login testirati logovanje
        // koristeci validne i nevalidne kredencijale.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        Thread.sleep(3000);
        WebElement usernamebox = driver.findElement(By.id("username"));
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        usernamebox.click();
        usernamebox.sendKeys(username);
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.click();
        passwordBox.sendKeys(password);
        WebElement submit = driver.findElement(By.className("radius"));
        submit.click();

        WebElement loggedin = driver.findElement(By.cssSelector("div.example>p"));
        String expectedresult = "Logged in as tomsmith";
        Assert.assertEquals(loggedin.getText(),expectedresult);

    }
}
