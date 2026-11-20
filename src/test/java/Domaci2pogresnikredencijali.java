import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci2pogresnikredencijali {
    static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        Thread.sleep(3000);
        WebElement usernamebox = driver.findElement(By.id("username"));
        String username = "tomsmit";
        String password = "SuperSecretPassword!";
        usernamebox.click();
        usernamebox.sendKeys(username);
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.click();
        passwordBox.sendKeys(password);
        WebElement submit = driver.findElement(By.className("radius"));
        submit.click();

        WebElement flashMessage = driver.findElement(By.cssSelector("#flash.error"));
        String expectedResult = "Your username is invalid!";
        Assert.assertTrue(flashMessage.getText().contains(expectedResult));
    }
}
