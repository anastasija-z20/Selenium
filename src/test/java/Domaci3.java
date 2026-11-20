import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Domaci3 {
    static void main(String[] args) {
        //Koristite https://the-internet.herokuapp.com/dynamic_loading/2, gde se
        // element pojavljuje tek posle klika. Kliknite na dugme Start i sačekajte
        // da se pojavi tekst “Hello World!“.
        //Za ovaj zadatak koristiti asertacije i waitere
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button"));
        startButton.click();

        WebElement actualResult = driver.findElement(By.id("finish"));
        String expectedResult = "Hello World!";
        Assert.assertEquals(actualResult.getText(), expectedResult);
    }
}
